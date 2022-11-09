package com.tomspencerlondon;

import java.util.List;

public class Receipt {
  private final Money subTotal;
  private final List<Saving> savings;
  private final Money saving;
  private final Money totalToPay;

  public Receipt(Money subTotal, List<Saving> savings, Money saving, Money totalToPay) {
    this.subTotal = subTotal;
    this.savings = savings;
    this.saving = saving;
    this.totalToPay = totalToPay;
  }

  public Money subTotal() {
    return subTotal;
  }

  public List<Saving> savings() {
    return savings;
  }

  public Money saving() {
    return saving;
  }

  public Money totalToPay() {
    return totalToPay;
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
    if (!saving.equals(receipt.saving)) {
      return false;
    }
    return totalToPay.equals(receipt.totalToPay);
  }

  @Override
  public int hashCode() {
    int result = subTotal.hashCode();
    result = 31 * result + savings.hashCode();
    result = 31 * result + saving.hashCode();
    result = 31 * result + totalToPay.hashCode();
    return result;
  }
}
