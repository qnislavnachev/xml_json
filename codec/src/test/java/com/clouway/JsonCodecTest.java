package com.clouway;

import jdk.internal.org.objectweb.asm.TypeReference;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Type;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class JsonCodecTest {
  private JsonCodec jsonCodec=new JsonCodec();
  @Test
  public void marshallingObject() throws Exception {
    assertThat(jsonCodec.marshall(new User("Vasil","Mitov",24)),is("{\n  \"firstName\" : \"Vasil\",\n  \"lastName\" : \"Mitov\",\n  \"age\" : 24\n}"));
  }

  @Test
  public void unmarshallingObject() throws Exception {
    String result=jsonCodec.marshall(new User("Vasil","Mitov",24));
    InputStream stream = new ByteArrayInputStream(result.getBytes("UTF-8"));
    assertThat(jsonCodec.unmarshall(new com.fasterxml.jackson.core.type.TypeReference<User>() {
      @Override
      public Type getType() {
        return super.getType();
      }
    },stream),is(new User("Vasil","Mitov",24)));

  }
}
