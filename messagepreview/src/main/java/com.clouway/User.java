package com.clouway;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class User {
  String firstname;
  String lastname;
  Integer age;

  public User() {
  }
  @JsonCreator
  public User(@JsonProperty("firstName")String firstName,@JsonProperty("lastName") String lastName, @JsonProperty("age")Integer age) {
    this.firstname = firstName;
    this.lastname = lastName;
    this.age = age;
  }

  @Override
  public String toString() {
    return "User{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", age=" + age +
            '}';
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public Integer getAge() {
    return age;
  }
}
