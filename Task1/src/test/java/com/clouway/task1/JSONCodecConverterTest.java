package com.clouway.task1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JSONCodecConverterTest {

    private JSONCodecConverter converter = new JSONCodecConverter();

    //happy path -> Done
    @Test
    public void marshalAndUnmarshalObject() {
        Person person = new Person("Uri","Male",23);
        Person receivingPerson = null;

        //marshal and unmarshal -> Done
        converter.marshal(person, "testFile.json");
        receivingPerson = (Person) converter.unmarshal(Person.class, "testFile.json");//todo use .class

        assertEquals(person,receivingPerson);
    }

    //multipleConvertions -> Gson and JAXB require from us to define out own containers
    @Test
    public void marshalAndUnmarshalListOfObjects() {
        Person person1 = new Person("Uri","Male",23);
        Person person2 = new Person("Yoko","Female",23);
        People people = new People();
        People receivingPeople = null;
        people.addPerson(person1);
        people.addPerson(person2);

        converter.marshal(people,"testFile2.json");
        receivingPeople = (People) converter.unmarshal(People.class, "testFile2.json");

        assertEquals(people, receivingPeople);
    }
}
