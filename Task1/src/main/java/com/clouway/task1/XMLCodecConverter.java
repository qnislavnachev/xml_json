package com.clouway.task1;

import javax.xml.bind.*;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

public class XMLCodecConverter implements MessageCodec {

    public void marshal(Object object, String url) {
        File file = new File(url);
        JAXBContext context = null;
        StringWriter writer = new StringWriter();

        try {
            context = JAXBContext.newInstance(object.getClass());

            Marshaller contextMarshal = context.createMarshaller();
            contextMarshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            contextMarshal.marshal(object, file);

            contextMarshal.marshal(object, writer);

            writer.close();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public Object unmarshal(Class type , String url) {
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(type);
            Unmarshaller contextUnmarshal = context.createUnmarshaller();
            return contextUnmarshal.unmarshal(new File(url));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
