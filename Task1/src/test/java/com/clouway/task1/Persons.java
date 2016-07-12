package com.clouway.task1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Persons {

    @XmlElement
    private List<Person> person = new ArrayList();

    public void addPerson(Person person){
        this.person.add(person);
    }

    public Person getPersonAtPosition(int position){
        return person.get(position);
    }

    @Override
    public String toString() {
        return "Persons{" +
                "person=" + person +
                '}';
    }
}
