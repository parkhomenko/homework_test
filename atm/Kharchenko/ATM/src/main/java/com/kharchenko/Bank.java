package com.kharchenko;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bank {
    private String name;
    private Person person;
    private Card card;
    private Account account;
    private Security security;
    private Map<Integer, Account> dataBase = new HashMap<Integer, Account>();
    private Scanner scanner = new Scanner(System.in);

    public Bank(String name) {
        this.name = name;
    }

    public void addNewClient(Person person, Currency currency) {
        System.out.println("Hello, " + person.toString() + " we are waiting for you. \n" + "Let's start creating your bank account.");
        this.person = person;
        int cardNumber = (int) (10000 + (Math.random() * 89999));
        int password = (int) (1000 + (Math.random() * 8999));
        card = new Card(cardNumber, currency, password);
        System.out.println("This is confidential information. You must keep it in safety:");
        System.out.println("your card number is - " + cardNumber);
        System.out.println("your password is - " + password);
        account = new Account(card, person, currency, 0);
        dataBase.put(cardNumber, account);
        System.out.println("How much money would you like to add on your account?");
        int value = scanner.nextInt();
        addMoney(cardNumber, value);
        System.out.println(person.toString() + " thank you that you choose our bank!");
    }

    public void setSecurity(Account account) {
        this.security = new Security(account);
    }

    public void addMoney(int cardNumber, int value) {
        Account account = dataBase.get(cardNumber);
        account.addMoney(value);
        dataBase.put(cardNumber, account);
    }

    public void getMoney(int cardNumber, int value) {
        Account account = dataBase.get(cardNumber);
        account.takeMoney(value);
        dataBase.put(cardNumber, account);
    }

    public int getBalance(int cardNumber) {
        return dataBase.get(cardNumber).getMoney();
    }

    public boolean checkingCard(int cardNumber) {
        if (dataBase.containsKey(cardNumber)) return true;
        return false;
    }

    public void sendMoney(int cardNumber, int toCardNumber, int sum) {
        getMoney(cardNumber, sum);
        addMoney(toCardNumber, sum);
    }

    public boolean checkingAccount(int cardNumber, int pinNumber) {
        setSecurity(dataBase.get(cardNumber));
        if (security.checkingAccount(cardNumber, pinNumber)) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public Person getPerson() {
        return person;
    }

    public Card getCard() {
        return card;
    }

    public Account getAccount() {
        return account;
    }

}
