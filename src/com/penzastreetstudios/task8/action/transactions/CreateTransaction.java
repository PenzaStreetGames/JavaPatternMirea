package com.penzastreetstudios.task8.action.transactions;

import com.penzastreetstudios.task8.action.Database;
import com.penzastreetstudios.task8.action.ITransaction;

public class CreateTransaction implements ITransaction {
    public Database database;
    public String nameForCreate;

    public CreateTransaction(Database database, String nameForCreate) {
        this.database = database;
        this.nameForCreate = nameForCreate;
    }

    @Override
    public void execute() {
        database.createTransaction(nameForCreate);
        database.addIntoHistory(this);
    }

    @Override
    public String toString() {
        return "CREATE TABLE " + nameForCreate;
    }
}
