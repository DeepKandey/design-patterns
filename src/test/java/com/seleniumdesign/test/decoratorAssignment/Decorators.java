package com.seleniumdesign.test.decoratorAssignment;

import com.seleniumdesign.decoratorAssignment.PaymentScreen;
import java.util.function.Consumer;
import org.testng.Assert;

public class Decorators {

  // actions
  public static final Consumer<PaymentScreen> freeCoupon = p -> p.applyPromoCode("FREEUDEMY");
  public static final Consumer<PaymentScreen> discountCoupon =
      p -> p.applyPromoCode("PARTIALUDEMY");
  public static final Consumer<PaymentScreen> validCC =
      p -> p.enterCC("4111111111111111", "2023", "123");
  public static final Consumer<PaymentScreen> invalidCC =
      p -> p.enterCC("4111111111111112", "2023", "123");
  public static final Consumer<PaymentScreen> buy = p -> p.buyProduct();

  // validations
  public static final Consumer<PaymentScreen> successfulPurchase =
      p -> Assert.assertEquals(p.getStatus(), "PASS");
  public static final Consumer<PaymentScreen> failedPurchase =
      p -> Assert.assertEquals(p.getStatus(), "FAIL");
}
