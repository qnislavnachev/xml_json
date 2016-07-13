package com.clouway;

import org.junit.Test;


import java.nio.charset.StandardCharsets;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class XmlCodecTest {
  private ListOfObjects listOfObjects = new ListOfObjects();
  private XmlCodec xmlCodec = new XmlCodec(listOfObjects, new Product());
  private FileReaderForTest fileReaderForTest = new FileReaderForTest();

  @Test
  public void marshall() throws Exception {
    listOfObjects.add(new Product(1, "apple", 1.0d));
    listOfObjects.add(new Product(2, "pear", 2.2d));
    listOfObjects.add(new Product(3, "orange", 3.3d));
    xmlCodec.marshall(listOfObjects, "testXML");
    assertThat(fileReaderForTest.readFile("testXML.xml", StandardCharsets.UTF_8), is("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><products><product xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"product\"><id>1</id><productName>apple</productName><productPrice>1.0</productPrice></product><product xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"product\"><id>2</id><productName>pear</productName><productPrice>2.2</productPrice></product><product xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"product\"><id>3</id><productName>orange</productName><productPrice>3.3</productPrice></product></products>"));
  }

  @Test
  public void unmarshall() throws Exception {
    listOfObjects.add(new Product(1, "apple", 1.0d));
    listOfObjects.add(new Product(2, "tomato", 2.2d));
    listOfObjects.add(new Product(3, "potato", 3.3d));
    xmlCodec.marshall(listOfObjects, "testXMLUnmarshall");
    assertThat(xmlCodec.unmarshall("testXMLUnmarshall").toString(), is(xmlCodec.marshall(listOfObjects, "testXMLUnmarshall").toString()));
  }
}
