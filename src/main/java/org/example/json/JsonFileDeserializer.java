package org.example.json;

import com.google.gson.GsonBuilder;
import org.example.Blockchain;
import org.example.message.Message;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public final class JsonFileDeserializer {

    public static Blockchain deserialize(String JSON_FILE_PATH) throws FileNotFoundException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Message.class, new MessageDeserializerFromJson());
        return gsonBuilder.create().fromJson(getReader(JSON_FILE_PATH), Blockchain.class);
    }

    private static BufferedReader getReader(String JSON_FILE_PATH) throws FileNotFoundException {
//        FileSystem fs = FileSystems.getDefault();
//        Path source = fs.getPath(JSON_FILE_PATH);

        FileReader fileReader = new FileReader(new File(JSON_FILE_PATH));
        return new BufferedReader(fileReader);
    }

}
