package com.clouway;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;



/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class XmlCodec {
  private ListOfObjects container;
  private Object containedObjects;

  public XmlCodec(ListOfObjects container, Object containedObjects) {
    this.container = container;
    this.containedObjects = containedObjects;
  }

  public ListOfObjects marshall(ListOfObjects objects, String fileName) throws JAXBException, FileNotFoundException {
    JAXBContext jaxbContext = JAXBContext.newInstance(container.getClass(), containedObjects.getClass());
    Marshaller marshaller = jaxbContext.createMarshaller();
    OutputStream os = new FileOutputStream(new File(fileName + ".xml"));
    marshaller.marshal(objects, os);


    return objects;
  }

  public ListOfObjects unmarshall(String fileName) throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(container.getClass(), containedObjects.getClass());
    Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
    ListOfObjects unmarshalledList = new ListOfObjects();
    return unmarshalledList = (ListOfObjects) unMarshaller.unmarshal(new File(fileName + ".xml"));
  }


}
