package xmlandjson.task2;

import xmlandjson.Person;

import java.util.List;

public class Counter {
    private int counter, sumAge = 0;
    private int average = 0;

    /**
     * print how many persons we got in list and average age
     * @param list is list of persons
     */
    public void printAverageStats(List<Person> list) {
        for (Person each : list) {
            counter++;
            sumAge += each.age;
        }
        average = sumAge / counter;
        System.out.println("User count: " + counter + ", Average age: " + average);
    }
}
