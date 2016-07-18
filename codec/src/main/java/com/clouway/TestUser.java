package com.clouway;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */

@XmlRootElement(name = "testUser")
public class TestUser {
  private String firstName;
  private String lastName;
  private Integer age;

  public TestUser() {
  }

  @JsonCreator
  public TestUser(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("age") Integer age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  @Override
  public String toString() {
    return "User{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", age=" + age +
            '}';
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Integer getAge() {
    return age;
  }


  @XmlElement
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @XmlElement
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  @XmlElement
  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;

    TestUser user = (TestUser) object;

    if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
    if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
    return age != null ? age.equals(user.age) : user.age == null;

  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (age != null ? age.hashCode() : 0);
    return result;
  }
}
