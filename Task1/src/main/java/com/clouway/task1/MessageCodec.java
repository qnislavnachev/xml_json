package com.clouway.task1;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface MessageCodec {
    void marshal(Object object, String url) throws JAXBException, IOException;
    Object unmarshal(Class type, String url) throws JAXBException, IOException;
}
