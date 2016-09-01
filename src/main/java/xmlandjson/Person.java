package xmlandjson;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("person")
public class Person {
    public String name;
    public int age;
    public String gender;

    public Person() {
    }

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
