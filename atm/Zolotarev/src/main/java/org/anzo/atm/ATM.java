package org.anzo.atm;

/**
 * Created by anzo0316 on 11/7/2016.
 */
public class ATM {


    private int usdCapacity;
    private int uahCapacity;
    private int eurCapacity;

    public ATM(int usdCapacity, int uahCapacity, int eurCapacity) {
        this.usdCapacity = usdCapacity;
        this.uahCapacity = uahCapacity;
        this.eurCapacity = eurCapacity;
    }

    public void getMoney(Card card, int money) {

        if (card.getCurrency() == Currency.USD) {
            usdCapacity -= money;
            card.setAccount(card.getAccount() - money);
        } else if (card.getCurrency() == Currency.UAH) {
            uahCapacity -= money;
            card.setAccount(card.getAccount() - money);
        } else if (card.getCurrency() == Currency.EUR) {
            eurCapacity -= money;
            card.setAccount(card.getAccount() - money);
        }


    }

    public int getUsdCapacity() {
        return usdCapacity;
    }

    public int getUahCapacity() {
        return uahCapacity;
    }

    public int getEurCapacity() {
        return eurCapacity;
    }
}
