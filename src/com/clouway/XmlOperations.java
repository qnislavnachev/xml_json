package com.clouway;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import static javafx.scene.input.KeyCode.T;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class XmlOperations {
  public void marshallListOfObjectsToXMLFile(ListOfObjects objects, String fileName) throws JAXBException, FileNotFoundException {
    JAXBContext jaxbContext = JAXBContext.newInstance(ListOfObjects.class, Product.class);
    Marshaller marshaller = jaxbContext.createMarshaller();
    OutputStream os = new FileOutputStream(new File(fileName + ".xml"));
    marshaller.marshal(objects, os);

  }

  public String unmarshallXMLFileToString(String fileName) throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(ListOfObjects.class, Product.class);
    Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
    String objectContent = unMarshaller.unmarshal(new File(fileName + ".xml")).toString();
    return objectContent;
  }


}
