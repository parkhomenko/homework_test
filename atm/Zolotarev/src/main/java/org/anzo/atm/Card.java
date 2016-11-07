package org.anzo.atm;

import java.util.Currency;

/**
 * Created by anzo0316 on 11/7/2016.
 */
public class Card {

    private String name;
    private String lname;
    private long cardNumber;
    private int cvv;
    private org.anzo.atm.Currency currency;
    private int account;

    public Card(String name, String lname, long cardNumber, int cvv,  org.anzo.atm.Currency currency, int account) {
        this.name = name;
        this.lname = lname;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.currency = currency;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public String getLname() {
        return lname;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public org.anzo.atm.Currency getCurrency() {
        return currency;
    }

    public int getAccount() {
        return account;
    }


    public void setAccount(int account) {
        this.account = account;
    }
}
