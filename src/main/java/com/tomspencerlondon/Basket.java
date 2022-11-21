package com.tomspencerlondon;

import java.math.BigDecimal;
import java.util.Collections;

public class Basket {
  private final Receipt receipt = new Receipt(
      new Money(CurrencyType.POUND, BigDecimal.ZERO),
      Collections.emptyList(),
      new Money(CurrencyType.POUND, BigDecimal.ZERO),
      new Money(CurrencyType.POUND, BigDecimal.ZERO));

  public Receipt receipt() {
    return receipt;
  }

  public void add(Item item) {
  }
}
