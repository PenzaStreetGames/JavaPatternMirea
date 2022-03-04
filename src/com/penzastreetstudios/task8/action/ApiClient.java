package com.penzastreetstudios.task8.action;

import com.penzastreetstudios.task8.action.transactions.CreateTransaction;
import com.penzastreetstudios.task8.action.transactions.InsertTransaction;

public class ApiClient {
    public Request request = new Request();

    public void createCreateQuery(Database database, String nameForCreate) {
        request.setTransaction(new CreateTransaction(database, nameForCreate));
        request.executeTransaction();
    }

    public void createInsertQuery(Database database, String tableName, String rowForInsert) {
        request.setTransaction(new InsertTransaction(database, tableName, rowForInsert));
        request.executeTransaction();
    }
}
