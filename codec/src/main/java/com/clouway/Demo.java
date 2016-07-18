package com.clouway;

import com.fasterxml.jackson.core.type.TypeReference;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class Demo {
  public static void main(String[] args) throws IOException, JAXBException {
    XmlCodec xmlCodec=new XmlCodec();
    String result=xmlCodec.marshall(new TestUser("Vasil","Mitov",24));
    System.out.println(result);
    InputStream stream = new ByteArrayInputStream(result.getBytes("UTF-8"));
    TestUser user=xmlCodec.unmarshall(new TypeReference<TestUser>(){},stream);
    System.out.println(user);
  }
}
