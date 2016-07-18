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
public class CodecHandler {
  public List<User> users;

  public List<User> unmarshallFile(String filename) throws FileNotFoundException {
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

}
