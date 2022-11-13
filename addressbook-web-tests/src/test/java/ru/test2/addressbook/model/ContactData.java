package ru.test2.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id;


  private final String firstName;
  private final String lastName;
  private final String phone;
  private final String email;


  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public ContactData(int id, String firstName, String lastName, String phone, String email) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
    this.email = email;

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  public ContactData(String firstName, String lastName, String phone, String email) {
    this.id = Integer.MAX_VALUE;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
    this.email = email;

  }

  public String firstName() {
    return firstName;
  }

  public String lastName() {
    return lastName;
  }

  public String phone() {
    return phone;
  }

  public String email() {
    return email;
  }

}