package com.clouway.task2;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
    private String name;
    private String gender;
    private double age;

    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Person(){}

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public void setGender(String gender) {
        this.gender = gender;
    }

    @XmlElement
    public void setAge(double age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public double getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "{" +
                "name=" + name + "," + " gender=" + gender + "," + " age=" + age + "}";
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
