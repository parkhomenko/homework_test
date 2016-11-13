package com.kharchenko;

import java.util.EnumMap;
import java.util.Map;

public class Money {
    private BankNote bankNote;
    private Integer quantity;
    private EnumMap<BankNote, Integer> allMoney = new EnumMap<BankNote, Integer>(BankNote.class);
    private int totalValue = 0;
    private BankNote maxBankNote;
    private BankNote minBankNote;

    public Money() {
        this(BankNote.ONE, 0);
    }

    public Money(BankNote bankNote, Integer quantity) {
        this.bankNote = bankNote;
        this.quantity = quantity;
        allMoney.put(bankNote, quantity);
        totalValue = bankNote.getValue() * quantity;
        maxBankNote = bankNote;
        minBankNote = bankNote;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public void addMoney(BankNote bankNote, Integer quantity) {
        if (allMoney.containsKey(bankNote)) {
            Integer temp = allMoney.get(bankNote);
            allMoney.put(bankNote, temp + quantity);
        } else {
            allMoney.put(bankNote, quantity);
        }
        if (bankNote.getValue() > maxBankNote.getValue()) {
            maxBankNote = bankNote;
        }
        if (bankNote.getValue() < minBankNote.getValue()) {
            minBankNote = bankNote;
        }
        totalValue += bankNote.getValue() * quantity;
    }

    public Boolean getMoney(int value) {
        if (value > totalValue) {
            System.out.println("There are no enough money on your account");
            return false;
        } else {
            int tempTotalValue = totalValue - value;
            while (totalValue > tempTotalValue) {
                if (value >= maxBankNote.getValue()) {
                    int divider = value / maxBankNote.getValue();
                    totalValue -= maxBankNote.getValue() * divider;
                    allMoney.put(maxBankNote, allMoney.get(maxBankNote) - divider);
                    value -= maxBankNote.getValue() * divider;
                }
                findAlternativeMaxBankNote();
            }
            findMaximumBankNote();
            return true;
        }
    }

    private void getMoney(BankNote bankNote, Integer value) {
        if (allMoney.get(bankNote) >= value) {
            allMoney.put(bankNote, allMoney.get(bankNote) - value);
            totalValue -= value;
        }
    }

    private void findMaximumBankNote() {
        BankNote maximum = minBankNote;
        for (EnumMap.Entry<BankNote, Integer> entry : allMoney.entrySet()) {
            if (entry.getKey().getValue() > maximum.getValue() && entry.getValue() > 0) {
                maximum = entry.getKey();
            }
        }
        maxBankNote = maximum;
    }

    private void findAlternativeMaxBankNote() {
        BankNote maximum = minBankNote;
        for (EnumMap.Entry<BankNote, Integer> entry : allMoney.entrySet()) {
            if (entry.getKey().getValue() < maxBankNote.getValue()) {
                maximum = entry.getKey();
            }
        }
        maxBankNote = maximum;
    }

    public String map() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<BankNote, Integer> entry : allMoney.entrySet()) {
            builder.append(entry.getKey() + " - ");
            builder.append(entry.getValue() + ", ");
        }
        return builder.toString();
    }
}
