package xmlandjson;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XmlCodec implements Codec {
    private XStream xStream;

    public XmlCodec() {
        xStream = new XStream(new DomDriver());
        xStream.processAnnotations(Person.class);
    }

    /**
     * marshall object into xml string
     * @param obj - object to be marshall
     * @return xml string
     */
    @Override
    public String marshall(Object obj) {
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
        return (T) xStream.fromXML(string);
    }

}

