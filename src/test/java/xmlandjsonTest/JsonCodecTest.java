package xmlandjsonTest;

import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import xmlandjson.Codec;
import xmlandjson.JsonCodec;
import xmlandjson.Person;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class JsonCodecTest {
    private Codec codec = new JsonCodec();

    @Test
    public void toStringJson() throws Exception {
        Person person = new Person("Qnis", 23, "male");
        String expected = "{\"name\":\"Qnis\",\"age\":23,\"gender\":\"male\"}";
        String actual = codec.marshall(person);
        assertThat(actual, is(expected));
    }

    @Test
    public void toObjectFromJson() throws Exception {
        Person expected = new Person("Qnis", 23, "male");
        String json = "{\"name\":\"Qnis\",\"age\":23,\"gender\":\"male\"}";
        Person actual = codec.unmarshall(json, Person.class);
        // test can be done with 1 assert, but i decide that is more readable and easy understandable;
        assertThat(actual, is(expected));
    }

    @Test
    public void unmarshallingBigData() throws Exception {
        JsonCodec jsonCodec = new JsonCodec();
        StringBuilder builder = new StringBuilder();
        builder.append("[{\"name\":\"Qnis\",\"age\":23,\"gender\":\"male\"}");
        for (int i = 0; i < 9999; i++) {
            builder.append(",{\"name\":\"Qnis\",\"age\":23,\"gender\":\"male\"}");
        }
        builder.append("]");
        String json = builder.toString();
        Type type = new TypeToken<List<Person>>() {}.getType();
        List<Person> list = jsonCodec.unmarshall(json, type);
        int actual = list.size();
        int expected = 10000;
        assertThat(actual, is(expected));
    }

    @Test
    public void unmarshallingFile() throws Exception {
        File file = new File("testjson.json");
        FileWriter writer = new FileWriter(file);
        FileReader reader = new FileReader(file);

        StringBuilder builder = new StringBuilder();
        builder.append("[{\"name\":\"Qnis\",\"age\":23,\"gender\":\"male\"}");
        for (int i = 0; i < 19; i++) {
            builder.append(",{\"name\":\"Qnis\",\"age\":23,\"gender\":\"male\"}");
        }
        builder.append("]");
        String json = builder.toString();
        writer.write(json);
        writer.close();
        Type type = new TypeToken<List<Person>>() {}.getType();
        List<Person> list = codec.unmarshallFile(reader, type);
        int actual = list.size();
        int expected = 20;
        assertThat(actual, is(expected));
    }
}
