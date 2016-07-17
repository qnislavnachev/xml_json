package com.clouway;

import com.fasterxml.jackson.core.type.TypeReference;


import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class Codec {
  public List<User> users;
  private ListOfObjects listOfObjects = new ListOfObjects();

  public List<User> unmarshallFile(String fileExtention, String filename) throws FileNotFoundException, JAXBException {
    if (fileExtention.equals("json")) {
      return unmarshallFileJson(filename);
    }
    if (fileExtention.equals("xml")) {
      return unmarshallFileXML(filename);
    }
    return users;
  }

  private List<User> unmarshallFileJson(String filename) throws FileNotFoundException {
    JsonCodec jsonCodec = new JsonCodec();
    try {
      InputStream inputStream = new FileInputStream(new File(filename));
      users = jsonCodec.unmarshall(new TypeReference<List<User>>() {
      }, inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return users;
  }

  private List<User> unmarshallFileXML(String filename) throws JAXBException {
    XmlCodec xmlCodec = new XmlCodec(listOfObjects, new User());
    return (List<User>) xmlCodec.unmarshall(filename);
  }
}
