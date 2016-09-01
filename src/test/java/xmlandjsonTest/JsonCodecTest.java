package xmlandjsonTest;

import org.junit.Test;
import xmlandjson.JsonCodec;
import xmlandjson.Person;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class JsonCodecTest {
    private Person person = new Person("Qnis", 23, "male");
    private JsonCodec codec = new JsonCodec();

    @Test
    public void toStringJson() throws Exception {
        String expected = "{\"name\":\"Qnis\",\"age\":23,\"gender\":\"male\"}";
        String actual = codec.marshall(person);
        assertThat(actual, is(expected));
    }

    @Test
    public void toObjectFromJson() throws Exception {
        String json = "{\"name\":\"Qnis\",\"age\":23,\"gender\":\"male\"}";
        Person actual = codec.unmarshall(json, Person.class);
        Person expected = person;
        // test can be done with 1 assert, but i decide that is more readable and easy understandable;
        assertThat(actual.getName(), is(expected.getName()));
        assertThat(actual.getAge(), is(expected.getAge()));
        assertThat(actual.getGender(), is(expected.getGender()));
    }

    @Test
    public void unmarshallingBigData() throws Exception {
        String xml = "[{\"name\":\"Qnis\",\"age\":23,\"gender\":\"male\"}";
        for (int i = 0; i < 9999; i++) {
            xml += ",{\"name\":\"Qnis\",\"age\":23,\"gender\":\"male\"}";
        }
        xml += "]";
        List list = codec.unmarshall(xml, List.class);
        int actual = list.size();
        int expected = 10000;
        assertThat(actual, is(expected));
    }
}
