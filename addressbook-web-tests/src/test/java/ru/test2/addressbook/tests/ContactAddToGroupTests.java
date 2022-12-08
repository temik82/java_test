package ru.test2.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.test2.addressbook.model.ContactData;
import ru.test2.addressbook.model.Contacts;
import ru.test2.addressbook.model.GroupData;
import ru.test2.addressbook.model.Groups;

import java.util.*;

public class ContactAddToGroupTests extends TestBase {


  @Test
  public void testContactAddToGroup() {
    Groups groups = app.db().groups();
    Contacts contacts = app.db().contacts();
    List<ContactData> contactList = new ArrayList<>();
    contactList.addAll(contacts);
    for(int i=0;i<contactList.size();i++){
      ContactData contact = contactList.get(i);
      List<GroupData> before = new ArrayList<>();
      for (GroupData group: groups){
        if(!group.getContacts().contains(contact)){
        before.add(group);
      }
      }
      if(before.size()>0){
        app.goTo().contactPage();
        app.contact().addToGroup(contact,before.get(0));

        System.out.println("id contact " + contact.getId());
        System.out.println("group id "+before.get(0).getId());
        i=contactList.size();
      }
      System.out.println(before.size());
   //   System.out.println(before.iterator().next());
    }
  }

  }
//      for (GroupData group : groups) {
//        Groups before = contact.getGroups();
//        if (!before.contains(group)) {
//          contacts.add(contact);
//        }
     // System.out.println(before.iterator().next());
//
//
//        // System.out.println(contact.getId());
//        // System.out.println(before);
//

       // if (before.size() > 0) {
          //System.out.println(before);

         // System.out.println("id contact " + contact.getId());
       //   app.goTo().contactPage();
          // GroupData groupNext=before.iterator().next().getId();
          //app.contact().addToGroup(contact, before.stream().iterator().next().getId());
          // System.out.println(before.stream().iterator().next());

        // for (GroupData group:before){
        //System.out.println("group id "+group.getId());



      //  System.out.println(groups.stream().findFirst().get().getId());

      // app.contact().addToGroup(contact);


      // System.out.println(groups.iterator().next().getId());
      // GroupData groupId=groups.iterator().next();





  // app.goTo().contactPage();
  // app.contact().addToGroup(contact);
  // app.goTo().contactPage();
//  app.contact().addToGroup();

















