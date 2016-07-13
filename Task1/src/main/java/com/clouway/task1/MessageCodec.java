package com.clouway.task1;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface MessageCodec {
    /**
     * This method receives an object for marshalling and url path to the receiving file as params.
     *
     * @param object
     * @param url
     */
    void marshal(Object object, String url);

    /**
     * This method receives Class type (like Person.class) and url path to the file with the info that must be extracted.
     * The user should cast the returned value to the desired class.
     *
     * @param type
     * @param url
     * @return
     */
    Object unmarshal(Class type, String url);
}
