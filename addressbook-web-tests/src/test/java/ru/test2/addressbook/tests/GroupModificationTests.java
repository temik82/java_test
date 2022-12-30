package ru.test2.addressbook.tests;

import io.qameta.allure.Attachment;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.test2.addressbook.model.GroupData;
import ru.test2.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.db().groups().size() == 0){
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }


  }
  @Test
  public void testGroupModification() {
    Groups before=app.db().groups();
    GroupData modifiedGroup=before.iterator().next();
    GroupData group=new GroupData()
            .withId(modifiedGroup.getId()).withName("test3").withHeader("test2").withFooter("test3");
    app.goTo().groupPage();
    app.group().modify(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after=app.db().groups();

    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    verifyGroupListInUI();

  }


  @Attachment(value = "Page screenshot", type = "image/png")
  public byte[] saveScreenshot(byte[] screenShot) {
    return screenShot;
  }

  @AfterMethod
  public void after(ITestResult result) {
    if (!result.isSuccess()) {
      saveScreenshot(app.takeScreenShot());
    }
  }

}
