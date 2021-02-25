package com.seleniumdesign.test.factory;

import com.seleniumdesign.factory.GoogleFactory;
import com.seleniumdesign.factory.GooglePage;
import com.seleniumdesign.test.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

  private GooglePage googlePage;

  @Test(dataProvider = "getData")
  public void searchTest(String language, String keyword) {
    this.googlePage = GoogleFactory.get(language, this.driver);
    this.googlePage.launchSite();
    this.googlePage.search(keyword);
    int resultCount = this.googlePage.getResultCount();

    System.out.println("Result Count: " + resultCount);
  }

  @DataProvider
  public Object[][] getData() {
    return new Object[][] {
      {"ENG", "selenium"},
      {"FR", "kubernetes"},
      {"SA", "docker"}
    };
  }
}
