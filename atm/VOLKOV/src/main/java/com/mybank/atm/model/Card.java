package com.mybank.atm.model;

public class Card{
    private int cardId;
    private int cardNum;
    private int cardPin;
    private String cardType;
    private Acount acount;

    public Card(int cardId, int cardNum, int cardPin, String cardType, Acount acount) {
        this.cardId = cardId;
        this.cardNum = cardNum;
        this.cardPin = cardPin;
        this.cardType = cardType;
        this.acount = acount;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    public int getCardPin() {
        return cardPin;
    }

    public void setCardPin(int cardPin) {
        this.cardPin = cardPin;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Acount getAcount() {
        return acount;
    }

    public void setAcount(Acount acount) {
        this.acount = acount;
    }
}
