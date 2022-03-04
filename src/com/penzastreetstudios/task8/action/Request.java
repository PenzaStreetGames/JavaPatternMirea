package com.penzastreetstudios.task8.action;

public class Request {
    private ITransaction transaction;

    public Request() {
    }

    public void setTransaction(ITransaction transaction) {
        this.transaction = transaction;
    }

    public void executeTransaction() {
        transaction.execute();
    }
}
