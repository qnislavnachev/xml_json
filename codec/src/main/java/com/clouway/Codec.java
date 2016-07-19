package com.clouway;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.InputStream;

/**
 *
 *
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public interface Codec {
  /**
   *Marshalls an object to XML/Json data format
   * @param object Object we will be marshalling
   * @return A string representation of the marshall operation
   */
  String marshall(Object object);

  /**
   *Unmarshalls XML/Json data format.
   * @param type The type we will be using. Could be anything because we are using type reference
   * @param stream The stream we will be reading from to unmarshall
   * @param <T> Type reference
   * @return
   */
  <T> T unmarshall(final TypeReference<T> type, InputStream stream);
}
