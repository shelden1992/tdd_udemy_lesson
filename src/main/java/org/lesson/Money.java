package org.lesson;

import java.util.Objects;

/**
 * Created by Shelupets Denys on 2020-04-13.
 */
public class Money implements Expression {
    protected double amount;
    protected Currency currency;

    public Money(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(double amount) {
        return new Money(amount, Currency.USD);
    }

    public static Money franc(double amount) {
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

    public Expression times(double multiplier) {
        return new Money(multiplier * amount, this.currency);
    }

    public Currency currency() {
        return this.currency;
    }

    public Expression plus(Expression money) {
        return new Sum(this, money);
    }

    @Override
    public Money reduce(Bank bank, Currency currency) {
        double rate = bank.rate(this.currency, currency);
        return new Money(amount / rate, currency);
    }
}
