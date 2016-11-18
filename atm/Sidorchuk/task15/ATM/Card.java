package task15.ATM;

import task15.ATM.money.Currency;

import java.util.Date;
import java.util.Random;

public class Card {

    private String cardNumber;
    private String cardCVV;
    private String cardDateOfExpire;
    private Person owner;
    private String pinCode = "1111";
    private String securityWord;
    private String status = "valid";
    private String alarmPinCode = "0000";
    private BankAccount bankAccount;
    private Object object;

    public Card(Person owner, Currency currency1, int balance1) {
        this.owner = owner;
        this.securityWord = owner.getSecurityWord();
        this.bankAccount = new BankAccount(currency1, balance1);
        createNewCard();
    }
    public Card(Person owner, Currency currency1, int balance1,Currency currency2, int balance2 ) {
        this.owner = owner;
        this.securityWord = owner.getSecurityWord();
        this.bankAccount = new BankAccount(currency1, balance1, currency2, balance2);
        createNewCard();
    }
    public Card(Person owner, Currency currency1, int balance1,Currency currency2, int balance2,Currency currency3, int balance3 ) {
        this.owner = owner;
        this.securityWord = owner.getSecurityWord();
        this.bankAccount = new BankAccount(currency1,balance1, currency2,balance2, currency3,balance3);
        createNewCard();
    }
    public Card(Person owner, Currency currency1, int balance1,Currency currency2, int balance2,Currency currency3, int balance3,Currency currency4, int balance4 ) {
        this.owner = owner;
        this.securityWord = owner.getSecurityWord();
        this.bankAccount = new BankAccount(currency1, balance1, currency2, balance2, currency3, balance3, currency4,balance4);
        createNewCard();
    }

    private void createNewCard(){
        Random random = new Random();
        Date date = new Date();
        cardDateOfExpire = String.valueOf(date.getMonth() + " " + (date.getYear() + 4));
        cardNumber = String.valueOf(random.nextInt(10));
        cardCVV = String.valueOf(random.nextInt(10));;
        int number;

        for (int i = 0; i < 15 ; i++) {
            number = random.nextInt(10);
            cardNumber = cardNumber + number;
        }
        for (int i = 0; i <2 ; i++) {
            number = random.nextInt(10);
            cardCVV = cardCVV + number;
        }
    }

    public void setPinCode(String oldPinCode, String newPinCode) {
        if (this.pinCode.equals(oldPinCode)){
            this.pinCode = newPinCode;
        }
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardCVV() {
        return cardCVV;
    }

    public String getCardDateOfExpire() {
        return cardDateOfExpire;
    }

    public Person getOwner() {
        return owner;
    }

    public boolean checkPincode (String typedPinCode){
        if (this.pinCode.equals(typedPinCode)){
            return true;
        }
        return false;
    }

    public String retrievePinCode (String securityWord2){
        if (securityWord.equals(securityWord2)){
            return pinCode;
        }
        return null;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean checkAlarmPinCode(String alarm){
        if (alarmPinCode.equals(alarm)) return true;
        return false;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

}
