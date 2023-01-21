package com.sainath;

import com.example.simple.MySimple.SimpleMessage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SimpleMain {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        SimpleMessage.Builder builder = SimpleMessage.newBuilder();

        builder.setId(42)
                .setIsSimple(true)
                .setName("My simple message name");

        builder.addSampleList(1)
                .addSampleList(2)
                .addSampleList(3)
                .addAllSampleList(Arrays.asList(4, 5, 6));

        SimpleMessage simpleMessage = builder.build();

        System.out.println(simpleMessage.toString());

        // write the protocol buffers binary to a file
        try (FileOutputStream fos = new FileOutputStream("simple_message.bin")) {
            simpleMessage.writeTo(fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // send as byte array
        // byte[] bytes = simpleMessage.toByteArray();

        try (FileInputStream fis = new FileInputStream("simple_message.bin")) {
            SimpleMessage message = SimpleMessage.parseFrom(fis);
            System.out.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
