package com.mybank.atm;

import com.mybank.atm.controller.ATM;
import com.mybank.atm.controller.MyBank;

public class Main {
    public static void main(String[] args) {
        ATM myBank = new MyBank();
        myBank.startWork();
    }
}
