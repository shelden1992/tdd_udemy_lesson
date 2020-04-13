package org.lesson;

/**
 * Created by Shelupets Denys on 2020-04-13.
 */
public class Franc extends Money {


    public Franc(int amount) {
        super(amount);
    }

    public Money times(int multiplier) {
        return Money.franc(multiplier * amount);
    }

    @Override
    public Currency currency() {
        return Currency.CHF;
    }
}
