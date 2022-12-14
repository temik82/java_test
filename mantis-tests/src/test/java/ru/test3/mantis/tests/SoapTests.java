package ru.test3.mantis.tests;

import org.testng.annotations.Test;
import ru.test3.mantis.model.Issue;
import ru.test3.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class SoapTests extends TestBase {

  @Test
  public void testGetProjects() throws RemoteException, MalformedURLException, ServiceException {

    Set<Project> projects = app.soap().getProjects();
    System.out.println(projects.size());
    for (Project project : projects) {
      System.out.println((project.getName()));
    }
  }

  @Test(enabled = false)
  public void testCreateIssue() throws MalformedURLException, ServiceException, RemoteException {
    Set<Project> projects = app.soap().getProjects();
    Issue issue = new Issue().withSummary("test issue").
            withDescription("test issue description").withProject(projects.iterator().next());
    Issue created = app.soap().addIssue(issue);
    assertEquals(issue.getSummary(), created.getSummary());


  }

  @Test
  public void testCreateIssue1() throws MalformedURLException, ServiceException, RemoteException {
    skipIfNotFixed(0000001);

    Set<Project> projects = app.soap().getProjects();
    Issue issue = new Issue().withSummary("test issue").
            withDescription("test issue description").withProject(projects.iterator().next());
    Issue created = app.soap().addIssue(issue);
    assertEquals(issue.getSummary(), created.getSummary());

  }
}
