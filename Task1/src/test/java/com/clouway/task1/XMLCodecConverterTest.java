package com.clouway.task1;

import org.junit.Test;

import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class XMLCodecConverterTest {

    @Test
    public void convertSingleObjectToXMLMessageAndExtractIt() throws JAXBException, IOException {
        XMLCodecConverter tool = new XMLCodecConverter();
        Person testPerson = new Person("Uri","Male",23);
        Person receivingPerson = null;

        tool.convertObjectToTextMessage(testPerson, "testFile2.xml");
        receivingPerson = (Person) tool.convertTextMessageToObject(new Person(), "testFile2.xml");

        assertTrue(receivingPerson.getName().equals("Uri"));
        assertTrue(receivingPerson.getGender().equals("Male"));
        assertTrue(receivingPerson.getAge() == 23);
    }

    @Test
    public void convertSingleObjectsToXMLMessageAndExtractThem() throws JAXBException, IOException {
        XMLCodecConverter tool = new XMLCodecConverter();
        Person testPersonOne = new Person("Uri","Male",23);
        Person testPersonTwo = new Person("Yoko","Female",23);
        Persons persons = new Persons();
        Persons receivingPersons = null;
        persons.addPerson(testPersonOne);
        persons.addPerson(testPersonTwo);

        tool.convertObjectToTextMessage(persons,"testFile.xml");
        receivingPersons = (Persons) tool.convertTextMessageToObject(new Persons(), "testFile.xml");

        assertTrue(receivingPersons.getPersonAtPosition(0).getName().equals("Uri"));
        assertTrue(receivingPersons.getPersonAtPosition(0).getGender().equals("Male"));
        assertTrue(receivingPersons.getPersonAtPosition(0).getAge() == 23);

        assertTrue(receivingPersons.getPersonAtPosition(1).getName().equals("Yoko"));
        assertTrue(receivingPersons.getPersonAtPosition(1).getGender().equals("Female"));
        assertTrue(receivingPersons.getPersonAtPosition(1).getAge() == 23);
    }


    @Test(expected = UnmarshalException.class)
    public void userTriesToUnMarshalUnExistingFile() throws JAXBException, IOException {
        XMLCodecConverter tool = new XMLCodecConverter();
        Person receivingPerson = null;

        receivingPerson = (Person) tool.convertTextMessageToObject(new Person(), "testFile3.xml");
    }
}
