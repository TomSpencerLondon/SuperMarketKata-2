package com.tomspencerlondon;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class MoneyTest {

  @Test
  void given£10plus£10MoneyIs£20() {
    Money money = new Money(CurrencyType.POUND, new BigDecimal("10.0"));

    assertThat(money.plus(money))
        .isEqualTo(new Money(CurrencyType.POUND, new BigDecimal("20.0")));
  }
}