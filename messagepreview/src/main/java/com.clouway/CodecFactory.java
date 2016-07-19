package com.clouway;
import java.io.InputStream;


/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class CodecFactory {

  public static Codec setupCodec(String fileExtention) {
    Codec codec=null;
    if (fileExtention.equals("xml")) {
      return codec = new XmlCodec();
    } else if (fileExtention.equals("json")) {
      codec = new JsonCodec();
    }
    return codec;
  }
}
