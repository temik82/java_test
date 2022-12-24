package ru.test2.addressbook.tests;

import io.qameta.allure.Attachment;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.test2.addressbook.appmanager.ApplicationManager;

public class MyTestListener implements ITestListener {

  @Override
  public void onTestStart(ITestResult result) {
    ITestListener.super.onTestStart(result);
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    ITestListener.super.onTestSuccess(result);
  }

  @Override
  public void onTestFailure(ITestResult result) {
    
    ApplicationManager app=(ApplicationManager) result.getTestContext().getAttribute("app");
    saveScreenshot(app.takeScreenShot());
  }
  @Attachment(value = "Page screenshot", type = "image/png")
  public byte[] saveScreenshot(byte[] screenShot) {
    return screenShot;
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    ITestListener.super.onTestSkipped(result);
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
  }

  @Override
  public void onTestFailedWithTimeout(ITestResult result) {
    ITestListener.super.onTestFailedWithTimeout(result);
  }

  @Override
  public void onStart(ITestContext context) {
    ITestListener.super.onStart(context);
  }

  @Override
  public void onFinish(ITestContext context) {
    ITestListener.super.onFinish(context);
  }
}
