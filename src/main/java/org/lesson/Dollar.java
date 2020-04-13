package org.lesson;

/**
 * Created by Shelupets Denys on 2020-04-12.
 */
public class Dollar extends Money {


    public Dollar(int amount) {
        super(amount);
    }

    public Money times(int multiplier) {
        return Money.dollar( multiplier * amount);
    }

    @Override
    public Currency currency() {
        return Currency.USD;
    }

}
