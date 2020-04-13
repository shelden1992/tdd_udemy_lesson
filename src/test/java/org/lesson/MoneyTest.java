package org.lesson;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class MoneyTest {
    @Test
    public void testMultiplicationDollar() {
        Money five = new Money(5, Currency.USD);
        assertEquals(new Money(10, Currency.USD), five.times(2));
        assertEquals(new Money(15, Currency.USD), five.times(3));
    }

    @Test
    public void testEqualityDollar() {
        assertEquals(Money.dollar(5), new Dollar(5, Currency.USD));
        assertNotEquals(Money.dollar(5), new Dollar(8, Currency.USD));
    }

    @Test
    public void testMultiplicationFranc() {
        Money five = Money.franc(5);
        assertEquals(new Money(10, Currency.CHF), five.times(2));
        assertEquals(new Money(15, Currency.CHF), five.times(3));
    }

    @Test
    public void testEqualityFranc() {
        assertEquals(Money.franc(5), new Franc(5, Currency.CHF));
        assertNotEquals(Money.franc(5), new Franc(8, Currency.CHF));
    }

    @Test
    public void testCurrency() {
        assertEquals(Currency.USD, Money.dollar(1).currency());
        assertEquals(Currency.CHF, Money.franc(1).currency());
    }
}