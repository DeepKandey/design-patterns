package com.seleniumdesign.test.executearound;

import com.seleniumdesign.executearound.MainPage;
import com.seleniumdesign.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

  private MainPage mainPage;

  @BeforeTest
  public void setMainPage() {
    this.mainPage = new MainPage(driver);
  }

  @Test
  public void frameTest() {
    this.mainPage.goTo();
    this.mainPage.onFrameA(a -> a.setFirstName("FN"));
    this.mainPage.onFrameB(b -> b.setFirstName("FN2"));
    this.mainPage.onFrameA(
        a -> {
          a.setLastName("LN");
          a.setMessage("Going to fill this text area");
        });
  }
}
