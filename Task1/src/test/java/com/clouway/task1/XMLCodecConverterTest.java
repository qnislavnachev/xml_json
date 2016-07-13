package com.clouway.task1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class XMLCodecConverterTest {

    private XMLCodecConverter converter = new XMLCodecConverter();

    @Test
    public void marshalAndUnmarshalObject() {
        Person person = new Person("Uri","Male",23);
        Person receivingPerson = null;

        converter.marshal(person, "testFile.xml");
        receivingPerson = (Person) converter.unmarshal(Person.class, "testFile.xml");

        assertEquals(person,receivingPerson);
    }

    @Test
    public void marshalAndUnmarshalListOfObjects() {
        Person person1 = new Person("Uri","Male",23);
        Person person2 = new Person("Yoko","Female",23);
        People people = new People();
        People receivingPeople = null;
        people.addPerson(person1);
        people.addPerson(person2);

        converter.marshal(people,"testFile2.xml");
        receivingPeople = (People) converter.unmarshal(People.class, "testFile2.xml");

        Person dummy1 = receivingPeople.getPerson(0);
        Person dummy2 = receivingPeople.getPerson(1);

        assertEquals(person1, dummy1);
        assertEquals(person2, dummy2);
    }
}
