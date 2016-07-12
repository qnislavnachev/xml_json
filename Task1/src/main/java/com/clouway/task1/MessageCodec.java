package com.clouway.task1;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface MessageCodec {
    void convertObjectToTextMessage(Object object, String url) throws JAXBException, IOException;
    Object convertTextMessageToObject(Object object, String url) throws JAXBException, IOException;
}
