package ru.test4.test.appmanager;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ApplicationManager {

  private final Properties properties;


  public ApplicationManager() {


    properties = new Properties();

  }

  public RestHelper rest() {
    return new RestHelper(this);
  }


  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

  }


  public String getProperty(String key) {
    return properties.getProperty(key);
  }


}