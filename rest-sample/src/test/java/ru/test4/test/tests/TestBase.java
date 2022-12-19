package ru.test4.test.tests;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import ru.test4.test.appmanager.ApplicationManager;
import ru.test4.test.model.Issue;

import java.io.IOException;
import java.util.Set;


public class TestBase {


  protected static final ApplicationManager app = new ApplicationManager();

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }


  public boolean isIssueOpen(int issueId) throws IOException {
    Set<Issue> issues = app.rest().getIssuesFromJson(issueId);
    Issue issue = issues.iterator().next();
    System.out.println(issue.getState_name());
    String status = issue.getState_name();
    return !status.equals("Resolved");


  }

  public void skipIfNotFixed(int issueId) throws IOException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }

  }


}
