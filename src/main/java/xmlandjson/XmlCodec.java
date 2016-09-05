package xmlandjson;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.FileReader;
import java.lang.reflect.Type;

public class XmlCodec implements Codec {
    private XStream xStream;

    public XmlCodec() {
        xStream = new XStream(new DomDriver());
        // here I dont know why bigData test dont work without it.
        // I will check it out and try to fix it.
        xStream.alias("person", Person.class);
    }

    /**
     * marshall object into xml string
     * @param obj - object to be marshall
     * @return xml string
     */
    @Override
    public String marshall(Object obj) {
        xStream.processAnnotations(obj.getClass());
        return xStream.toXML(obj);
    }

    /**
     * unmarshall xml string into object
     * @param string is a xml string
     * @param tClass - unmarshall object into tClass
     * @return object
     */
    @Override
    public <T> T unmarshall(String string, Class<T> tClass) {
        xStream.processAnnotations(tClass);
        return (T) xStream.fromXML(string);
    }

    /**
     * unmarshall xml file into object
     * @param reader
     * @param type
     * @param <T>
     * @return object
     */
    @Override
    public <T> T unmarshallFile(FileReader reader, Type type) {
        xStream.processAnnotations(type.getClass());
        return (T) xStream.fromXML(reader);
    }

}

