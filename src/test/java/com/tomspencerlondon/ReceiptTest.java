package com.tomspencerlondon;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.jupiter.api.Test;

public class ReceiptTest {
  @Test
  void givenAddedItemReceiptHasItemPriceSubTotalEmptyListOfSavingsZeroTotalSavingsItemPriceTotalToPay() {
    Receipt receipt = new Receipt(
        new Money(CurrencyType.POUND, BigDecimal.ZERO),
        Collections.emptyList(),
        new Money(CurrencyType.POUND, BigDecimal.ZERO),
        new Money(CurrencyType.POUND, BigDecimal.ZERO));

    Money beansPrice = new Money(CurrencyType.POUND, new BigDecimal("0.50"));
    receipt.add(new Item("Beans", beansPrice,
        new Weight(BigDecimal.ZERO), ItemType.NORMAL));

    assertThat(receipt.subTotal())
        .isEqualTo(beansPrice);
    assertThat(receipt.savings())
        .isEmpty();
    assertThat(receipt.totalSaving())
        .isEqualTo(new Money(CurrencyType.POUND, BigDecimal.ZERO));
    assertThat(receipt.totalToPay())
        .isEqualTo(beansPrice);
  }

  @Test
  void givenAdded2ItemsReceiptHas2ItemPriceSubTotalEmptyListOfSavingsZeroTotalSavings2ItemsPriceTotalToPay() {
    Receipt receipt = new Receipt(
        new Money(CurrencyType.POUND, BigDecimal.ZERO),
        Collections.emptyList(),
        new Money(CurrencyType.POUND, BigDecimal.ZERO),
        new Money(CurrencyType.POUND, BigDecimal.ZERO));

    Money beansPrice = new Money(CurrencyType.POUND, new BigDecimal("0.50"));
    Item beans = new Item("Beans", beansPrice, new Weight(BigDecimal.ZERO), ItemType.NORMAL);
    receipt.add(beans);
    receipt.add(beans);

    Money expected = new Money(CurrencyType.POUND, new BigDecimal("1.00"));
    assertThat(receipt.subTotal())
        .isEqualTo(expected);
    assertThat(receipt.savings())
        .isEmpty();
    assertThat(receipt.totalSaving())
        .isEqualTo(new Money(CurrencyType.POUND, BigDecimal.ZERO));
    assertThat(receipt.totalToPay())
        .isEqualTo(expected);
    OrderItem beansOrder = new OrderItem("Beans", new Money(CurrencyType.POUND, new BigDecimal("0.50")));
    assertThat(receipt.orderItems())
        .containsExactly(beansOrder, beansOrder);
  }

  @Test
  void givenAdded3BeansReceiptHas3BeansPriceSubTotalOneSavingMinus50TotalSavings2BeansPriceTotalToPay() {
    Receipt receipt = new Receipt(
        new Money(CurrencyType.POUND, BigDecimal.ZERO),
        new ArrayList<>(),
        new Money(CurrencyType.POUND, BigDecimal.ZERO),
        new Money(CurrencyType.POUND, BigDecimal.ZERO));

    Money beansPrice = new Money(CurrencyType.POUND, new BigDecimal("0.50"));
    Item beans = new Item("Beans", beansPrice, new Weight(BigDecimal.ZERO), ItemType.NORMAL);
    receipt.add(beans);
    receipt.add(beans);
    receipt.add(beans);

    assertThat(receipt.subTotal())
        .isEqualTo(new Money(CurrencyType.POUND, new BigDecimal("1.50")));
    assertThat(receipt.savings())
        .hasSize(1);
    assertThat(receipt.totalSaving())
        .isEqualTo(new Money(CurrencyType.POUND, new BigDecimal("-0.50")));
    assertThat(receipt.totalToPay())
        .isEqualTo(new Money(CurrencyType.POUND, new BigDecimal("1.00")));
    OrderItem beansOrder = new OrderItem("Beans", new Money(CurrencyType.POUND, new BigDecimal("0.50")));
    assertThat(receipt.orderItems())
        .containsExactly(beansOrder, beansOrder, beansOrder);
  }

  @Test
  void givenAdded6BeansReceiptHas6BeansPriceSubTotalTwoSavingMinusOnePoundTotalSavings4BeansPriceTotalToPay() {
    Receipt receipt = new Receipt(
        new Money(CurrencyType.POUND, BigDecimal.ZERO),
        new ArrayList<>(),
        new Money(CurrencyType.POUND, BigDecimal.ZERO),
        new Money(CurrencyType.POUND, BigDecimal.ZERO));

    Money beansPrice = new Money(CurrencyType.POUND, new BigDecimal("0.50"));
    Item beans = new Item("Beans", beansPrice, new Weight(BigDecimal.ZERO), ItemType.NORMAL);
    receipt.add(beans);
    receipt.add(beans);
    receipt.add(beans);
    receipt.add(beans);
    receipt.add(beans);
    receipt.add(beans);

    assertThat(receipt.subTotal())
        .isEqualTo(new Money(CurrencyType.POUND, new BigDecimal("3.00")));
    assertThat(receipt.savings())
        .hasSize(2);
    assertThat(receipt.totalSaving())
        .isEqualTo(new Money(CurrencyType.POUND, new BigDecimal("-1.00")));
    assertThat(receipt.totalToPay())
        .isEqualTo(new Money(CurrencyType.POUND, new BigDecimal("2.00")));
    OrderItem beansOrder = new OrderItem("Beans", new Money(CurrencyType.POUND, new BigDecimal("0.50")));
    assertThat(receipt.orderItems())
        .containsExactly(
            beansOrder,
            beansOrder,
            beansOrder,
            beansOrder,
            beansOrder,
            beansOrder
        );
  }
}
