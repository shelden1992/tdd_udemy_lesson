package org.lesson;

import java.util.Objects;

/**
 * Created by Shelupets Denys on 2020-04-16.
 */
class Pair {
    private Currency from;
    private Currency to;

    public Pair(Currency from, Currency to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return from == pair.from &&
                to == pair.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
