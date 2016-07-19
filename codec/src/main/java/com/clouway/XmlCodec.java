package com.clouway;

import com.fasterxml.jackson.core.type.TypeReference;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.io.StringWriter;


/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class XmlCodec implements Codec {
  public String marshall(Object object) {
    StringWriter stringWriter = new StringWriter();
    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
      Marshaller marshaller = jaxbContext.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      marshaller.marshal(object, stringWriter);
    } catch (JAXBException e) {
      e.printStackTrace();
    }
    return stringWriter.toString();
  }

  public <T> T unmarshall(final TypeReference<T> type, InputStream stream) {
    try {
      JAXBContext jaxbContext = JAXBContext.newInstance((Class) type.getType());
      Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
      return (T) unmarshaller.unmarshal(stream);
    } catch (JAXBException e) {
      e.printStackTrace();
    }
    return null;
  }
}
