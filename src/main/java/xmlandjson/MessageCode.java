package xmlandjson;

public interface MessageCode {
    /**
     * marshall object
     * @param obj
     * @return string
     */
    String marshall(Object obj);

    /**
     * unmrashal object
     * @param string
     * @param tClass
     * @param <T>
     * @return object
     */
    <T> T unmarshall(String string, Class<T> tClass);
}
