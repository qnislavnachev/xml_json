package xmlandjson;

import com.google.gson.Gson;

public class JsonCodec implements MessageCodec {
    private Gson gson;

    public JsonCodec() {
        gson = new Gson();
    }

    /**
     * marshall object into json
     * @param obj - object to be marshall
     * @return xml string
     */
    @Override
    public String marshall(Object obj) {
        return gson.toJson(obj);
    }

    /**
     * unmarshall json string to object
     * @param string is a json string
     * @param tClass - unmarshall object into tClass
     * @return Object<T>
     */
    @Override
    public <T> T unmarshall(String string, Class<T> tClass) {
        return gson.fromJson(string, tClass);
    }
}
