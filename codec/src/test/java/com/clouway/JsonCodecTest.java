package com.clouway;


import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class JsonCodecTest {
  private JsonCodec jsonCodec = new JsonCodec();

  @Test
  public void marshallingObject() throws Exception {
    assertThat(jsonCodec.marshall(new User("Vasil", "Mitov", 24)), is("{\n  \"firstName\" : \"Vasil\",\n  \"lastName\" : \"Mitov\",\n  \"age\" : 24\n}"));
  }

  @Test
  public void unmarshallingObject() throws Exception {
    ByteArrayInputStream inputStream = new ByteArrayInputStream(("[{\n  \"firstName\" : \"Vasil\",\n  \"lastName\" : \"Mitov\",\n  \"age\" : 24\n}]").getBytes());

    List<User> user = jsonCodec.unmarshall(new TypeReference<List<User>>() {
    }, inputStream);
    assertThat(user.get(0), is(new User("Vasil", "Mitov", 24)));
  }
}
