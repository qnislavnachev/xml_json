package com.clouway;

import org.junit.Test;

import java.io.File;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class XmlOperationsToMarshallAndUnmarshallObjects {
  XmlOperations xmlOperations = new XmlOperations();
  ListOfObjects listOfObjects = new ListOfObjects();

  @Test
  public void marshallSingleObjectToFile() throws Exception {
    listOfObjects.add(new Product(1, "apple", 1.0d));
    xmlOperations.marshallListOfObjectsToXMLFile(listOfObjects, "somexmlfile");

  }
}
