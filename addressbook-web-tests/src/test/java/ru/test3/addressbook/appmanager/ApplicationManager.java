package ru.test3.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.test2.addressbook.appmanager.ContactHelper;

import java.time.Duration;

public class ApplicationManager {
  WebDriver wd;
  private SessionHelper sessionHelper;
  private ContactHelper contactHelper;

  public void init() {
    System.setProperty("webdriver.chrome.driver", "/Users/apple2/Documents/driver/chromedriver");
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    wd.get("http://localhost/addressbook/edit.php");
    contactHelper = new ContactHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }


  public void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }

  public void stop() {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }


  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}
