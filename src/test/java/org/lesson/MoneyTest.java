package org.lesson;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class MoneyTest {
    @Test
    public void testMultiplicationDollar() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void testEqualityDollar() {
        assertEquals(Money.dollar(5), new Dollar(5));
        assertNotEquals(Money.dollar(5), new Dollar(8));
    }

    @Test
    public void testMultiplicationFranc() {
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    public void testEqualityFranc() {
        assertEquals(Money.franc(5), new Franc(5));
        assertNotEquals(Money.franc(5), new Franc(8));
    }

    @Test
    public void testCurrency() {
        assertEquals(Currency.USD, Money.dollar(1).currency());
        assertEquals(Currency.CHF, Money.franc(1).currency());
    }
}