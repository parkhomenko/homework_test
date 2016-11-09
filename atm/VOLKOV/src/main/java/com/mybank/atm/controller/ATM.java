package com.mybank.atm.controller;

public abstract class ATM {

    final public void startWork() {
        startUpATM();
    }


    public abstract void startUpATM();

    public abstract void cardVarification();

    public abstract void greeting();

    public abstract void makeSelect();
}
