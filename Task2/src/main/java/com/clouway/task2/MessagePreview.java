package com.clouway.task2;

import com.clouway.task1.JSONCodecConverter;
import com.clouway.task1.XMLCodecConverter;

import java.io.FileNotFoundException;

public class MessagePreview {

    public static void printAverageStats(User[] users){
        int counter = 0, temp = 0;
        double age;
        for (User each: users) {
            counter++;
            temp = temp + each.getAge();
        }
        age = (temp / counter);
        System.out.print("Users Count: " + counter + "\n" + "Average Age: " + age + "\n");
    }

    public static void main(String [] args){
        JSONCodecConverter jsonConverter = new JSONCodecConverter();
        XMLCodecConverter xmlConverter = new XMLCodecConverter();
        User[] users = null;

        if(args[0].equals("-type")){
            if(args[1].equals("json") && args[3].equals("--printAverageStats")){

                try {
                    users = (User[]) jsonConverter.unmarshal(User[].class, args[2]);
                } catch (FileNotFoundException e) {
                    System.out.println("The given path doesn't lead to the desired file!");
                }
                printAverageStats(users);

            }else if(args[1].equals("xml") && args[3].equals("--printAverageStats")){

                try {
                    users = (User[]) xmlConverter.unmarshal(User[].class, args[2]);
                } catch (FileNotFoundException e) {
                    System.out.println("The given path doesn't lead to the desired file!");
                }
                printAverageStats(users);

            }
        }
    }
}
