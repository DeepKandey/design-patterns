package com.seleniumdesign.test.decoratorAssignment;

import static com.seleniumdesign.test.decoratorAssignment.Decorators.*;

import com.seleniumdesign.decoratorAssignment.PaymentScreen;
import com.seleniumdesign.test.BaseTest;
import java.util.function.Consumer;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PaymentScreenTest extends BaseTest {

  private PaymentScreen paymentScreen;

  @BeforeTest
  public void setDashboardPage() {
    this.paymentScreen = new PaymentScreen(driver);
  }

  @Test(dataProvider = "getData")
  public void PaymentTest(Consumer<PaymentScreen> consumer) {
    this.paymentScreen.goTo();
    consumer.accept(paymentScreen);
  }

  @DataProvider
  public Object[] getData() {
    return new Object[] {
      validCC.andThen(buy).andThen(successfulPurchase),
      freeCoupon.andThen(buy).andThen(successfulPurchase),
      discountCoupon.andThen(validCC).andThen(buy).andThen(successfulPurchase),
      invalidCC.andThen(buy).andThen(failedPurchase),
      invalidCC.andThen(discountCoupon).andThen(buy).andThen(failedPurchase),
      buy.andThen(failedPurchase)
    };
  }
}
