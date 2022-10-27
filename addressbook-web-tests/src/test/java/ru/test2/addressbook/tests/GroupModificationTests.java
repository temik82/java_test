package ru.test2.addressbook.tests;

import org.testng.annotations.Test;
import ru.test2.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase{
  @Test
  public void testGroupModification() {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();

  }
}
