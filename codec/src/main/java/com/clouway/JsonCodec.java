package com.clouway;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class JsonCodec implements Codec {
  private ObjectMapper mapper = new ObjectMapper();

  /**
   * Marshalling using Object mapper of Jackson. Using DefaultPrettyPrinter so that we get a json file that is formatted.
   * @param object Object we will be marshalling
   * @return A string representation of the marshalled object in json.
   */
  public String marshall(Object object) {
    try {
      return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Unmarshalling a stream using Jackson.
   * @param type The type we will be using. Could be anything because we are using type reference
   * @param stream The stream we will be reading from to unmarshall
   * @param <T>
   * @return Returns a type reference.
   */
  public <T> T unmarshall(final TypeReference<T> type, InputStream stream) {
    try {
      return (T) mapper.readValue(stream, type);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }


}
