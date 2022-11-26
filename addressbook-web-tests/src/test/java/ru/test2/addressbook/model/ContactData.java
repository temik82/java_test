package ru.test2.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
public class ContactData {
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;

  @Expose
  private String lastName;
  @Expose
  private String firstName;
  @Expose
  private String email;
  @Expose
  private String mobilePhone;
  @XStreamOmitField
  private String allPhones;
  @XStreamOmitField
  private String postAddress;
  @XStreamOmitField
  private String allEmails;
  @XStreamOmitField
  private String email2;
  @XStreamOmitField
  private String phone2;
  @XStreamOmitField
  private String homePhone;
  @XStreamOmitField
  private String workPhone;
  @XStreamOmitField
  private File photo;
  @XStreamOmitField
  private String email3;

  public File getPhoto() {
    return photo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(lastName, that.lastName) && Objects.equals(firstName, that.firstName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastName, firstName);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }


  public String getPhone2() {
    return phone2;
  }

  public ContactData withPhone2(String phone2) {
    this.phone2 = phone2;
    return this;
  }

  public String getEmail2() {
    return email2;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public String getEmail3() {
    return email3;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public String getEmail() {
    return email;
  }


  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }


  public String getHomePhone() {
    return homePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

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

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;

  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }


  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }


  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPostAddress() {
    return postAddress;
  }


  public String postAddress() {
    return postAddress;
  }

  public ContactData withPostAddress(String postAddress) {
    this.postAddress = postAddress;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }


}