package com.penzastreetstudios.task8.action;

import com.penzastreetstudios.task8.action.transactions.DeleteTransaction;

public class WebClient {
    public Request request = new Request();

    public void createDeleteQuery(Database database, String nameForDelete) {
        request.setTransaction(new DeleteTransaction(database, nameForDelete));
        request.executeTransaction();
    }
}
