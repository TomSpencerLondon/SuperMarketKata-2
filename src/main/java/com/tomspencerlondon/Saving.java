package com.tomspencerlondon;

public class Saving {

  private final String name;
  private final Money money;

  public Saving(String name, Money money) {
    this.name = name;
    this.money = money;
  }

  public String name() {
    return name;
  }

  public Money money() {
    return money;
  }
}
