package xmlandjson;

import com.google.gson.Gson;

import java.io.FileReader;
import java.lang.reflect.Type;

public class JsonCodec implements Codec {
    private Gson gson;

    public JsonCodec() {
        gson = new Gson();
    }

    /**
     * marshall object into json
     *
     * @param obj - object to be marshall
     * @return xml string
     */
    @Override
    public String marshall(Object obj) {
        return gson.toJson(obj);
    }

    /**
     * unmarshall json string to object
     *
     * @param string is a json string
     * @param tClass - unmarshall object into tClass
     * @return Object<T>
     */
    @Override
    public <T> T unmarshall(String string, Class<T> tClass) {
        return gson.fromJson(string, tClass);
    }

    /**
     * unmarshal json file to object
     * @param reader is a file reader
     * @return Object<T>
     */
    public <T> T unmarshallFile(FileReader reader, Type type) {
        return gson.fromJson(reader, type);
    }

    public <T> T unmarshall(String string, Type type) {
        return gson.fromJson(string, type);
    }
}