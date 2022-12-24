package bdd;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.BrowserType;
import ru.test2.addressbook.appmanager.ApplicationManager;
import ru.test2.addressbook.model.GroupData;
import ru.test2.addressbook.model.Groups;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupStepDefinitions {
  private ApplicationManager app;
  private Groups groups;
  private GroupData newGroup;

  @Before
  public void init() throws IOException {
  app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
  app.init();
  }


  @After
  public void stop(){
    app.stop();
    app=null;

  }

  @Given("^a set of groups$")
  public void loadGroups() {
  groups=app.db().groups();

  }
  @When("I create a new group with name (.+), header (.+) and footer (.+)$")
  public  void createGroup(String name,String header, String footer){
    newGroup= new GroupData().withName(name).withHeader(header).withFooter(footer);
    app.goTo().groupPage();
    app.group().create(newGroup);


  }
  @Then("^the new set of groups is equal to the old set with the added group$")
  public void verifyGroupCreated() {
    Groups newGroups = app.db().groups();
    assertThat(newGroups, equalTo(groups
            .withAdded(newGroup.withId(newGroups.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }
}
