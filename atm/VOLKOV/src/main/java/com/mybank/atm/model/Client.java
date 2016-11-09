package com.mybank.atm.model;

public class Client {

    private int clientId;
    private Card card;
    private String clientName;
    private String clientSurName;

    public Client(int clientId, Card card, String clientName, String clientSurName) {
        this.clientId = clientId;
        this.card = card;
        this.clientName = clientName;
        this.clientSurName = clientSurName;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSurName() {
        return clientSurName;
    }

    public void setClientSurName(String clientSurName) {
        this.clientSurName = clientSurName;
    }
}
