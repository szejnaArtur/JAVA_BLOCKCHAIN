package org.example;

import org.example.json.JsonFileDeserializer;

import java.io.FileNotFoundException;

public class Main {

    final static String JSON_FILE_PATH = "src/main/resources/files/blockchain.json";

    public static void main(String[] args) throws FileNotFoundException {
        Blockchain blockchain = JsonFileDeserializer.deserialize(JSON_FILE_PATH);
        Accounts accounts = new Accounts(blockchain);
        accounts.showAccountsInConsole();
    }



}