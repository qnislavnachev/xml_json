package com.clouway;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class CodecFactory {
  /**
   * A codec geter that takes a fileExtention as a parameter and makes the needed codec.
   *
   * @param fileExtention
   * @return An XML or Json codec.
   */
  public static Codec getCodec(String fileExtention) {
    Codec codec = null;
    if (fileExtention.equals("xml")) {
      return codec = new XmlCodec();
    } else if (fileExtention.equals("json")) {
      codec = new JsonCodec();
    }
    return codec;
  }
}
