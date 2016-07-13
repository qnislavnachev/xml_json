package com.clouway;

import org.junit.Test;


import java.nio.charset.StandardCharsets;

import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class JsonCodecTest {
  JsonCodec jsonCodec = new JsonCodec();
  ListOfObjects listOfObjects = new ListOfObjects();
  FileReaderForTest fileReaderForTest = new FileReaderForTest();

  /**
   * HappyPath
   *
   * @throws Exception
   */
  @Test
  public void marshall() throws Exception {
    listOfObjects.add(new Product(1, "apple", 1.0d));
    listOfObjects.add(new Product(2, "pear", 2.0d));
    listOfObjects.add(new Product(3, "peach", 3.0d));
    jsonCodec.marshall(listOfObjects, "jsonMarshalledList");
    assertThat(fileReaderForTest.readFile("jsonMarshalledList.json", StandardCharsets.UTF_8), is("{\"objects\":[{\"id\":1,\"productName\":\"apple\",\"productPrice\":1.0},{\"id\":2,\"productName\":\"pear\",\"productPrice\":2.0},{\"id\":3,\"productName\":\"peach\",\"productPrice\":3.0}]}"));
  }

  @Test
  public void unmarshall() throws Exception {
    listOfObjects.add(new Product(1, "apple", 1.0d));
    listOfObjects.add(new Product(2, "pear", 2.0d));
    listOfObjects.add(new Product(3, "peach", 3.0d));
    ListOfObjects unmarshalledListForTest=new ListOfObjects();
    unmarshalledListForTest=jsonCodec.unmarshall("jsonMarshalledList");
    assertThat(jsonCodec.unmarshall("jsonMarshalledList").toString(),is(unmarshalledListForTest.toString()));
  }
}
