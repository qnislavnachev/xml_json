package com.clouway;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sun.org.apache.bcel.internal.classfile.Code;

import javax.xml.bind.JAXBException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class Run {
  private String[] arguments;
  private Codec codec;

  public Run(String[] arguments) {
    this.arguments = arguments;
  }

  public String compile() throws FileNotFoundException {
    String type = arguments[0];
    String extention = arguments[1];
    String file = arguments[2];
    codec = CodecFactory.setupCodec(extention);
    List<User> list = codec.unmarshall(new TypeReference<List<User>>() {
    }, fileStream(file));
    return printAverageStats(list);
  }

  private InputStream fileStream(String fileName) {
    try {
      return new FileInputStream(fileName);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }

  private String printAverageStats(List<User> users) {
    Integer averageStats = 0;

    for (User user : users) {
      averageStats += user.getAge();
    }
    return "User count: " + users.size() + "\nAverage Age: " + averageStats / users.size();
  }
}



