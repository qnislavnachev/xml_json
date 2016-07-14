package com.clouway.task1;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class JSONCodecConverterTest {

    private JSONCodecConverter converter = new JSONCodecConverter();

    @Test
    public void marshalAndUnmarshal() throws FileNotFoundException {
        Person person = new Person("Uri","Male",23);
        Person receivingPerson = null;

        converter.marshal(person, "testFile.json");
        receivingPerson = (Person) converter.unmarshal(Person.class, "testFile.json");//todo use .class

        assertEquals(person,receivingPerson);
    }

    @Test
    public void multipleConvertions() throws FileNotFoundException {
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

    @Test
    public void marshalAndUnmarshalArray() throws FileNotFoundException {
        Person[] personArray = new Person[3];
        Person[] receivingPersonArray = null;

        personArray[0] = new Person("Stan","Male",20);
        personArray[1] = new Person("Tom","Male",21);
        personArray[2] = new Person("Violet","Female",20);

        converter.marshal(personArray, "testFileArray.json");
        receivingPersonArray = (Person[]) converter.unmarshal(Person[].class, "testFileArray.json");

        assertEquals(personArray,receivingPersonArray);
    }

    @Test(expected = FileNotFoundException.class)
    public void convertFromNonExistingFile() throws FileNotFoundException {
        Person dummy = (Person) converter.unmarshal(Person.class,"testFile3.json");
    }
}
