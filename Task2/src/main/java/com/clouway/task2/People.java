package com.clouway.task2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class People {
    private List<Person> personList = new ArrayList();

    public void addPerson(Person person){
        personList.add(person);
    }

    public Person getPerson(int index){
        return personList.get(index);
    }

    public List<Person> getPersonList() {
        return personList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        People people = (People) o;

        return personList != null ? personList.equals(people.personList) : people.personList == null;

    }

    @Override
    public int hashCode() {
        return personList != null ? personList.hashCode() : 0;
    }
}
