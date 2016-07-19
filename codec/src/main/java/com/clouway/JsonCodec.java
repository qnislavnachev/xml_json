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

  public String marshall(Object object) {
    try {
      return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public <T> T unmarshall(final TypeReference<T> type, InputStream stream) {
    try {
      return (T) mapper.readValue(stream, type);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }


}
