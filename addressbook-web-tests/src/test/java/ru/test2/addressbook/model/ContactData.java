package ru.test2.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import jakarta.persistence.*;

import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {
  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "lastname")
  private String lastName;
  @Expose
  @Column(name = "firstname")
  private String firstName;
  @Expose
  private String email;
  @Expose
  @Column(name = "mobile")
  private String mobilePhone;
  @XStreamOmitField
  @Transient
  private String allPhones;
  @XStreamOmitField
  @Column(name = "address")
  private String postAddress;
  @XStreamOmitField
  @Transient
  private String allEmails;
  @XStreamOmitField
  @Column(name = "email2")
  private String email2;
  @XStreamOmitField
  @Column(name = "phone2")
  private String phone2;
  @XStreamOmitField
  @Column(name = "home")
  private String homePhone;

  @XStreamOmitField
  @Column(name = "work")
  private String workPhone;
  @XStreamOmitField
  @Column(name = "photo")
  private String photo;
  @XStreamOmitField
  @Column(name = "email3")
  private String email3;
  @Column(name = "address2")
  private String address2;

  public String getAddress2() {
    return address2;
  }

  public ContactData withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }


  public File getPhoto() {
    if (photo != null) {
      return new File(photo);
    } else {
      return null;
    }
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", lastName='" + lastName + '\'' +
            ", firstName='" + firstName + '\'' +
            ", email='" + email + '\'' +
            ", mobilePhone='" + mobilePhone + '\'' +
            ", postAddress='" + postAddress + '\'' +
            ", email2='" + email2 + '\'' +
            ", phone2='" + phone2 + '\'' +
            ", homePhone='" + homePhone + '\'' +
            ", workPhone='" + workPhone + '\'' +
            ", email3='" + email3 + '\'' +
            ", address2='" + address2 + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(lastName, that.lastName) && Objects.equals(firstName, that.firstName) && Objects.equals(email, that.email) && Objects.equals(mobilePhone, that.mobilePhone) && Objects.equals(postAddress, that.postAddress) && Objects.equals(email2, that.email2) && Objects.equals(phone2, that.phone2) && Objects.equals(homePhone, that.homePhone) && Objects.equals(workPhone, that.workPhone) && Objects.equals(email3, that.email3) && Objects.equals(address2, that.address2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, lastName, firstName, email, mobilePhone, postAddress, email2, phone2, homePhone, workPhone, email3, address2);
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