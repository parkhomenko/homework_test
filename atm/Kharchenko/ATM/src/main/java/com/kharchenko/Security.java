package com.kharchenko;

import java.util.LinkedList;

public class Security {
    private Account account;
    private LinkedList<Integer> blockedCards = new LinkedList<Integer>();

    public Security(Account account) {
        this.account = account;
    }

    public boolean checkingAccount(int cardNumber, int pin) {
        if (checkingIsBlocked(cardNumber)) return false;
        if (cardNumber == account.getCard().getNumber() && pin == account.getCard().getPin()) {
            return true;
        }
        blockedCards.add(cardNumber);
        return false;
    }

    public boolean checkingIsBlocked(int cardNumber) {
        return (blockedCards.contains(cardNumber));
    }
}
