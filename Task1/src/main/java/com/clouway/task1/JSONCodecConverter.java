package com.clouway.task1;


import com.google.gson.Gson;

import java.io.*;

public class JSONCodecConverter implements MessageCodec {

    private final Gson converter = new Gson();

    public void marshal(Object object, String url) {
        String jsonText = converter.toJson(object);
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(url));
            writer.write(jsonText);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Object unmarshal(Class type, String url) throws FileNotFoundException {
        try {
            return converter.fromJson(new BufferedReader(new FileReader(url)), type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new FileNotFoundException();
        }
    }
}
