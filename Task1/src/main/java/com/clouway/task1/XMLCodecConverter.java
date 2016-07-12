package com.clouway.task1;

import javax.xml.bind.*;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

public class XMLCodecConverter implements MessageCodec {

    public void convertObjectToTextMessage(Object object, String url) throws JAXBException, IOException {
        File file = new File(url);
        JAXBContext context = JAXBContext.newInstance(object.getClass());
        Marshaller contextMarshal = context.createMarshaller();
        contextMarshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        contextMarshal.marshal(object, file);

        StringWriter writer = new StringWriter();

        contextMarshal.marshal(object, writer);

        writer.close();
    }

    public Object convertTextMessageToObject(Object object ,String url) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(object.getClass());
        Unmarshaller contextUnmarshal = context.createUnmarshaller();
        Object obj = contextUnmarshal.unmarshal(new File(url));
        return obj;
    }
}
