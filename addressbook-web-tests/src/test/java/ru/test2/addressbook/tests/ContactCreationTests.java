package ru.test2.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.test2.addressbook.model.ContactData;
import ru.test2.addressbook.model.Contacts;

import java.io.*;


import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactsFromXml() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contacts.xml"))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;

        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(ContactData.class);
      xstream.allowTypes(new Class[]{ContactData.class});
      List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
      return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();

    }
  }

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contacts.json"));
    String json = "";
    String line = reader.readLine();
    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new GsonBuilder().setPrettyPrinting()
            .excludeFieldsWithoutExposeAnnotation().create();
    List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
    }.getType());
    return contacts.stream().map((с) -> new Object[]{с}).collect(Collectors.toList()).iterator();


  }

  @Test(dataProvider = "validContactsFromJson")
  public void testContactCreation(ContactData contact) throws Exception {
    Contacts before = app.db().contacts();
    app.goTo().contactPage();
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.db().contacts();

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

  }

  @Test(enabled = false)
  public void testContactCreation() throws Exception {
    app.goTo().contactPage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/test1.png");
    ContactData contact = new ContactData().withFirstName("Sergey").withLastName("Sidorov").withEmail("test@test.ru")
            .withMobilePhone("1223456789").withPhoto(photo);
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

  }

}
