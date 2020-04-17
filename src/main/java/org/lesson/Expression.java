package org.lesson;

/**
 * Created by Shelupets Denys on 2020-04-13.
 */
public interface Expression {
    Money reduce(Bank bank, Currency currency);

}
