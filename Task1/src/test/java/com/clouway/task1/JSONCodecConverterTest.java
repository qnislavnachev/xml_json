package com.clouway.task1;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class JSONCodecConverterTest {
    //happyPath
    @Test
    public void convertSingleObjectToJSONMessageAndExtractIt() throws IOException {
        JSONCodecConverter converter = new JSONCodecConverter();
        Person person = new Person("Uri","Male",23);
        Person receivingPerson = null;

        //marshal and unmarshal
        converter.convertObjectToTextMessage(person, "testFile.json");
        receivingPerson = (Person) converter.convertTextMessageToObject(new Person(), "testFile.json");//todo use .class

        assertTrue(receivingPerson.getName().equals("Uri"));
        assertTrue(receivingPerson.getGender().equals("Male"));
        assertTrue(receivingPerson.getAge() == 23);
    }

    //multipleConvertions
    @Test
    public void convertSingleObjectsToXMLMessageAndExtractThem() throws IOException {
        JSONCodecConverter tool = new JSONCodecConverter();
        Person person1 = new Person("Uri","Male",23);
        Person person2 = new Person("Yoko","Female",23);
        Persons persons = new Persons();
        Persons receivingPersons = null;
        persons.addPerson(person1);
        persons.addPerson(person2);

        tool.convertObjectToTextMessage(persons,"testFile2.json");
        receivingPersons = (Persons) tool.convertTextMessageToObject(new Persons(), "testFile2.json");

        assertTrue(receivingPersons.getPersonAtPosition(0).getName().equals("Uri"));
        assertTrue(receivingPersons.getPersonAtPosition(0).getGender().equals("Male"));
        assertTrue(receivingPersons.getPersonAtPosition(0).getAge() == 23);

        assertTrue(receivingPersons.getPersonAtPosition(1).getName().equals("Yoko"));
        assertTrue(receivingPersons.getPersonAtPosition(1).getGender().equals("Female"));
        assertTrue(receivingPersons.getPersonAtPosition(1).getAge() == 23);
    }

    @Test(expected = IOException.class)
    public void userTriesToUnMarshalUnExistingFile() throws IOException {
        JSONCodecConverter tool = new JSONCodecConverter();
        Person receivingPerson = null;

        receivingPerson = (Person) tool.convertTextMessageToObject(new Person(), "testFile3.json");
    }
}
