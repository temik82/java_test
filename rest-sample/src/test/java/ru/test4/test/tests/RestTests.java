package ru.test4.test.tests;

import org.testng.annotations.Test;
import ru.test4.test.model.Issue;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestTests extends TestBase {
  @Test(enabled = false)
  public void testCreateIssue() throws IOException {
    skipIfNotFixed(17);

    Set<Issue> oldIssues = app.rest().getIssues();
    Issue newIssue = new Issue().withSubject("test issue2").withDescription("New test issue");
    int issueId = app.rest().createIssue(newIssue);
    Set<Issue> newIssues = app.rest().getIssues();
    oldIssues.add(newIssue.withId(issueId));
    assertEquals(newIssues, oldIssues);


  }

  @Test
  public void testCreateIssue1() throws IOException {


    Set<Issue> oldIssues = app.rest().getIssues();
    Issue newIssue = new Issue().withSubject("test issue2").withDescription("New test issue");
    int issueId = app.rest().createIssue(newIssue);
    Set<Issue> newIssues = app.rest().getIssues();
    oldIssues.add(newIssue.withId(issueId));
    assertEquals(newIssues, oldIssues);


  }
}