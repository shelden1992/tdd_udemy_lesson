package org.lesson;

/**
 * Created by Shelupets Denys on 2020-04-13.
 */
public class Sum implements Expression {
    private Expression augment;
    private Expression addmend;

    public Sum(Expression augment, Expression addmend) {
        this.augment = augment;
        this.addmend = addmend;
    }

    public Expression getAugment() {
        return augment;
    }

    public Expression getAddmend() {
        return addmend;
    }

    @Override
    public Money reduce(Bank bank, Currency currency) {
        double amount = augment.reduce(bank, currency).amount + addmend.reduce(bank, currency).amount;
        return new Money(amount, currency);
    }

    @Override
    public Expression plus(Expression addmend) {
        return new Sum(this, addmend);
    }

    @Override
    public Expression times(double multiplier) {
        return new Sum(augment.times(multiplier), addmend.times(multiplier));
    }
}
