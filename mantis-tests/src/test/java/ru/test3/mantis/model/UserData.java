package ru.test3.mantis.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "mantis_user_table")
public class UserData {
  @Id
  @Column(name = "id")
  private int id;
  @Column(name="username")
  private String userName;
  @Column(name="email")
  private String email;

  public int getAccessLevel() {
    return accessLevel;
  }

  public UserData setAccessLevel(int accessLevel) {
    this.accessLevel = accessLevel;
    return this;
  }

  @Column(name="access_level")
  private int accessLevel;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserData userData = (UserData) o;
    return id == userData.id && Objects.equals(userName, userData.userName) && Objects.equals(email, userData.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userName, email);
  }

  public int getId() {
    return id;
  }

  public UserData withId(int id) {
    this.id = id;
    return this;
  }

  public String getUserName() {
    return userName;
  }

  public UserData withUserName(String userName) {
    this.userName = userName;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public UserData withEmail(String email) {
    this.email = email;
    return this;
  }


  @Override
  public String toString() {
    return "UserData{" +
            "id=" + id +
            ", userName='" + userName + '\'' +
            ", email='" + email + '\'' +
            '}';
  }
}



