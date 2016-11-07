package org.anzo.atm;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by anzo0316 on 11/7/2016.
 */
public class AtmTests {

    ATM atm;
    Card card;
    Card card1;
    Card card2;

    @Before

    public void setUP() {
        atm = new ATM(20000, 100000, 300000);

        card = new Card("Andrii", "Zolotarov", 34127001, 123, Currency.USD, 52000);

        card1 = new Card("Andrii", "Zolotaro", 34127002, 124, Currency.UAH, 20000);

        card2 = new Card("Andrii", "Zolota", 34127003, 125, Currency.EUR, 30000);

    }


    @Test

    public void TestUSD() {

        atm.getMoney(card, 350);

        assertThat(card.getAccount(), is(51650));
        assertThat(atm.getUsdCapacity(), is(19650));

    }

    @Test
    public void TestUAH() {
        atm.getMoney(card1, 350);

        assertThat(card1.getAccount(), is(19650));
        assertThat(atm.getUahCapacity(), is(99650));

    }

    @Test
    public void TesyEUR() {

        atm.getMoney(card2, 350);


        assertThat(card2.getAccount(), is(29650));
        assertThat(atm.getEurCapacity(), is(299650));

    }


}
