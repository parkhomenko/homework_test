package org.anzo.atm;

/**
 * Created by anzo0316 on 11/7/2016.
 */
public class Main {


    public static void main(String[] args) {


        Card card001 = new Card("Andrii", "Zolotarev", 909023321, 123, Currency.USD, 51800);
        Card card002 = new Card("Andrii", "Zolotarev", 909023331, 125, Currency.UAH, 10000);

        ATM atm1 = new ATM(3000, 4000, 5000);

        System.out.println(atm1.getUsdCapacity());
        System.out.println(atm1.getUahCapacity());
        System.out.println(atm1.getEurCapacity());

        atm1.getMoney(card001, 350);
        atm1.getMoney(card002, 200);

        System.out.println(atm1.getUsdCapacity());
        System.out.println(atm1.getUahCapacity());
        System.out.println(atm1.getEurCapacity());


    }
}
