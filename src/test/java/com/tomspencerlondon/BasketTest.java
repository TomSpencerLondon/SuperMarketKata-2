package com.tomspencerlondon;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Collections;
import org.junit.jupiter.api.Test;

public class BasketTest {

  @Test
  void givenEmptyBasketReceiptHasZeroSubTotalEmptyListOfSavingsZeroTotalSavingsZeroTotalToPay() {
    Receipt expected = new Receipt(
        new Money(CurrencyType.POUND, BigDecimal.ZERO),
        Collections.EMPTY_LIST,
        new Money(CurrencyType.POUND, BigDecimal.ZERO),
        new Money(CurrencyType.POUND, BigDecimal.ZERO));
    Basket basket = new Basket();

    assertThat(basket.receipt())
        .isEqualTo(expected);
  }
}
