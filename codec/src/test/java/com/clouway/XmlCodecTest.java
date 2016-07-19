package com.clouway;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class XmlCodecTest {
  private XmlCodec xmlCodec = new XmlCodec();

  @Test
  public void marshallObject() throws Exception {
    String actual = xmlCodec.marshall(new User("Vasil", "Mitov", 24));
    String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<user>\n    <firstName>Vasil</firstName>\n    <lastName>Mitov</lastName>\n    <age>24</age>\n</user>\n";
    assertThat(actual, is(expected));
  }

  @Test
  public void unmarshallObject() throws Exception {
    ByteArrayInputStream inputStream = new ByteArrayInputStream("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<user>\n<firstName>Vasil</firstName>\n<lastName>Mitov</lastName>\n<age>24</age></user>".getBytes());
    User actual = xmlCodec.unmarshall(new TypeReference<User>() {}, inputStream);
    User expected = new User("Vasil", "Mitov", 24);
    assertThat(actual, is(expected));

  }
}
