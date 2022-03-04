package com.penzastreetstudios.task8.action.transactions;

import com.penzastreetstudios.task8.action.Database;
import com.penzastreetstudios.task8.action.ITransaction;

public class DeleteTransaction implements ITransaction {

    public Database database;
    public String nameForDelete;

    public DeleteTransaction(Database database, String nameForDelete) {
        this.database = database;
        this.nameForDelete = nameForDelete;
    }

    @Override
    public void execute() {
        database.deleteTransaction(nameForDelete);
        database.addIntoHistory(this);
    }

    @Override
    public String toString() {
        return "DELETE TABLE " + nameForDelete;
    }
}
