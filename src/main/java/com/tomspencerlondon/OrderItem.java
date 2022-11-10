package com.tomspencerlondon;

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
}
