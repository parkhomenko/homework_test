package task15.ATM;

import task15.ATM.money.Currency;

public class Bank {

    public int convertValueToUAH (int amount, Currency currency){
        switch (currency){
            case EUR:
                amount = amount * 28;
                break;
            case USD:
                amount = amount * 26;
                break;
            case GBP:
                amount = amount * 32;
                break;
            case UAH:
                amount = amount * 1;
                break;
        }
        return amount;
    }

    public int convertValueFromUAHToAnotherCurrency(int amount, Currency currency){
        switch (currency){
            case EUR:
                amount = amount / 28;
                break;
            case USD:
                amount = amount / 26;
                break;
            case GBP:
                amount = amount / 32;
                break;
            case UAH:
                amount = amount / 1;
                break;
        }
        return amount;
    }

}
