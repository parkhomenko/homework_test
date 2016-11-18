package task15.ATM;

import task15.ATM.money.Currency;

public class ATM {

    private long totalAmount = 1000000;
    private Card card;
    ATMSecurity atmSecurity = new ATMSecurity();
    Bank bank = new Bank();

    public void insertCard(Card card, String pinCode) {
        this.card = card;
        if (card.checkAlarmPinCode(pinCode)) {
            System.out.println("Please wait 5 minutes while ATM is been reloading");
            atmSecurity.makePhoto();
            atmSecurity.callPolice();
        }
        if (!card.checkPincode(pinCode)) {
            System.out.println("Wrong pincode");
            this.card = null;
        }
    }

    private void checkCardStatus(){
        if (!card.getStatus().equals("valid")){
            atmSecurity.makePhoto();
            if(!atmSecurity.comparePhoto()){
                atmSecurity.callPolice();
            }
    }
 }
    public void operationOfCashWithdrawal(int amount, Currency typeOfAccountFromWhichTakeMoney){
    if (!checkBalanceOfATM(amount))return;
    if (!checkBalanceOfCard(amount,typeOfAccountFromWhichTakeMoney)) return;
    int convertedAmount = bank.convertValueFromUAHToAnotherCurrency(amount, typeOfAccountFromWhichTakeMoney);
    card.getBankAccount().reduceBalance(convertedAmount, typeOfAccountFromWhichTakeMoney);
    reduceBalanceOfATM(amount);
        System.out.println("Operation has been done successfully");
        System.out.println(amount + " was debited from your account");
        System.out.println("Please won`t forget your card!");
    }

    public void operationOfCashAdding(int amount, Currency typeOfAccountFromWhichTakeMoney){
    if (!checkBalanceOfCard(amount,typeOfAccountFromWhichTakeMoney)) return;
    int convertedAmount = bank.convertValueFromUAHToAnotherCurrency(amount, typeOfAccountFromWhichTakeMoney);
    card.getBankAccount().increaseBalance(convertedAmount,typeOfAccountFromWhichTakeMoney);
    increaseBalanceOfATM(amount);
        System.out.println("Operation has been done successfully");
        System.out.println(amount + " was added to your account");
        System.out.println("Please won`t forget your card!");
    }

    public void transferringAmountToAnotherCard(Card cardOfBeneficiary, int amount, Currency typeOfAccountFromWhichTakeMoney){
    if (!checkBalanceOfCard(amount,typeOfAccountFromWhichTakeMoney)) return;
    String balances = cardOfBeneficiary.getBankAccount().getTypesOfAccount();
    if (balances.contains(typeOfAccountFromWhichTakeMoney.toString())){
        card.getBankAccount().reduceBalance(amount, typeOfAccountFromWhichTakeMoney);
        cardOfBeneficiary.getBankAccount().increaseBalance(amount, typeOfAccountFromWhichTakeMoney);
        System.out.println("Operation has been done successfully");
        System.out.println(amount + " was debited from your account");
        System.out.println("Please won`t forget your card!");
    }else{
        System.out.println("Operation was failed!");
        System.out.println("Card of beneficiary hasn`t got account for choosen value");
    }
    }

    public void printBalance(Currency currency){
      int balance =  card.getBankAccount().getBalanceOfAccount(currency);
      String type = currency.toString();
        System.out.println("Your balance of choosen account is: " + balance + " " + type);
    }



    private boolean checkBalanceOfATM(int amount){
        if (totalAmount<amount){
            System.out.println("Sorry! Not enough money in ATM");
            return false;
        }
        return true;
    }

    private boolean checkBalanceOfCard(int amount, Currency typeOfAccountFromWhichTakeMoney ){
        if (bank.convertValueToUAH(card.getBankAccount().getBalanceOfAccount(typeOfAccountFromWhichTakeMoney),typeOfAccountFromWhichTakeMoney)<amount){
            System.out.println("Not enough money at your account");
            return false;
        }
        return true;
    }

    private void reduceBalanceOfATM(int amount){
        totalAmount = totalAmount - amount;
    }

    private void increaseBalanceOfATM(int amount){
        totalAmount = totalAmount + amount;
    }

}
