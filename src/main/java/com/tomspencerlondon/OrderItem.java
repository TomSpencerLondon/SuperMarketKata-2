package com.tomspencerlondon;

import java.util.List;

public class OrderItem {
  private final String order;
  private final Money price;

  public OrderItem(String order, Money price) {
    this.order = order;
    this.price = price;
  }


  public Money price() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    OrderItem orderItem = (OrderItem) o;

    if (!order.equals(orderItem.order)) {
      return false;
    }
    return price.equals(orderItem.price);
  }

  @Override
  public int hashCode() {
    int result = order.hashCode();
    result = 31 * result + price.hashCode();
    return result;
  }
}
