package com.kharchenko;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Bank:)");
        Money money = new Money();
        Atm atm = new Atm(bank, money);

        Person firstPerson = new Person("Ivan", "Ivanova");
        Person secondPerson = new Person("Petr", "Petrov");

        bank.addNewClient(firstPerson, Currency.UAH);
        bank.addNewClient(secondPerson, Currency.UAH);

        atm.useAtm();
    }
}
