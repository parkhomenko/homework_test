package task15.ATM;

import task15.ATM.money.Currency;

public class Main {
    public static void main(String[] args) {
        Card card = new Card(new Person("Daniil", "Sidorchuk", "24", "Cat"), Currency.EUR, 1000, Currency.USD,2000);
        ATM atm = new ATM();
        card.setPinCode("1111", "0000");
        atm.insertCard(card,"0000");
        atm.operationOfCashAdding(1000, Currency.EUR);
        atm.operationOfCashWithdrawal(500, Currency.USD);
        atm.printBalance(Currency.EUR);
        atm.printBalance(Currency.USD);


    }



}
