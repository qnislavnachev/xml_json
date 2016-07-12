package com.clouway.task1;


import com.google.gson.Gson;

import java.io.*;

public class JSONCodecConverter implements MessageCodec {

    public void convertObjectToTextMessage(Object object, String url) throws IOException {
        Gson converter = new Gson();
        String jsonText = converter.toJson(object);
        BufferedWriter writer = new BufferedWriter(new FileWriter(url));

        writer.write(jsonText);
        writer.close();
    }

    public Object convertTextMessageToObject(Object object, String url) throws IOException {
        Gson converter = new Gson();
        return converter.fromJson(new BufferedReader(new FileReader(url)), object.getClass());
    }
}
