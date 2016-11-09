package com.mybank.atm.controller;

import com.mybank.atm.model.Client;
import com.mybank.atm.repository.ClientsRepository;

import java.util.List;
import java.util.Scanner;

public class MyBank extends ATM {

    private Client client;
    private Client currentClient;
    private ClientsRepository clientsRepository = new ClientsRepository();
    private int truePinNum;
    private int clientId;
    private int selected;
    private List<Client> clients = clientsRepository.getClients();


    public void startUpATM() {
        clientsRepository.creatClients();
        System.out.println("Hello \nWeclcom to MyBank ");
        cardVarification();
    }

    public void cardVarification() {
        System.out.println("Please enter your card number:");

        boolean triger = false;
        int enteredCardNumber = 0;
        truePinNum = 0;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            enteredCardNumber = scanner.nextInt();
        } else {
            System.out.println("Wrong Card Number \nTry again");
            cardVarification();
        }
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getCard().getCardNum() == enteredCardNumber) {
                int checkI=i;
                clientId = clients.get(i).getClientId();
                truePinNum = clients.get(i).getCard().getCardPin();
                System.out.println("Card Number correct");
                if (clients.get(checkI).getCard().getCardType() != "Visa") {
                    System.out.println("But your Card type is wrong \nPleas try again another card");
                    cardVarification();
                }
                triger = true;
            }
        }
        if (triger) {
            pinVarification();
        } else {
            System.out.println("Wrong Card Number \nTry again");
            cardVarification();
        }
    }

    public void pinVarification() {
        System.out.println("Enter Pin Number");
        Scanner scanner = new Scanner(System.in);
        int enteredPin = 0;
        if (scanner.hasNextInt()) {
            enteredPin = scanner.nextInt();
        } else {
            System.out.println("Wrong Pin Number \nTry again");
            cardVarification();
        }
        if (enteredPin == truePinNum) {
            System.out.println("Your Pin  is OK");
            greeting();
        } else {
            System.out.println("Wrong Pin Number \nTry again");
            cardVarification();
        }
    }

    public void greeting() {
        currentClient = clientsRepository.getClientByID(clientId);
        System.out.println("Hello " + currentClient.getClientName() + " " + currentClient.getClientSurName());
        System.out.println(" ");
        makeSelect();
    }

    public void makeSelect() {
        System.out.println("Select your options:");
        System.out.println("Enter 1 to check your balance:");
        System.out.println("Enter 2 to print bill:");
        System.out.println("Enter 3 to take money:");
        System.out.println("Enter 4 to transfer money:");
        System.out.println("Enter 5 to exit");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            selected = scanner.nextInt();
        } else {
            System.out.println("Wrong select \nTry again");
            makeSelect();
        }
        if (selected == 1) {
            System.out.println(currentClient.getClientName() + " " + currentClient.getClientSurName() + "\n" +"Your balance is " + currentClient.getCard().getAcount().getMoneyOnAcount() + "$");
            System.out.println(" ");
            makeSelect();
        } else if (selected == 2) {
            System.out.println(
                    "MyBank\n" +
                            currentClient.getClientName() + " " + currentClient.getClientSurName() + "\n" +
                            "Card number " + currentClient.getCard().getCardNum() + " Card type " + currentClient.getCard().getCardType() + "\n" +
                            "Your balance " + currentClient.getCard().getAcount().getMoneyOnAcount() + "$\n" +
                            "Good bye"

            );
            System.out.println(" ");
            makeSelect();
        } else if (selected == 3) {
            takeMoney();

        } else if (selected == 4) {
            transferMoney();

        } else if (selected == 5) {
            System.out.println("Good Bye");
            System.out.println(" ");
            startUpATM();

        } else {
            makeSelect();
        }


    }

    private void transferMoney() {
        Scanner scanner = new Scanner(System.in);
        int idNumToTransfer=0;
        int moneyToTransfer=0;
        System.out.println("Please enter card number of client to whom you want make transfer:");
        if (scanner.hasNextInt()) {
            idNumToTransfer = scanner.nextInt();
        } else {
            System.out.println("Wrong select \nTry again");
            transferMoney();
        }
        Client clientToTransfer = clientsRepository.getClientByCardNum(idNumToTransfer);
        if (clientToTransfer==null || clientToTransfer.getCard().getCardNum()==currentClient.getCard().getCardNum()){
            System.out.println("Wrong card number");
            transferMoney();
        }
        System.out.println("How much money you want to  transfer?");
        if (scanner.hasNextInt()) {
            moneyToTransfer = scanner.nextInt();
        } else {
            System.out.println("Wrong select \nTry again");
            transferMoney();
        }
        if (idNumToTransfer!=0 && (moneyToTransfer>0 && moneyToTransfer<1+currentClient.getCard().getAcount().getMoneyOnAcount())) {
            int moneyOnCurrentClientAcount = currentClient.getCard().getAcount().getMoneyOnAcount();
            currentClient.getCard().getAcount().setMoneyOnAcount(moneyOnCurrentClientAcount-moneyToTransfer);
            int moneyOnTransferClientAcount = clientToTransfer.getCard().getAcount().getMoneyOnAcount();
            clientToTransfer.getCard().getAcount().setMoneyOnAcount(moneyOnTransferClientAcount+moneyToTransfer);
            System.out.println("Your balance now is " +currentClient.getCard().getAcount().getMoneyOnAcount()+"$" );
            System.out.println(clientToTransfer.getClientName() +" "+clientToTransfer.getClientSurName() + " balance now is " +clientToTransfer.getCard().getAcount().getMoneyOnAcount()+"$" );
            System.out.println(" ");
        }
        else if (moneyToTransfer>currentClient.getCard().getAcount().getMoneyOnAcount()-1) {
            System.out.println("Not enough money\nPleas try again");
            transferMoney();
        } else {
            System.out.println("Something go wrong\nTry again");
            transferMoney();
        }
        makeSelect();

    }

    private void takeMoney() {
        Scanner scanner = new Scanner(System.in);
        int takedMoney = 0;
        System.out.println("How much you want to take?");
        if (scanner.hasNextInt()) {
            takedMoney = scanner.nextInt();
        } else {
            System.out.println("Wrong select \nTry again");
            takeMoney();
        }
        if (takedMoney > 0) {
            int moneyOnAcount = currentClient.getCard().getAcount().getMoneyOnAcount();
            if (moneyOnAcount < takedMoney) {
                System.out.println("Not enough money on your balance");
                takeMoney();
            } else {
                currentClient.getCard().getAcount().setMoneyOnAcount(moneyOnAcount - takedMoney);
            }
            System.out.println("Now your balance " + currentClient.getCard().getAcount().getMoneyOnAcount()+"$");
            makeSelect();
        }


    }


}
