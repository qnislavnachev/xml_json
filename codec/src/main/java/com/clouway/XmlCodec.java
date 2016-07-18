package com.clouway;

import com.fasterxml.jackson.core.type.TypeReference;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;


/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class XmlCodec implements Codec {
  public String marshall(Object object) throws IOException, JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
    Marshaller marshaller = jaxbContext.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    StringWriter stringWriter = new StringWriter();
    marshaller.marshal(object, stringWriter);
    return stringWriter.toString();
  }

  public <T> T unmarshall(TypeReference<T> type, InputStream stream) throws IOException, JAXBException {
    Class<? extends TypeReference> aClass = type.getClass();
    JAXBContext jaxbContext = JAXBContext.newInstance(aClass);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    return (T) unmarshaller.unmarshal(stream);
  }
}
