package com.sainath;

import example.complex.Complex.ComplexMessage;
import example.complex.Complex.DummyMessage;

import java.util.Arrays;

public class ComplexMain {
    public static void main(String[] args) {

        System.out.println("Complex example");

        DummyMessage oneDummy = newDummyMessage(55, "one dummy message");

        ComplexMessage.Builder builder = ComplexMessage.newBuilder();

        builder.setOneDummy(oneDummy);

        builder.addMultipleDummy(newDummyMessage(66, "second dummy message"))
                .addMultipleDummy(newDummyMessage(77, "third dummy message"))
                .addAllMultipleDummy(Arrays.asList(
                        newDummyMessage(88, "fourth dummy message"),
                        newDummyMessage(99, "fifth dummy message")
                ));

        ComplexMessage complexMessage = builder.build();
        System.out.println(complexMessage);
    }

    public static DummyMessage newDummyMessage(Integer id, String name) {
        DummyMessage.Builder builder = DummyMessage.newBuilder();

        return builder.setId(id)
                .setName(name)
                .build();
    }
}
