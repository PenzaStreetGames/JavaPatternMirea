package com.penzastreetstudios.task8.action.transactions;

import com.penzastreetstudios.task8.action.Database;
import com.penzastreetstudios.task8.action.ITransaction;

public class InsertTransaction implements ITransaction {

    public Database database;
    public String tableName;
    public String rowFowInsert;

    public InsertTransaction(Database database, String tableName, String rowFowInsert) {
        this.database = database;
        this.tableName = tableName;
        this.rowFowInsert = rowFowInsert;
    }

    @Override
    public void execute() {
        database.insertTransaction(tableName, rowFowInsert);
        database.addIntoHistory(this);
    }

    @Override
    public String toString() {
        return "INSERT INTO " + tableName + " VALUES " + rowFowInsert;
    }
}
