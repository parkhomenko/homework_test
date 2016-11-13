package com.kharchenko;

public class Account {
    private Card card;
    private Person person;
    private Currency currency;
    private int money;


    public Account(Card card, Person person, Currency currency, int money) {
        this.card = card;
        this.person = person;
        this.currency = currency;
        this.money = money;
    }

    public Card getCard() {
        return card;
    }

    public Person getPerson() {
        return person;
    }

    public Currency getCurrency() {
        return currency;
    }

    public int getMoney() {
        return money;
    }

    public void takeMoney(int value) {
        this.money -= value;
    }

    public void addMoney(int value) {
        this.money += value;
    }
}
