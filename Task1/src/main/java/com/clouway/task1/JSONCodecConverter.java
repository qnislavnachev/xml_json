package com.clouway.task1;


import com.google.gson.Gson;

import java.io.*;

public class JSONCodecConverter implements MessageCodec {

    public void marshal(Object object, String url) {
        Gson converter = new Gson();
        String jsonText = converter.toJson(object);
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(url));
            writer.write(jsonText);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object unmarshal(Class type, String url) {
        Gson converter = new Gson();
        try {
            return converter.fromJson(new BufferedReader(new FileReader(url)), type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
