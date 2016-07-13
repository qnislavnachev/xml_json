package com.clouway.task2;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private List<User> users = new ArrayList();

    public void addPerson(User user){
        users.add(user);
    }

    public void printAverageStats(){
        int counter = 0, temp = 0;
        double age;
        for(User each: users){
            counter++;
            temp = temp + each.getAge();
        }
        age = (temp / counter);
        System.out.print("Users count: " + counter + "\n" + "Average age: " + age + "\n");
    }
}
