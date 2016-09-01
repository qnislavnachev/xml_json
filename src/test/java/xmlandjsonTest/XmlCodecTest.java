package xmlandjsonTest;

import org.junit.Test;

import xmlandjson.Person;
import xmlandjson.XmlCodec;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class XmlCodecTest {

    private Person person = new Person("Qnis", 23, "male");
    private XmlCodec codec = new XmlCodec();

    @Test
    public void toStringXml() throws Exception {
        String expected = "<person>\n" + "  <name>Qnis</name>\n" + "  <age>23</age>\n" + "  <gender>male</gender>\n" + "</person>";
        String actual = codec.marshall(person);
        assertThat(actual, is(expected));
    }

    @Test
    public void toObjectFromXml() throws Exception {
        String xml = "<person>\n" + "  <name>Qnis</name>\n" + "  <age>23</age>\n" + "  <gender>male</gender>\n" + "</person>";
        Person actual = codec.unmarshall(xml, null);
        Person expected = person;
        // test can be done with 1 assert, but i decide that is more readable and easy understandable;
        assertThat(actual.getName(), is(expected.getName()));
        assertThat(actual.getAge(), is(expected.getAge()));
        assertThat(actual.getGender(), is(expected.getGender()));
    }

    @Test
    public void unmarshallingBigData() throws Exception {
        String xml = "<list>";
        for (int i = 0; i < 10000; i++) {
            xml += "<person>\n" + "  <name>Qnis</name>\n" + "  <age>23</age>\n" + "  <gender>male</gender>\n" + "</person>";
        }
        xml += "</list>";
        List list = codec.unmarshall(xml, List.class);
        int actual = list.size();
        int expected = 10000;
        assertThat(actual, is(expected));
    }
}
