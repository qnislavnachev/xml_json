package com.clouway;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class Operation {
  String[] arguments;
  Codec codec = new Codec();

  public Operation(String[] arguments) {
    this.arguments = arguments;
  }

  public String compile() throws FileNotFoundException, JAXBException {
    String operationResult = "";
    String extention = "";
    XmlCodec xmlCodec = new XmlCodec(new ListOfObjects(), new User());
    JsonCodec jsonCodec = new JsonCodec();
    if (arguments[0].equals("-type")) {
      if (arguments[1].equals("xml")) {
        extention = arguments[1];
      }
      if (arguments[1].equals("json")) {
        extention = arguments[1];
      }
    }
    if (arguments[3].equals("--printAverageStats")) {
      operationResult = printAverageStats(codec.unmarshallFile(extention, arguments[2]));
    }
    return operationResult;
  }

  private String printAverageStats(List users) {
    Integer averageStats = 0;
    Integer listSize = users.size();
    List<User> listOfUsers = new LinkedList<User>();
    for (int i = 0; i < listSize; i++) {
      listOfUsers.add((User) users.get(i));
    }
    for (User user : listOfUsers) {
      averageStats += user.getAge();
    }
    return "User count: " + listSize + "\nAverage Age: " + averageStats / listSize;
  }
}



