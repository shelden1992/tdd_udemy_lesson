package org.lesson;

import java.util.Objects;

/**
 * Created by Shelupets Denys on 2020-04-13.
 */
public class Money {
    protected int amount;
    protected Currency currency;

    public Money(int amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, Currency.USD);
    }

    public static Money franc(int amount) {
        return new Money(amount, Currency.CHF);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount &&
                currency == money.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    public Money times(int multiplier) {
        return new Money(multiplier * amount, this.currency);
    }

    public Currency currency() {
        return this.currency;
    }
}
