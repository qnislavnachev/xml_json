package xmlandjsonTest;

import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import xmlandjson.JsonCodec;
import xmlandjson.Person;

import java.lang.reflect.Type;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class JsonCodecTest {
    private JsonCodec codec = new JsonCodec();

    @Test
    public void toStringJson() throws Exception {
        Person person = new Person("Qnis", 23, "male");
        String expected = "{\"name\":\"Qnis\",\"age\":23,\"gender\":\"male\"}";
        String actual = codec.marshall(person);
        assertThat(actual, is(expected));
    }

    @Test
    public void toObjectFromJson() throws Exception {
        Person person = new Person("Qnis", 23, "male");
        String json = "{\"name\":\"Qnis\",\"age\":23,\"gender\":\"male\"}";
        Person actual = codec.unmarshall(json, Person.class);
        Person expected = person;
        // test can be done with 1 assert, but i decide that is more readable and easy understandable;
        assertThat(actual, is(expected));
    }

    @Test
    public void unmarshallingBigData() throws Exception {
        StringBuilder builder = new StringBuilder();
        builder.append("[{\"name\":\"Qnis\",\"age\":23,\"gender\":\"male\"}");
        for (int i = 0; i < 9999; i++) {
            builder.append(",{\"name\":\"Qnis\",\"age\":23,\"gender\":\"male\"}");
        }
        builder.append("]");
        String json = builder.toString();
        Type type = new TypeToken<List<Person>>() {}.getType();
        List<Person> list = codec.unmarshall(json, type);
        int actual = list.size();
        int expected = 10000;
        assertThat(actual, is(expected));
    }
}
