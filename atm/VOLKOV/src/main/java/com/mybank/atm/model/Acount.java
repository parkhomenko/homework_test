package com.mybank.atm.model;

public class Acount {
    private int acountId;
    private int acountNum;
    private int moneyOnAcount;
    private boolean acountStatus;

    public Acount(int acountId, int acountNum, int moneyOnAcount, boolean acountStatus) {
        this.acountId = acountId;
        this.acountNum = acountNum;
        this.moneyOnAcount = moneyOnAcount;
        this.acountStatus = acountStatus;
    }

    public int getAcountId() {
        return acountId;
    }

    public void setAcountId(int acountId) {
        this.acountId = acountId;
    }

    public int getAcountNum() {
        return acountNum;
    }

    public void setAcountNum(int acountNum) {
        this.acountNum = acountNum;
    }

    public int getMoneyOnAcount() {
        return moneyOnAcount;
    }

    public void setMoneyOnAcount(int moneyOnAcount) {
        this.moneyOnAcount = moneyOnAcount;
    }

    public boolean isAcountStatus() {
        return acountStatus;
    }

    public void setAcountStatus(boolean acountStatus) {
        this.acountStatus = acountStatus;
    }
}
