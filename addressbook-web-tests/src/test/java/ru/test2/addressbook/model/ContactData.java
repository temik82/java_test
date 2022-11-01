package ru.test2.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String firstName;
  private final String lastNane;
  private final String phone;
  private final String email;
  private String group;

  public ContactData(String firstName, String lastNane, String phone, String email, String group) {
    this.firstName = firstName;
    this.lastNane = lastNane;
    this.phone = phone;
    this.email = email;
    this.group = group;
  }

  public String firstName() {
    return firstName;
  }

  public String lastNane() {
    return lastNane;
  }

  public String phone() {
    return phone;
  }

  public String email() {
    return email;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (ContactData) obj;
    return Objects.equals(this.firstName, that.firstName) &&
            Objects.equals(this.lastNane, that.lastNane) &&
            Objects.equals(this.phone, that.phone) &&
            Objects.equals(this.email, that.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastNane, phone, email);
  }

  @Override
  public String toString() {
    return "ContactData[" +
            "firstName=" + firstName + ", " +
            "lastNane=" + lastNane + ", " +
            "phone=" + phone + ", " +
            "email=" + email + ']';
  }

  public String getGroup() {
    return group;
  }
}