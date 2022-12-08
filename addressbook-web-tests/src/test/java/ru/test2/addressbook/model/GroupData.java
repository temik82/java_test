package ru.test2.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="group_list")
@XStreamAlias("group")
public class GroupData {
@XStreamOmitField
@Id
@Column(name="group_id")
private int id = Integer.MAX_VALUE;

@Expose
@Column(name="group_name")
  private String name;
  @Expose
  @Column(name="group_header")
  private String header;

  @Expose
  @Column(name="group_footer")
  private String footer;



  @ManyToMany(mappedBy = "groups",fetch = FetchType.EAGER)
  private Set<ContactData> contacts=new HashSet<ContactData>();

  public Set<ContactData> getContacts() {
    return new Contacts(contacts);
  }

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


  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return id == groupData.id && Objects.equals(name, groupData.name) && Objects.equals(header, groupData.header) && Objects.equals(footer, groupData.footer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, header, footer);
  }
}