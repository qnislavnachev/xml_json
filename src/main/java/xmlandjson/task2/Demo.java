package xmlandjson.task2;

import com.google.gson.reflect.TypeToken;
import xmlandjson.Codec;
import xmlandjson.JsonCodec;
import xmlandjson.Person;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;


public class Demo {

    /**
     * print how many persons we got in list and average age
     * @param list is list of persons
     */
    public static void printAverageStats(List<Person> list) {
        int counter = 0, sumAge = 0;
        int average = 0;
        for (Person each : list) {
            counter++;
            sumAge += each.age;
        }
        average = sumAge / counter;
        System.out.println("User count: " + counter + ", Average age: " + average);
    }
    public static void main(String[] args) throws Exception {
        Codec jsonCodec = new JsonCodec();

        String type = args[0];
        String codec = args[1];
        String fileName = args[2];
        String method = args[3];

        /**
         * getting path of file
         */
        File path = new File(fileName);
        String pathFile = path.getPath();
        FileReader reader = new FileReader(pathFile);

        if ("-type".equals(type) && "json".equals(codec) && "--printAverageStats".equals(method)) {
            Type typeOfList = new TypeToken<List<Person>>() {}.getType();
            List<Person> personList = jsonCodec.unmarshallFile(reader, typeOfList);
            printAverageStats(personList);
        } else {
            throw new CodecException("That command is not available");
        }
    }
}
