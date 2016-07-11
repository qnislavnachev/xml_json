package com.clouway;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;


/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class Demo {
  public static void main(String[] args) throws JAXBException, FileNotFoundException {
    XmlOperations XmlOperations = new XmlOperations();

    ListOfObjects newObjects=new ListOfObjects();
    newObjects.add(new Product(1, "apple", 1.0d));
    newObjects.add(new Product(2, "pear", 1.0d));
    newObjects.add(new Product(3, "orange", 1.0d));


    XmlOperations.marshallListOfObjectsToXMLFile(newObjects,"firstTry");
    System.out.println(XmlOperations.unmarshallXMLFileToString("firstTry"));

  }
}
