package com.seleniumdesign.template.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonSearchPage {

  private WebDriver driver;

  @FindBy(id = "twotabsearchtextbox")
  private WebElement searchBox;

  @FindBy(css = "input#nav-search-submit-button")
  private WebElement searchBtn;

  public AmazonSearchPage(WebDriver driver) {
    this.driver = driver;
    //  PageFactory.initElements(driver, this);
  }

  public void goTo() {
    this.driver.get("https://www.amazon.com/");
  }

  public void search(String product) {
    this.searchBox.sendKeys(product);
    this.searchBtn.click();
  }
}
