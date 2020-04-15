package org.lesson;

/**
 * Created by Shelupets Denys on 2020-04-13.
 */
public class Sum implements Expression {
    private Money augment;
    private Money addmend;

    public Sum(Money augment, Money addmend) {
        this.augment = augment;
        this.addmend = addmend;
    }

    public Money getAugment() {
        return augment;
    }

    public Money getAddmend() {
        return addmend;
    }

    @Override
    public Money reduce(Currency currency) {
        return new Money(addmend.amount + augment.amount, currency);
    }
}
