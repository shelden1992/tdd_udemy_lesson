package org.lesson;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

/**
 * Created by Shelupets Denys on 2020-04-13.
 */
class Bank {
    private final Map<Pair, Double> currencyRateMap = new HashMap<>();


    public Money reduce(Expression source, Currency currency) {
        return source.reduce(this, currency);
    }

    public void addRate(Currency from, Currency to, double rate) {
        currencyRateMap.put(new Pair(from, to), rate);

    }

    public double rate(Currency from, Currency to) {
        Double rate = currencyRateMap.get(new Pair(from, to));

        if (isNull(rate) || from.equals(to)) rate = 1.0;
        return rate;
    }
}
