package org.lesson;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class MoneyTest {
    @Test
    public void testMultiplication() {
        Money dollarFive = Money.dollar(5);
        assertEquals(Money.dollar(10), dollarFive.times(2));
        assertEquals(Money.dollar(15), dollarFive.times(3));

        Money francFive = Money.franc(5);
        assertEquals(Money.franc(10), francFive.times(2));
        assertEquals(Money.franc(15), francFive.times(3));
    }

    @Test
    public void testEquality() {
        assertEquals(Money.dollar(5), Money.dollar(5));
        assertNotEquals(Money.dollar(5), Money.dollar(8));
        assertNotEquals(Money.dollar(5), Money.franc(5));
        assertEquals(Money.franc(5), Money.franc(5));
        assertNotEquals(Money.franc(5), Money.franc(8));
    }

    @Test
    public void testCurrency() {
        assertEquals(Currency.USD, Money.dollar(1).currency());
        assertEquals(Currency.CHF, Money.franc(1).currency());
    }
}