package com.clouway.task1;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class XMLCodecConverterTest {

    private XMLCodecConverter converter = new XMLCodecConverter();

    @Test
    public void happyPath() throws FileNotFoundException {
        Person actual = new Person("Uri","Male",23);
        Person expected = null;

        converter.marshal(actual, "testFile.xml");
        expected = (Person) converter.unmarshal(Person.class, "testFile.xml");

        assertEquals(actual,expected);
    }

    @Test
    public void multipleConvertions() throws FileNotFoundException {
        Person person1 = new Person("Uri","Male",23);
        Person person2 = new Person("Yoko","Female",23);
        People actual = new People();
        People expected = null;
        actual.addPerson(person1);
        actual.addPerson(person2);

        converter.marshal(actual,"testFile2.xml");
        expected = (People) converter.unmarshal(People.class, "testFile2.xml");

        Person dummy1 = expected.getPerson(0);
        Person dummy2 = expected.getPerson(1);

        assertEquals(person1, dummy1);
        assertEquals(person2, dummy2);
    }

    @Test(expected = FileNotFoundException.class)
    public void convertFromNonExistingFile() throws FileNotFoundException {
        Person dummy = (Person) converter.unmarshal(Person.class,"testFile3.xml");
    }
}
