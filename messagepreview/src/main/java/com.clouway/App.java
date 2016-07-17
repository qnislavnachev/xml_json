package com.clouway;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class App {
  public static void main(String[] args) throws FileNotFoundException, JAXBException {
    Operation operation = new Operation(args);
    System.out.println(operation.compile());
  }
}
