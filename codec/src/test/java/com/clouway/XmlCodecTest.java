package com.clouway;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Type;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class XmlCodecTest {
  XmlCodec xmlCodec = new XmlCodec();

  @Test
  public void marshallObject() throws Exception {
    assertThat((xmlCodec.marshall(new User("Vasil", "Mitov", 24))), is("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<user>\n    <firstName>Vasil</firstName>\n    <lastName>Mitov</lastName>\n    <age>24</age>\n</user>\n"));
  }

  @Test
  public void unmarshallObject() throws Exception {
    ByteArrayInputStream inputStream = new ByteArrayInputStream("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<user>\n<firstName>Vasil</firstName>\n<lastName>Mitov</lastName>\n<age>24</age></user>".getBytes());
    User user = xmlCodec.unmarshall(new TypeReference<User>() {}, inputStream);
    assertThat(user, is(new User("Vasil", "Mitov", 24)));

  }
}
