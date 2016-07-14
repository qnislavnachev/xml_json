package com.clouway;

import com.google.gson.Gson;

import java.io.*;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class JsonCodec {
  private final Gson gson = new Gson();

  public void marshall(ListOfObjects listOfObjects, String fileName) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".json"));
    try {
      String convertedObject = gson.toJson(listOfObjects);
      writer.write(convertedObject);
    } finally {
      writer.close();
    }
  }

  public ListOfObjects unmarshall(String filename) throws FileNotFoundException {
    return gson.fromJson(new BufferedReader(new FileReader(filename + ".json")), ListOfObjects.class);
  }
}
