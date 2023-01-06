package org.example.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import org.example.message.Message;
import org.example.message.MessageLoad;
import org.example.message.MessageTransfer;

import java.lang.reflect.Type;
import java.util.Objects;

class MessageDeserializerFromJson implements JsonDeserializer<Message> {

    @Override
    public Message deserialize(JsonElement jElement, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jObject = jElement.getAsJsonObject();
        String type = jObject.get("type").getAsString();
        int amount = jObject.get("amount").getAsInt();

        if (Objects.equals(type, "LOAD")) {
            String address = jObject.get("address").getAsString();
            return new MessageLoad(type, amount, address);
        } else {
            String fromAddress = jObject.get("fromAddress").getAsString();
            String toAddress = jObject.get("toAddress").getAsString();
            return new MessageTransfer(type, amount, fromAddress, toAddress);
        }
    }
}
