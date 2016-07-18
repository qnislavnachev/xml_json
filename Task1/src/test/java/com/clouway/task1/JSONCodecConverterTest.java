package com.clouway.task1;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class JSONCodecConverterTest {

    private JSONCodecConverter converter = new JSONCodecConverter();

    @Test
    public void happyPath() throws FileNotFoundException {
        Person actual = new Person("Uri","Male",23);
        Person expected = null;

        converter.marshal(actual, "testFile.json");
        expected = (Person) converter.unmarshal(Person.class, "testFile.json");

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

        converter.marshal(actual,"testFile2.json");
        expected = (People) converter.unmarshal(People.class, "testFile2.json");

        assertEquals(actual, expected);
    }

    @Test
    public void marshalAndUnmarshalArray() throws FileNotFoundException {
        Person[] actual = new Person[3];
        Person[] expected = null;

        actual[0] = new Person("Stan","Male",20);
        actual[1] = new Person("Tom","Male",21);
        actual[2] = new Person("Violet","Female",20);

        converter.marshal(actual, "testFileArray.json");
        expected = (Person[]) converter.unmarshal(Person[].class, "testFileArray.json");

        assertEquals(actual,expected);
    }

    @Test(expected = FileNotFoundException.class)
    public void convertFromNonExistingFile() throws FileNotFoundException {
        Person dummy = (Person) converter.unmarshal(Person.class,"testFile3.json");
    }
}
