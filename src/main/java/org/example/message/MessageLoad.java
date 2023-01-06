package org.example.message;

public class MessageLoad extends Message{
    private final String address;

    public MessageLoad(final String type, final Integer amount, final String address ) {
        super(type, amount);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "MessageLoad{" +
                "type='" + this.getType() + '\'' +
                "amount='" + this.getAmount() + '\'' +
                "address='" + address + '\'' +
                '}';
    }
}
