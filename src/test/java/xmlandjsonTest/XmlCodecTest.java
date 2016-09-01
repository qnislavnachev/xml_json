package xmlandjsonTest;

import org.junit.Test;

import xmlandjson.Person;
import xmlandjson.XmlCodec;

import java.util.ArrayList;
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
        String xml = codec.marshall(person);
        Person actual = codec.unmarshall(xml, null);
        Person expected = person;
        // test can be done with 1 assert, but i decide that is more readable and easy understandable;
        assertThat(actual.name, is(expected.name));
        assertThat(actual.age, is(expected.age));
        assertThat(actual.gender, is(expected.gender));
    }

    @Test
    public void unmarshallingBigData() throws Exception {
        List<Person> listOfPersons = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            listOfPersons.add(person);
        }
        String bigData = codec.marshall(listOfPersons);
        List list = codec.unmarshall(bigData, List.class);
        int actual = list.size();
        int expected = 200;
        assertThat(actual, is(expected));
    }
}
