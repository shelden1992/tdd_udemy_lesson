package org.lesson;

/**
 * Created by Shelupets Denys on 2020-04-13.
 */
public class Bank {
    public Money reduce(Expression source, Currency currency) {
        return source.reduce(currency);
    }
}
