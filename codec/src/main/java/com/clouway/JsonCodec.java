package com.clouway;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class JsonCodec implements Codec  {
  private ObjectMapper mapper = new ObjectMapper();

  public String marshall(Object object) throws IOException {
    return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
  }

  public <T> T unmarshall(final TypeReference<T> type, InputStream stream) throws IOException {
    return (T) mapper.readValue(stream, type);
  }


}
