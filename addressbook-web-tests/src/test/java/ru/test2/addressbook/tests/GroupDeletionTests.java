package ru.test2.addressbook.tests;


import io.qameta.allure.Attachment;
import io.qameta.allure.Param;
import io.qameta.allure.Step;
import io.qameta.allure.model.Parameter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.test2.addressbook.model.GroupData;
import ru.test2.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
     if (app.db().groups().size() == 0){
    app.goTo().groupPage();
       app.group().create(new GroupData().withName("test1"));
     }
   }


  @Test

  public void testGroupDeletion() throws Exception {
    Groups before=app.db().groups();
    GroupData deletedGroup=before.iterator().next();
    app.goTo().groupPage();
    app.group().delete(deletedGroup);
    assertThat(app.group().count(), equalTo(before.size()+1));
    Groups after=app.db().groups();
    System.out.println(after);

    assertThat(after, equalTo(before.without(deletedGroup)));

  }
  @Test


  public void testGroupDeletion1() throws Exception {
    Groups before=app.db().groups();
    GroupData deletedGroup=before.iterator().next();
    app.goTo().groupPage();
    app.group().delete(deletedGroup);
    assertThat(app.group().count(), equalTo(before.size()+1));
    Groups after=app.db().groups();
    System.out.println(after);

    assertThat(after, equalTo(before.without(deletedGroup)));

  }
  @Test
  @Step("проверка")


  public void testGroupDeletion2() throws Exception {
    Groups before=app.db().groups();
    GroupData deletedGroup=before.iterator().next();
    app.goTo().groupPage();
    app.group().delete(deletedGroup);
    assertThat(app.group().count(), equalTo(before.size()-1));
    Groups after=app.db().groups();
    System.out.println(after);

    assertThat(after, equalTo(before.without(deletedGroup)));



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
