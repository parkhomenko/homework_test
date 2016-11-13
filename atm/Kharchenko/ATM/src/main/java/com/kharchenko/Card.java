package com.kharchenko;

public class Card {
    private int number;
    private Currency currency;
    private int pin;

    public Card(int number, Currency currency, int pin) {
        this.number = number;
        this.currency = currency;
        this.pin = pin;
    }

    public int getNumber() {
        return number;
    }

    public Currency getCurency() {
        return currency;
    }

    public int getPin() {
        return pin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (number != card.number) return false;
        if (pin != card.pin) return false;
        return currency == card.currency;
    }
}
