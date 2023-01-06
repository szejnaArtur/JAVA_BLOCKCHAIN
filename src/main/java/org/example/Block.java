package org.example;

import org.example.message.Message;

import java.util.List;

class Block {
    private Integer height;
    private String date;
    private String hash;

    private List<? extends Message> messages;

    Block(final Integer height, final String date, final String hash, final List<Message> messages) {
        this.height = height;
        this.date = date;
        this.hash = hash;
        this.messages = messages;
    }

    Integer getHeight() {
        return height;
    }

    String getDate() {
        return date;
    }

    String getHash() {
        return hash;
    }

    List<? extends Message> getMessages() {
        return messages;
    }

    @Override
    public String toString() {
        return "Block{" +
                "height=" + height +
                ", date='" + date + '\'' +
                ", hash='" + hash + '\'' +
                ", messages=" + messages +
                '}';
    }
}


