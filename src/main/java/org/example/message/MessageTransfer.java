package org.example.message;

public class MessageTransfer extends Message{
    private final String fromAddress;
    private final String toAddress;

    public MessageTransfer(final String type, final Integer amount, final String fromAddress, final String toAddress ) {
        super(type, amount);
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    @Override
    public String toString() {
        return "MessageTransfer{" +
                "type='" + this.getType() + '\'' +
                "amount='" + this.getAmount() + '\'' +
                "fromAddress='" + fromAddress + '\'' +
                ", toAddress='" + toAddress + '\'' +
                '}';
    }
}
