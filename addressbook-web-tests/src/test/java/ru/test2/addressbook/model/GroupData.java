package ru.test2.addressbook.model;

import java.util.Objects;

public class GroupData {
  private final String name;
  private final String header;
  private final String footer;

  public GroupData(String name, String header, String footer) {
    this.name = name;
    this.header = header;
    this.footer = footer;
  }

  public String name() {
    return name;
  }

  public String header() {
    return header;
  }

  public String footer() {
    return footer;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (GroupData) obj;
    return Objects.equals(this.name, that.name) &&
            Objects.equals(this.header, that.header) &&
            Objects.equals(this.footer, that.footer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, header, footer);
  }

  @Override
  public String toString() {
    return "GroupData[" +
            "name=" + name + ", " +
            "header=" + header + ", " +
            "footer=" + footer + ']';
  }

}