package ru.test2.addressbook.model;

import java.util.Objects;

public class GroupData {


  private int id=Integer.MAX_VALUE;
  private  String name;
  private  String header;

  public GroupData withName(String name) {
    this.name = name;
    return this;
  }

  public GroupData withHeader(String header) {
    this.header = header;
    return this;
  }

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;
  }

  private  String footer;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return id == groupData.id && Objects.equals(name, groupData.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  public GroupData withId(int id) {
    this.id = id;
    return this;
  }



  public String name() {
    return name;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }

  public String header() {
    return header;
  }

  public String footer() {
    return footer;
  }

  public int getId() {
    return id;
  }
}