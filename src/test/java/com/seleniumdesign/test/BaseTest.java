package com.seleniumdesign.test;

import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

  protected WebDriver driver;

  @BeforeTest
  public void setupDriver() {
    System.setProperty(
        "webdriver.gecko.driver", "C:/Users/deepa/Downloads/BrowserDrivers/geckodriver.exe");
    this.driver = new FirefoxDriver();
  }

  @AfterTest
  public void quitDriver() {
    Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    this.driver.quit();
  }
}
