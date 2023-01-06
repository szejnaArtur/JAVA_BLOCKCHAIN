package org.example;

import org.example.message.MessageLoad;
import org.example.message.MessageTransfer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Accounts {

    private final Map<String, Integer> accounts = new HashMap<>();

    public Accounts(Blockchain blockchain) {
        blockchain.getBlockList()
                .forEach(block -> {
                    List<MessageLoad> loads = new ArrayList<>();
                    List<MessageTransfer> transfers = new ArrayList<>();
                    block.getMessages().forEach(message -> {
                        if (message.getType().equals("LOAD")) {
                            loads.add((MessageLoad) message);
                        }
                        if (message.getType().equals("TRANSFER")) {
                            transfers.add((MessageTransfer) message);
                        }
                    });

                    loads.forEach(load -> {
                        accounts.merge(load.getAddress(), load.getAmount(), Integer::sum);
                    });

                    transfers.forEach(transfer -> {
                        Integer from = accounts.get(transfer.getFromAddress());
                        Integer to = accounts.get(transfer.getToAddress());

                        accounts.put(transfer.getFromAddress(), from - transfer.getAmount());
                        accounts.put(transfer.getToAddress(), to + transfer.getAmount());
                    });
                });
    }

    public void showAccountsInConsole() {

        accounts.entrySet().stream().forEach(account -> {
            System.out.println(account.getKey() + ": " + account.getValue());
        });

    }
}
