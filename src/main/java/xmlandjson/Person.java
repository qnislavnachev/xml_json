package xmlandjson;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("person")
public class Person {
    public final String name;
    public final int age;
    public final String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return gender != null ? gender.equals(person.gender) : person.gender == null;
    }
}
