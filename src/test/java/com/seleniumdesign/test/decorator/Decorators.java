package com.seleniumdesign.test.decorator;

import com.seleniumdesign.decorator.DashboardPage;
import java.util.List;
import java.util.function.Consumer;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Decorators {

  private static void shouldDisplay(List<WebElement> elements) {
    elements.forEach(element -> Assert.assertTrue(element.isDisplayed()));
  }

  private static void shouldNotDisplay(List<WebElement> elements) {
    elements.forEach(element -> Assert.assertFalse(element.isDisplayed()));
  }

  // ingredients
  private static final Consumer<DashboardPage> adminComponentPresent =
      dashboardPage -> shouldDisplay(dashboardPage.getAdminComponents());
  private static final Consumer<DashboardPage> adminComponentNotPresent =
      dashboardPage -> shouldNotDisplay(dashboardPage.getAdminComponents());

  private static final Consumer<DashboardPage> superUserComponentPresent =
      dashboardPage -> shouldDisplay(dashboardPage.getSuperUserComponents());
  private static final Consumer<DashboardPage> superUserComponentNotPresent =
      dashboardPage -> shouldNotDisplay(dashboardPage.getSuperUserComponents());

  private static final Consumer<DashboardPage> guestComponentPresent =
      dashboardPage -> shouldDisplay(dashboardPage.getGuestComponents());
  private static final Consumer<DashboardPage> guestComponentNotPresent =
      dashboardPage -> shouldNotDisplay(dashboardPage.getGuestComponents());

  // role selection
  private static final Consumer<DashboardPage> adminSelection =
      dashboardPage -> dashboardPage.selectRole("admin");
  private static final Consumer<DashboardPage> superUserSelection =
      dashboardPage -> dashboardPage.selectRole("superuser");
  private static final Consumer<DashboardPage> guestSelection =
      dashboardPage -> dashboardPage.selectRole("guest");

  // user role pages
  public static final Consumer<DashboardPage> guestPage =
      guestSelection
          .andThen(guestComponentPresent)
          .andThen(superUserComponentNotPresent)
          .andThen(adminComponentNotPresent);
  public static final Consumer<DashboardPage> superUserPage =
      superUserSelection
          .andThen(guestComponentPresent)
          .andThen(superUserComponentPresent)
          .andThen(adminComponentNotPresent);
  public static final Consumer<DashboardPage> adminPage =
      adminSelection
          .andThen(guestComponentPresent)
          .andThen(superUserComponentPresent)
          .andThen(adminComponentPresent);
}
