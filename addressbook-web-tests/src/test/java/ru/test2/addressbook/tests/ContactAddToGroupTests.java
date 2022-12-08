package ru.test2.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.test2.addressbook.model.ContactData;
import ru.test2.addressbook.model.Contacts;
import ru.test2.addressbook.model.GroupData;
import ru.test2.addressbook.model.Groups;

import java.util.*;

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
    List<ContactData> contactList = new ArrayList<>();
    contactList.addAll(contacts);
    for (int i = 0; i < contactList.size(); i++) {

      ContactData contact = contactList.get(i);

      List<GroupData> before = new ArrayList<>();

      for (GroupData group : groups) {
        if (!group.getContacts().contains(contact)) {
          before.add(group);
        }
      }
      if (before.size() > 0) {
        Groups beforeGroupsInContact = contact.getGroups();
       // app.goTo().contactPage();
        app.contact().addToGroup(contact, before.get(0));

        System.out.println("id contact " + contact.getId());
        System.out.println("group id " + before.get(0).getId());
        i = contactList.size();
        int id = contact.getId();
        Contacts contactsAfter = app.db().contacts();
        for (ContactData contactAfter : contactsAfter) {

          if (contactAfter.getId() == id) {
            Groups afterGroupsInContact = contactAfter.getGroups();
            Assert.assertEquals(afterGroupsInContact.size(), beforeGroupsInContact.size() + 1);
            System.out.println(afterGroupsInContact.size());
            System.out.println(beforeGroupsInContact.size() + 1);
          }

        }

      }


    }
  }

}










