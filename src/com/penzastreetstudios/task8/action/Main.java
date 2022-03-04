package com.penzastreetstudios.task8.action;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        WebClient webClient = new WebClient();
        ApiClient apiClient = new ApiClient();
        apiClient.createCreateQuery(database, "student");
        apiClient.createCreateQuery(database, "subject");
        apiClient.createCreateQuery(database, "teacher");
        apiClient.createInsertQuery(database, "student", "Vasya");
        apiClient.createInsertQuery(database, "student", "Petya");
        apiClient.createInsertQuery(database,"teacher", "PZS");
        webClient.createDeleteQuery(database, "teacher");
        System.out.println(database);
        System.out.println(database.getHistory());
    }
}
