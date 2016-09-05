package xmlandjson;

import java.io.FileReader;
import java.lang.reflect.Type;

public interface Codec {
    /**
     * marshall object
     * @param obj
     * @return string
     */
    String marshall(Object obj);

    /**
     * unmrashall object from string
     * @param string
     * @param tClass
     * @param <T>
     * @return object
     */
    <T> T unmarshall(String string, Class<T> tClass);

    /**
     * unmarshall object from file
     * @param reader
     * @param type
     * @param <T>
     * @return object
     */
    <T> T unmarshallFile(FileReader reader, Type type);


}
