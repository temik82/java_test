package ru.test4.test.tests;

import org.testng.SkipException;
import org.testng.annotations.AfterSuite;

import java.net.MalformedURLException;
import java.rmi.RemoteException;


public class TestBase {





  public boolean isIssueOpen(int issueId) throws MalformedURLException, RemoteException {
//    MantisConnectPortType mc = app.soap().getMantisConnect();
//    IssueData selectedIssueData = mc.mc_issue_get(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"), BigInteger.valueOf(issueId));
//    System.out.println(selectedIssueData.getStatus().getName());
//    String status = selectedIssueData.getStatus().getName();
//    return !status.equals("resolved");
return false;

  }

  public void skipIfNotFixed(int issueId) throws MalformedURLException, RemoteException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {

  }


}
