package com.clouway;

import com.fasterxml.jackson.core.type.TypeReference;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public interface Codec {
  String marshall(Object object) throws IOException, JAXBException;

  <T> T unmarshall(final TypeReference<T> type, InputStream stream) throws IOException, JAXBException;
}
