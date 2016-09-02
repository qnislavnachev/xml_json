package xmlandjson;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.util.List;

public class XmlCodec implements Codec {
    private XStream xStream;

    public XmlCodec() {
        xStream = new XStream(new DomDriver());
        xStream.autodetectAnnotations(true);
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

    public List<Person> unmarshall(String string) {
        xStream.alias("person", Person.class);
        return (List<Person>) xStream.fromXML(string);
    }
}

