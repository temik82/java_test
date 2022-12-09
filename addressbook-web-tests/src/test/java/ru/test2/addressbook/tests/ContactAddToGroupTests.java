package ru.test2.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.test2.addressbook.model.ContactData;
import ru.test2.addressbook.model.Contacts;
import ru.test2.addressbook.model.GroupData;
import ru.test2.addressbook.model.Groups;

import java.util.*;

import static org.testng.Assert.*;

public class ContactAddToGroupTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().contactPage();
      app.contact().create(new ContactData().withFirstName("Petr")
              .withLastName("Petrov").withMobilePhone("8966666661")
              .withEmail("test7@test.ru").withEmail2("test5@test.ru")
              .withPostAddress("006783").withPhone2("890536111111").withWorkPhone("3000000000")
              .withEmail3("test6@test.ru").withHomePhone("4000000000").withAddress2("322234"));
    }
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }

  }

  @Test
  public void testContactAddToGroup() {
    Groups groups = app.db().groups();
    Contacts contacts = app.db().contacts();
    app.contact().findContact(contacts, groups, true);
    ContactData selectedContact = app.contact().findContact(contacts, groups, true);
    GroupData selectedGroup = app.contact().getGroupData(groups, selectedContact, true);
    assertTrue(app.contact().getaVoid(selectedContact), "нет контактов без групп ");
    assertTrue(app.contact().getaVoid(selectedGroup), " нет групп без контактов");
    Groups beforeGroupsInContact = selectedContact.getGroups();
    // app.goTo().contactPage();
    app.contact().addToGroup(selectedContact, selectedGroup);
    int contactId = selectedContact.getId();
    Contacts contactsAfter = app.db().contacts();
    Groups afterGroupsInContact = app.contact().getDataContactAfter(contactsAfter, contactId).getGroups();
    assertEquals(afterGroupsInContact.size(), (beforeGroupsInContact.size() + 1));
  }
}









