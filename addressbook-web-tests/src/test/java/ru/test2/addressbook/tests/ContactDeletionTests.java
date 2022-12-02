package ru.test2.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.test2.addressbook.model.ContactData;
import ru.test2.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    if (app.db().contacts().size() == 0) {
      app.goTo().contactPage();
      app.contact().create(new ContactData().withFirstName("Petr")
              .withLastName("Petrov").withMobilePhone("8966666661")
              .withEmail("test7@test.ru").withEmail2("test5@test.ru")
              .withPostAddress("006783").withPhone2("890536111111").withWorkPhone("3000000000")
              .withEmail3("test6@test.ru").withHomePhone("4000000000").withAddress2("322234"));
    }
  }
  @Test
  public void testContactDeletion() {
    Contacts before = app.db().contacts();
    ContactData deletedContact=before.iterator().next();
    app.goTo().contactPage();
    app.contact().delete(deletedContact);
    Contacts after = app.db().contacts();
    assertEquals(after.size(), before.size() - 1);

    assertThat(after, equalTo(before.without(deletedContact)));



  }




}
