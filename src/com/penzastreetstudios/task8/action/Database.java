package com.penzastreetstudios.task8.action;

import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    public HashMap<String, ArrayList<String>> tables = new HashMap<>();
    public ArrayList<ITransaction> history = new ArrayList<>();

    public void createTransaction(String nameForCreate) {
        if (!tables.containsKey(nameForCreate)) {
            tables.put(nameForCreate, new ArrayList<>());
        }
    }

    public void insertTransaction(String tableName, String rowForInsert) {
        if (tables.containsKey(tableName)) {
            tables.get(tableName).add(rowForInsert);
        }
    }

    public void deleteTransaction(String nameForDelete) {
        tables.remove(nameForDelete);
    }

    public void addIntoHistory(ITransaction transaction) {
        history.add(transaction);
    }

    public String getHistory() {
        StringBuilder result = new StringBuilder("History: \n");
        for (ITransaction transaction : history) {
            result.append("\t").append(transaction.toString()).append("\n");
        }
        return result.toString();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (String table : tables.keySet()) {
            result.append(table).append(":").append("\n");
            for (String row : tables.get(table)) {
                result.append("\t").append(row).append("\n");
            }
        }
        return result.toString();
    }
}
