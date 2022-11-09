package com.tomspencerlondon;

import java.math.BigDecimal;

public class Money {
  private CurrencyType currencyType;
  private BigDecimal amount;

  public Money(CurrencyType currencyType, BigDecimal amount) {
    this.currencyType = currencyType;
    this.amount = amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Money money = (Money) o;

    if (currencyType != money.currencyType) {
      return false;
    }
    return amount.equals(money.amount);
  }

  @Override
  public int hashCode() {
    int result = currencyType.hashCode();
    result = 31 * result + amount.hashCode();
    return result;
  }
}
