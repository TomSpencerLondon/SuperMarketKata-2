package com.tomspencerlondon;

public class Item {
  String name;
  Money price;
  Weight weight;
  ItemType itemType;

  public Item(String name, Money price, Weight weight, ItemType itemType) {
    this.name = name;
    this.price = price;
    this.weight = weight;
    this.itemType = itemType;
  }

  public String name() {
    return name;
  }

  public Money price() {
    return price;
  }

  public Weight weight() {
    return weight;
  }

  public ItemType itemType() {
    return itemType;
  }
}
