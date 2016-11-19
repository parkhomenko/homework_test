package com.kharchenko;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TransactionHistory {
    private Map<Integer, StringBuilder> transactionBase = new HashMap<Integer, StringBuilder>();

    TransactionHistory() {
    }

    public String getTransactions(int cardNumber) {
        StringBuilder transaction = transactionBase.get(cardNumber);
        return transaction.toString();
    }

    public void addTransaction(int cardNumber, String name) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        StringBuilder data;
        if (transactionBase.containsKey(cardNumber)) {
            data = transactionBase.get(cardNumber);
        } else {
            data = new StringBuilder();
        }
        data.append(format.format(date) + " ");
        data.append(name + "\n");
        transactionBase.put(cardNumber, data);
    }
}
