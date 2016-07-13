package com.clouway;

import org.junit.Test;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class SpeedAndFileSizeTest {
  ListOfObjects listOfObjects=new ListOfObjects();
  XmlCodec xmlCodec=new XmlCodec(listOfObjects,new Product());
  JsonCodec jsonCodec=new JsonCodec();
  @Test
  public void marshallingLargeList() throws Exception {
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));
    listOfObjects.add(new Product(1,"apple",1.0d));

    long startTimeXMLSerialisation = System.nanoTime();
    xmlCodec.marshall(listOfObjects,"bigFile");
    long endTimeXMLSerialisation = System.nanoTime();
    System.out.println("Time for xml  serialisation in ms: "+(endTimeXMLSerialisation-startTimeXMLSerialisation)+". File is 10,9kB");


    long startTimeJson=System.nanoTime();
    jsonCodec.marshall(listOfObjects,"bigFile");
    long endTimeJson=System.nanoTime();
    System.out.println("Time for json serialisation in ms: "+(endTimeJson-startTimeJson)+". File is 3,3kB");

    long startTimeXMLDeserialisation = System.nanoTime();
    xmlCodec.unmarshall("bigFile");
    long endTimeXMLDeserialisation = System.nanoTime();
    System.out.println("Time for xml  deserialisation in ms: "+(endTimeXMLDeserialisation-startTimeXMLDeserialisation));

    long startTimeJsonDeserialisation = System.nanoTime();
    xmlCodec.unmarshall("bigFile");
    long endTimeJsonDeserialisation = System.nanoTime();
    System.out.println("Time for json deserialisation in ms: "+(endTimeJsonDeserialisation-startTimeJsonDeserialisation));

  }
}
