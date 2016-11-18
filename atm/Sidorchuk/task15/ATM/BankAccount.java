package task15.ATM;

import task15.ATM.money.Currency;
import java.util.Date;
import java.util.Random;

public class BankAccount {

   private class Account{
        private Currency typeOfAccount;
        private int balance;

        public Account(Currency typeOfAccount, int balance) {
            this.typeOfAccount = typeOfAccount;
            this.balance = balance;
        }

        public Currency getTypeOfAccount() {
            return typeOfAccount;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }
    }
   private Account acccount1;
   private Account acccount2;
   private Account acccount3;
   private Account acccount4;
   private TransactionHistory transactionHistory;

    public BankAccount(Currency currency1, int balance1) {
        this.acccount1 = new Account(currency1, balance1);
    }
    public BankAccount(Currency currency1,int balance1, Currency currency2, int balance2) {
        this.acccount1 = new Account(currency1, balance1);
        this.acccount2 = new Account(currency2, balance2);
    }
    public BankAccount(Currency currency1,int balance1, Currency currency2, int balance2, Currency currency3, int balance3) {
        this.acccount1 = new Account(currency1, balance1);
        this.acccount2 = new Account(currency2, balance2);
        this.acccount3 = new Account(currency3, balance3);
    }
    public BankAccount(Currency currency1,int balance1, Currency currency2, int balance2, Currency currency3, int balance3, Currency currency4, int balance4) {
        this.acccount1 = new Account(currency1,balance1);
        this.acccount2 = new Account(currency2,balance2);
        this.acccount3 = new Account(currency3, balance3);
        this.acccount4 = new Account(currency4, balance4);
    }

    public void increaseBalance(int amount, Currency currency){
        if(!acccount1.equals(null)){
        if(acccount1.getTypeOfAccount().equals(currency)){
            acccount1.setBalance(acccount1.getBalance()+amount);
            return;
        }}
        if(!acccount2.equals(null)){
        if(acccount2.getTypeOfAccount().equals(currency)){
            acccount2.setBalance(acccount2.getBalance()+amount);
            return;
        }}
        if(!acccount3.equals(null)){
        if(acccount3.getTypeOfAccount().equals(currency)){
            acccount3.setBalance(acccount3.getBalance()+amount);
            return;
        }}
        if(!acccount4.equals(null)){
        if(acccount4.getTypeOfAccount().equals(currency)){
            acccount4.setBalance(acccount4.getBalance()+amount);
            return;
        }}
        }

    public void reduceBalance(int amount, Currency currency){
        if(!acccount1.equals(null)){
            if(acccount1.getTypeOfAccount().equals(currency)){
                acccount1.setBalance(acccount1.getBalance()-amount);
                return;
            }}
        if(!acccount2.equals(null)){
            if(acccount2.getTypeOfAccount().equals(currency)){
                acccount2.setBalance(acccount2.getBalance()-amount);
                return;
            }}
        if(!acccount3.equals(null)){
            if(acccount3.getTypeOfAccount().equals(currency)){
                acccount3.setBalance(acccount3.getBalance()-amount);
                return;
            }}
        if(!acccount4.equals(null)){
            if(acccount4.getTypeOfAccount().equals(currency)){
                acccount4.setBalance(acccount4.getBalance()-amount);
                return;
            }}

    }

    public int getBalanceOfAccount(Currency currency){
        if(!acccount1.equals(null)){
            if(acccount1.getTypeOfAccount().equals(currency)){
                return acccount1.getBalance();
            }}
        if(!acccount2.equals(null)){
            if(acccount2.getTypeOfAccount().equals(currency)){
                return acccount2.getBalance();
            }}
        if(!acccount3.equals(null)){
            if(acccount3.getTypeOfAccount().equals(currency)){
                return acccount3.getBalance();
            }}
        if(!acccount4.equals(null)){
            if(acccount4.getTypeOfAccount().equals(currency)){
                return acccount4.getBalance();
            }}

        return -1;
    }

    public String getTypesOfAccount (){
        String currency1;
        String currency2;
        String currency3;
        String currency4;
        String currencies;
        if(!acccount1.getTypeOfAccount().toString().equals(null)){
           currency1 = acccount1.getTypeOfAccount().toString();
        }currency1 = "There isn`t such currency";
        if(!acccount2.getTypeOfAccount().toString().equals(null)){
            currency2 = acccount2.getTypeOfAccount().toString();
        }currency2 = "There isn`t such currency";
        if(!acccount3.getTypeOfAccount().toString().equals(null)){
            currency3 = acccount3.getTypeOfAccount().toString();
        }currency3 = "There isn`t such currency";
        if(!acccount4.getTypeOfAccount().toString().equals(null)){
            currency4 = acccount4.getTypeOfAccount().toString();
        }currency4 = "There isn`t such currency";

        return currencies = currency1 + "," + currency2 + "," + currency3 + "," + currency4;
    }

    }


