package com.seleniumdesign.test.strategy;

import com.seleniumdesign.strategy.*;
import com.seleniumdesign.test.BaseTest;
import java.util.Map;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

public class PaymentScreenTest extends BaseTest {

  private PaymentScreen paymentScreen;

  @BeforeTest
  public void setPaymentScreen() {
    this.paymentScreen = new PaymentScreen(this.driver);
  }

  @Test(dataProvider = "getData")
  public void paymentTest(String option, Map<String, String> paymentDetails) {
    this.paymentScreen.goTo();
    this.paymentScreen.getUserInformation().enterDetails("Deepak", "Rai", "deepak@gmail.com");
    this.paymentScreen.setPaymentOption(PaymentOptionFactory.get(option));
    this.paymentScreen.pay(paymentDetails);
    String orderNumber = this.paymentScreen.getOrder().placeOrder();

    System.out.println("Order Number: " + orderNumber);
  }

  @DataProvider
  public Object[][] getData() {
    Map<String, String> cc = Maps.newHashMap();
    cc.put("cc", "123123231");
    cc.put("year", "2023");
    cc.put("cvv", "123");

    Map<String, String> nb = Maps.newHashMap();
    nb.put("bank", "WELLS FARGO");
    nb.put("account", "account123");
    nb.put("pin", "999");

    return new Object[][] {
      {"CC", cc},
      {"NB", nb}
    };
  }
}
