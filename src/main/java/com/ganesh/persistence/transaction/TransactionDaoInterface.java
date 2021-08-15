package com.ganesh.persistence.transaction;

import com.ganesh.pojos.Transaction;

import java.util.Collection;

public interface TransactionDaoInterface {

    Collection<Transaction> getAllTransactions(int cardId);
    boolean setDestinationStation(int stationId, int transactionId);
    Transaction getLastTransaction(int cardId);
    int getTransactionDuration(int transactionId);
    boolean createTransaction(Transaction transaction);
    boolean completeTransaction(Transaction transaction);
}
