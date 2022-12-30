package ru.test2.addressbook.tests;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import ru.test2.addressbook.appmanager.ApplicationManager;
import org.testng.internal.IResultListener2;

public class MyTestListener implements IResultListener2 {
  @Override
  public void onConfigurationSuccess(ITestResult tr) {

  }

  @Override
  public void onConfigurationSuccess(ITestResult tr, ITestNGMethod tm) {

  }

  @Override
  public void onConfigurationFailure(ITestResult tr) {

  }

  @Override
  public void onConfigurationFailure(ITestResult tr, ITestNGMethod tm) {

  }

  @Override
  public void onConfigurationSkip(ITestResult tr) {

  }

  @Override
  public void onConfigurationSkip(ITestResult tr, ITestNGMethod tm) {

  }

  @Override
  public void beforeConfiguration(ITestResult tr) {

  }

  @Override
  public void beforeConfiguration(ITestResult tr, ITestNGMethod tm) {

  }

  @Override
  public void onTestStart(ITestResult result) {

  }

  @Override
  public void onTestSuccess(ITestResult result) {

  }

//  @Attachment(value = "Page screenshot", type = "image/png",fileExtension = ".png")
//  public byte[] saveScreenshot(byte[] screenShot) {
//    return screenShot;
//  }

//  @Override
//  public void onTestFailure(ITestResult result) {
//    ApplicationManager app=(ApplicationManager) result.getTestContext().getAttribute("app");
//    saveScreenshot(app.takeScreenShot());
//
//  }





  @Override
  public void onTestSkipped(ITestResult result) {
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

  }

  @Override
  public void onTestFailedWithTimeout(ITestResult result) {

  }

  @Override
  public void onStart(ITestContext context) {

  }

  @Override
  public void onFinish(ITestContext context) {

  }
}
