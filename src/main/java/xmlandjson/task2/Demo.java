package xmlandjson.task2;

import com.google.gson.reflect.TypeToken;
import xmlandjson.JsonCodec;
import xmlandjson.Person;

import java.io.FileReader;

import java.lang.reflect.Type;
import java.util.List;


public class Demo {
    public static void main(String[] args) throws Exception {
        JsonCodec jsonCodec = new JsonCodec();
        Counter counter = new Counter();

        String type = args[0];
        String codec = args[1];
        String fileName = args[2];
        String method = args[3];

        FileReader reader = new FileReader("/home/clouway/workspaces/xml_json/" + fileName);

        if (type.equals("-type") && codec.equals("json") && method.equals("--printAverageStats")) {
            Type type123 = new TypeToken<List<Person>>() {}.getType();
            List<Person> personList = jsonCodec.unmarshallFile(reader, type123);
            counter.printAverageStats(personList);
        } else {
            throw new CodecException("That command is not available");
        }
    }
}
