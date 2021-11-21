package com.manisrini.domain;

import java.time.LocalDate;
import java.time.Period;

public class Person {

  private Long id;
  private String firstName;
  private String lastName;
  private Double salary;
  private Gender gender;
  private LocalDate dateOfBirth;

  public Person(Long id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Person(Long id, String firstName, String lastName, Double salary, Gender gender, LocalDate dateOfBirth) {
    this(id, firstName, lastName);
    this.dateOfBirth = dateOfBirth;
    this.salary = salary;
    this.gender = gender;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Double getSalary() {
    return salary;
  }

  public Gender getGender() {
    return gender;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }


  public Integer getAge() {
    return Period.between(getDateOfBirth(), LocalDate.now()).getYears();
  }

  @Override
  public String toString() {
    return "Person{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", salary=" + salary +
        ", gender=" + gender +
        ", dateOfBirth=" + dateOfBirth +
        '}';
  }
}
