package com.kharchenko;

public enum BankNote {
    ONE(1), TWO(2), FIVE(5), TEN(10), TWENTY(20), FIFTY(50), ONE_HUNDRED(100), TWO_HUNDRED(200), FIVE_HUNDRED(500);

    private int value;

    BankNote(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
