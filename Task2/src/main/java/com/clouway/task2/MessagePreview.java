package com.clouway.task2;

import com.clouway.task1.JSONCodecConverter;
import com.clouway.task1.XMLCodecConverter;

import java.io.FileNotFoundException;
import java.util.List;

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

    public static void printAverageStats(People people){
        int counter = 0;
        double age, temp = 0;
        List<Person> personList = people.getPersonList();
        for (Person each: personList) {
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
        People people = null;

        String type = args[0];
        String converter = args[1];
        String fileName = args[2];
        String method = args[3];

        if(type.equals("-type")){
            if(converter.equals("json") && method.equals("--printAverageStats")){

                try {
                    users = (User[]) jsonConverter.unmarshal(User[].class, fileName);
                } catch (FileNotFoundException e) {
                    System.out.println("The given path doesn't lead to the desired file!");
                }
                printAverageStats(users);

            }else if(converter.equals("xml") && method.equals("--printAverageStats")){

                try {
                    people = (People) xmlConverter.unmarshal(People.class, fileName);
                } catch (FileNotFoundException e) {
                    System.out.println("The given path doesn't lead to the desired file!");
                }
                printAverageStats(people);

            }
        }
    }
}
