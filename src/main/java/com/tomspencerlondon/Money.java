package com.tomspencerlondon;

import java.math.BigDecimal;

public class Money {
  private CurrencyType currencyType;
  private BigDecimal amount;

  public Money(CurrencyType currencyType, BigDecimal amount) {
    this.currencyType = currencyType;
    this.amount = amount;
  }

  public BigDecimal amount() {
    return amount;
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

  public Money plus(Money money) {
    return new Money(currencyType, amount.add(money.amount()));
  }

  public Money minus(Money money) {
    return new Money(currencyType, amount.subtract(money.amount()));
  }
}
