package com.tomspencerlondon;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
  private Money subTotal;
  private List<Saving> savings;
  private Money totalSaving;
  private Money totalToPay;
  private final List<OrderItem> orderItems;

  public Receipt(Money subTotal, List<Saving> savings, Money totalSaving, Money totalToPay) {
    this.subTotal = subTotal;
    this.savings = savings;
    this.totalSaving = totalSaving;
    this.totalToPay = totalToPay;
    orderItems = new ArrayList<>();
  }

  public List<OrderItem> orderItems() {
    return orderItems;
  }

  public Money subTotal() {
    int countOfBeans = 0;

    for (OrderItem orderItem : orderItems) {
      Money price = orderItem.price();
      subTotal = subTotal.plus(price);

      if (orderItem.order().equals("Beans")) {
        countOfBeans++;
      }

      if (countOfBeans == 3) {
        Saving beanSaving = new Saving("Beans 3 for 2", new Money(CurrencyType.POUND, new BigDecimal("-0.50")));
        savings.add(beanSaving);
        totalSaving = totalSaving.plus(beanSaving.money());
      }
    }
    return subTotal;
  }

  public List<Saving> savings() {
    return savings;
  }

  public Money totalSaving() {
    return totalSaving;
  }

  public Money totalToPay() {
    return subTotal.plus(totalSaving);
  }

  public void add(Item item) {
    orderItems.add(new OrderItem(item.name(), item.price()));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Receipt receipt = (Receipt) o;

    if (!subTotal.equals(receipt.subTotal)) {
      return false;
    }
    if (!savings.equals(receipt.savings)) {
      return false;
    }
    if (!totalSaving.equals(receipt.totalSaving)) {
      return false;
    }
    return totalToPay.equals(receipt.totalToPay);
  }

  @Override
  public int hashCode() {
    int result = subTotal.hashCode();
    result = 31 * result + savings.hashCode();
    result = 31 * result + totalSaving.hashCode();
    result = 31 * result + totalToPay.hashCode();
    return result;
  }
}
