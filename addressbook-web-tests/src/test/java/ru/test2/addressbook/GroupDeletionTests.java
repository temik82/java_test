package ru.test2.addressbook;


import org.testng.annotations.Test;


public class GroupDeletionTests extends TestBase {


  @Test
  public void testGroupDeletion() throws Exception {
    goToGroupPage();
    selectGroup();
    deleteSelectedGroup();
    returnToGroupPage();
  }


}
