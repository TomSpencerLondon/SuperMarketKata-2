package com.tomspencerlondon;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Collections;
import org.junit.jupiter.api.Test;

public class ReceiptTest {
  @Test
  void givenAddedItemReceiptHasItemPriceSubTotalEmptyListOfSavingsZeroTotalSavingsItemPriceTotalToPay() {
    Receipt receipt = new Receipt(
        new Money(CurrencyType.POUND, BigDecimal.ZERO),
        Collections.EMPTY_LIST,
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
}
