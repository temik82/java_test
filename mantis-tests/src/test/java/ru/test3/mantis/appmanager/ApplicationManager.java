package ru.test3.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class ApplicationManager {

  private final Properties properties;

  private WebDriver wd;

  private String browser;
  private RegistrationHelper registrationHelper;
  private FtpHelper ftp;
  private MailHelper mailHelper;
  private SoapHelper soapHelper;
  private DbHelper dbHelper;
  private ChangePasswordHelper changePasswordHelper;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;

  public ApplicationManager(String browser) {
    this.browser = browser;

    properties = new Properties();

  }


  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    dbHelper = new DbHelper();
    if (browser.equals(BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if (browser.equals(BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    }
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.get(properties.getProperty("web.baseUrl"));
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));

  }

  public DbHelper db(){
    return dbHelper;
  }

  public void stop() {
    if (wd != null) {
      wd.quit();
    }

  }
  public NavigationHelper goTo() {
    return navigationHelper;
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public HttpSession newSession() {
    return new HttpSession(this);
  }

  public RegistrationHelper registration() {
    if (registrationHelper == null) {
      registrationHelper = new RegistrationHelper(this);
    }
    return registrationHelper;
  }
  public ChangePasswordHelper changePassword() {
    if (changePasswordHelper == null) {
      changePasswordHelper = new ChangePasswordHelper(this);
    }
    return changePasswordHelper;
  }

  public WebDriver getDriver() {
    if (wd == null) {

      if (browser.equals(BrowserType.CHROME)) {
        wd = new ChromeDriver();
      } else if (browser.equals(BrowserType.FIREFOX)) {
        wd = new FirefoxDriver();
      }


      wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
      wd.get(properties.getProperty("web.baseUrl"));
    }
    return wd;
  }

  public String getProperty(String key) {
    return properties.getProperty(key);
  }

  public FtpHelper ftp() {
    if (ftp == null) {
      ftp = new FtpHelper(this);
    }
    return ftp;
  }

  public MailHelper mail() {
    if (mailHelper == null) {
      mailHelper = new MailHelper(this);

    }
    return mailHelper;
  }
 // public DbHelper db(){
  //  return db;
 // }

  public SoapHelper soap(){
    if (soapHelper==null){
      soapHelper=new SoapHelper(this);

    }
    return soapHelper;
  }
}