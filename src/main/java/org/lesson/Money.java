package org.lesson;

import java.util.Objects;

/**
 * Created by Shelupets Denys on 2020-04-13.
 */
public abstract class Money {
    protected int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public static Dollar dollar(int amount) {
        return new Dollar(amount);
    }

    public static Franc franc(int amount) {
        return new Franc(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    public abstract Money times(int times);

    public abstract Currency currency();
}
