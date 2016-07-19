package com.clouway;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.InputStream;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public interface Codec {
  String marshall(Object object);

  <T> T unmarshall(final TypeReference<T> type, InputStream stream);
}
