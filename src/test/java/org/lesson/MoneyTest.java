package org.lesson;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class MoneyTest {
    @Test
    public void testMultiplication() {
        Money fiveDollar = Money.dollar(5);
        assertEquals(Money.dollar(10), fiveDollar.times(2));
        assertEquals(Money.dollar(15), fiveDollar.times(3));

        Money fiveFranc = Money.franc(5);
        assertEquals(Money.franc(10), fiveFranc.times(2));
        assertEquals(Money.franc(15), fiveFranc.times(3));
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

    @Test
    public void testSimpleAddition() {
        Money fiveDollar = Money.dollar(5);
        Expression sum = fiveDollar.plus(fiveDollar);
        Bank bank = new Bank();
        Money reduce = bank.reduce(sum, Currency.USD);
        assertEquals(Money.dollar(10), reduce);

    }

    @Test
    public void testPlusReturnsSum() {
        Money fiveDollar = Money.dollar(5);
        Expression sumResult = fiveDollar.plus(fiveDollar);
        Sum sum = (Sum) sumResult;
        assertEquals(fiveDollar, sum.getAugment());
        assertEquals(fiveDollar, sum.getAddmend());

    }

    @Test
    public void testReduceSum() {
        Expression result = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money reduce = bank.reduce(result, Currency.USD);
        assertEquals(Money.dollar(7), reduce);
    }

    @Test
    public void testReduceMoney() {
        Bank bank = new Bank();
        Money reduce = bank.reduce(Money.dollar(1), Currency.USD);
        assertEquals(Money.dollar(1), reduce);

    }

    @Test
    public void testReduceMoneyDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate(Currency.CHF, Currency.USD, 2);
        Money result = bank.reduce(Money.franc(2), Currency.USD);
        assertEquals(Money.dollar(1.0), result);
    }

    @Test
    public void testIdentityRate() {

        assertEquals(1.0, new Bank().rate(Currency.USD, Currency.USD), 0);
        assertEquals(1.0, new Bank().rate(Currency.CHF, Currency.CHF), 0);
    }

    @Test
    public void testMixedAddition() {
        Expression dollar = Money.dollar(5);
        Expression franc = Money.franc(5);
        Bank bank = new Bank();
        bank.addRate(Currency.CHF, Currency.USD, 2);
        Money reduceSum = bank.reduce(dollar.plus(franc), Currency.USD);
        assertEquals(Money.dollar(7.5), reduceSum);

    }

    @Test
    public void testSumPlusMoney() {
        Money fiveDollars = Money.dollar(5);
        Money fiveFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate(Currency.CHF, Currency.USD, 2);
        Sum sum = new Sum(fiveDollars, fiveFrancs);
        Expression plus = sum.plus(fiveDollars);
        Money reduce = bank.reduce(plus, Currency.USD);
        assertEquals(Money.dollar(15), reduce);
    }

    @Test
    public void testTimeSum() {
        Money fiveDollars = Money.dollar(5);
        Money fiveFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate(Currency.CHF, Currency.USD, 2);
        Expression multiplier = new Sum(fiveDollars, fiveFrancs).times(2);
        Money reduce = bank.reduce(multiplier, Currency.USD);
        assertEquals(Money.dollar(20), reduce);

    }
}