package org.example.message;

public class Message {

    private final String type;
    private final Integer amount;

    public Message(final String type, final Integer amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public Integer getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Message{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}
