package com.clouway;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
class Run {
  private String[] arguments;

  Run(String[] arguments) {
    this.arguments = arguments;
  }

  /**
   * Takes the args[] from public static void main and depending on them makes a codec and dose an operation print average stats.
   * @return A string representation of the result of the operation.
   * @throws FileNotFoundException
   */
  String compile() throws FileNotFoundException {
    String extention = arguments[1];
    String file = arguments[2];
    Codec codec = CodecFactory.getCodec(extention);
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



