package com.clouway;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class JsonCodecTest {
  private JsonCodec jsonCodec = new JsonCodec();

  @Test
  public void marshall() throws Exception {
    String actual = jsonCodec.marshall(new User("Vasil", "Mitov", 24));
    String expected = "{\n  \"firstName\" : \"Vasil\",\n  \"lastName\" : \"Mitov\",\n  \"age\" : 24\n}";

    assertThat(actual, is(expected));
  }

  @Test
  public void unmarshall() throws Exception {
    ByteArrayInputStream inputStream = new ByteArrayInputStream(("[{\n  \"firstName\" : \"Vasil\",\n  \"lastName\" : \"Mitov\",\n  \"age\" : 24\n}]").getBytes());

    List<User> actual = jsonCodec.unmarshall(new TypeReference<List<User>>() {
    }, inputStream);

    List<User> expeced = new ArrayList<User>(){{
      add(new User("Vasil", "Mitov", 24));
    }};

    assertThat(actual, is(expeced));
  }
}
