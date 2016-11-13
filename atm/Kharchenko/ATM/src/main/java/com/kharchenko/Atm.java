package com.kharchenko;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Atm {
    private Money money;
    private TransactionHistory transactionHistory = new TransactionHistory();
    private Bank bank;
    private Scanner scanner = new Scanner(System.in);

    public Atm(Bank bank, Money money) {
        this.money = money;
        this.bank = bank;
        loadMoney();
    }

    public void loadMoney() {
        money.addMoney(BankNote.ONE, 10);
        money.addMoney(BankNote.TWO, 10);
        money.addMoney(BankNote.FIVE, 10);
        money.addMoney(BankNote.TEN, 10);
        money.addMoney(BankNote.TWENTY, 10);
        money.addMoney(BankNote.FIFTY, 10);
        money.addMoney(BankNote.ONE_HUNDRED, 10);
        money.addMoney(BankNote.TWO_HUNDRED, 10);
        money.addMoney(BankNote.FIVE_HUNDRED, 10);
    }

    public void useAtm() {
        System.out.println("Hello, you are starting to work with ATM of " + bank.getName() + " thank you for choose us.");
        System.out.println("Please enter your card:");
        int cardNumber = scanner.nextInt();
        if (bank.checkingCard(cardNumber)) {
            int i = 3;
            while (i > 0) {
                System.out.println("Please enter your PIN:");
                int pinNumber = scanner.nextInt();
                if (bank.checkingAccount(cardNumber, pinNumber)) {
                    System.out.println("Thank you! Your pin is OK.");
                    i = 0;
                    whatWouldYouWantToDo(cardNumber);
                } else {
                    i--;
                    if (i > 0) {
                        System.out.println("The pin is wrong, you have " + i + " chance to enter it correctly.");
                    } else {
                        System.out.println("Your card is blocked by the ATM, please contact your Bank.");
                    }
                }
            }
        }
        System.out.println("Sorry, you enter wrong card number, good bye.");
    }

    private void whatWouldYouWantToDo(int cardNumber) {
        System.out.println();
        System.out.println("If you want to know the balance on your card, press 1.");
        System.out.println("If you want to get cash, press 2.");
        System.out.println("If you want to send money to another card, press 3.");
        System.out.println("If you want to print the bill, press 4.");
        System.out.println("If you want to print the transaction history, press 5.");
        System.out.println("If you want to finish, press 6.");
        switch (scanner.nextInt()) {
            case 1:
                getBalance(cardNumber);
                break;
            case 2:
                getCash(cardNumber);
                break;
            case 3:
                sendMoney(cardNumber);
                break;
            case 4:
                printTheBill(cardNumber);
                break;
            case 5:
                getTransactionHistory(cardNumber);
                break;
            case 6:
                finished();
        }
    }

    private void getBalance(int cardNumber) {
        System.out.println("Balance of you card is " + bank.getBalance(cardNumber) + ".");
        transactionHistory.addTransaction(cardNumber, "Check balance by the ATM.");
        whatWouldYouWantToDo(cardNumber);
    }

    private void getCash(int cardNumber) {
        System.out.println("How much cash do you want to get? Minimum is 1, maximum is 1000.");
        int value = scanner.nextInt();
        if (bank.getBalance(cardNumber) > value) {
            if (money.getMoney(value)) {
                bank.getMoney(cardNumber, value);
                System.out.println("Take your " + value + bank.getCard().getCurency() + ".");
            }
        } else {
            System.out.println("You don't have enough money on your account to do this operation.");
        }
        transactionHistory.addTransaction(cardNumber, "Get cash from the ATM in sum " + value + ".");
        whatWouldYouWantToDo(cardNumber);
    }

    private void sendMoney(int cardNumber) {
        System.out.println("Please, enter the card number that you want to send money.");
        int cardAnother = scanner.nextInt();
        int sum = 0;
        if (bank.checkingCard(cardAnother)) {
            System.out.println("What sum do you want to send ?");
            sum = scanner.nextInt();
            if (bank.getBalance(cardNumber) > sum) {
                bank.sendMoney(cardNumber, cardAnother, sum);
            } else {
                System.out.println("Sorry, you don't have enough money on your account for this operation.");
            }
        } else {
            System.out.println("Sorry, you enter wrong card number.");
        }
        transactionHistory.addTransaction(cardNumber, "Send money from your account to the " + cardAnother + " in sum " + sum + ".");
        whatWouldYouWantToDo(cardNumber);
    }

    private void printTheBill(int cardNumber) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm dd.MM.yyyy");
        System.out.println();
        System.out.println("Bill" + "\n" + "You balance is " + bank.getBalance(cardNumber) + "\n" + format.format(date) + ".");
        transactionHistory.addTransaction(cardNumber, "Print the bill by the ATM.");
        whatWouldYouWantToDo(cardNumber);
    }

    private void getTransactionHistory(int cardNumber) {
        System.out.println("Transaction on your account: \n ");
        System.out.println(transactionHistory.getTransactions(cardNumber));
        transactionHistory.addTransaction(cardNumber, "Get transaction history by the ATM.");
        whatWouldYouWantToDo(cardNumber);
    }

    private void finished() {
        System.out.println("Thank you for using our ATM. We are waiting for you nex time.");
    }
}
