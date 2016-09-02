package xmlandjsonTest;


import org.junit.Test;

import xmlandjson.Person;
import xmlandjson.XmlCodec;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class XmlCodecTest {

    private XmlCodec codec = new XmlCodec();

    @Test
    public void toStringXml() throws Exception {
        Person person = new Person("Qnis", 23, "male");
        String expected = "<person>\n" + "  <name>Qnis</name>\n" + "  <age>23</age>\n" + "  <gender>male</gender>\n" + "</person>";
        String actual = codec.marshall(person);
        assertThat(actual, is(expected));
    }

    @Test
    public void toObjectFromXml() throws Exception {
        Person person = new Person("Qnis", 23, "male");
        String xml = "<person>\n" + "  <name>Qnis</name>\n" + "  <age>23</age>\n" + "  <gender>male</gender>\n" + "</person>";
        Person actual = codec.unmarshall(xml, Person.class);
        Person expected = person;
        assertThat(actual, is(expected));
    }

    @Test
    public void unmarshallingBigData() throws Exception {
        StringBuilder builder = new StringBuilder();
        builder.append("<list>\n");
        for (int i = 0; i < 10000; i++) {
            builder.append(" <person>\n" + "  <name>Qnis</name>\n" + "  <age>23</age>\n" + "  <gender>male</gender>\n" + "</person>\n");
        }
        builder.append("</list>");
        String xml = builder.toString();
        List list = codec.unmarshall(xml);
        int actual = list.size();
        int expected = 10000;
        assertThat(actual, is(expected));
    }
}