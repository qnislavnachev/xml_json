package xmlandjsonTest;

import org.junit.Test;
import xmlandjson.JsonCodec;
import xmlandjson.Person;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class JsonCodecTest {
    Person person = new Person("Qnis", 23, "male");
    JsonCodec codec = new JsonCodec();

    @Test
    public void marshall() throws Exception {
        String expected = "{\"name\":\"Qnis\",\"age\":23,\"gender\":\"male\"}";
        String actual = codec.marshall(person);
        assertThat(actual, is(expected));
    }

    @Test
    public void unmarshall() throws Exception {
        String json = codec.marshall(person);
        Person actual = codec.unmarshall(json, Person.class);
        Person expected = person;
        // test can be done with 1 assert, but i decide that is more readable and easy understandable;
        assertThat(actual.name, is(expected.name));
        assertThat(actual.age, is(expected.age));
        assertThat(actual.gender, is(expected.gender));
    }

    @Test
    public void bigData() throws Exception {
        List<Person> listOfPerson = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listOfPerson.add(person);
        }
        String json = codec.marshall(listOfPerson);
        List list = codec.unmarshall(json, List.class);
        int actual = list.size();
        int expected = 100;
        assertThat(actual, is(expected));
    }
}
