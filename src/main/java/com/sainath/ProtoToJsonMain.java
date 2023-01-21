package com.sainath;

import com.example.simple.MySimple.SimpleMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

import java.util.Arrays;

public class ProtoToJsonMain {
    public static void main(String[] args) throws InvalidProtocolBufferException {

        SimpleMessage.Builder builder = SimpleMessage.newBuilder();

        builder.setId(42)
                .setIsSimple(true)
                .setName("My simple message name");

        builder.addSampleList(1)
                .addSampleList(2)
                .addSampleList(3)
                .addAllSampleList(Arrays.asList(4, 5, 6));

        String jsonString = JsonFormat.printer().print(builder);
        System.out.println(jsonString);

        SimpleMessage.Builder builder2 = SimpleMessage.newBuilder();
        JsonFormat.parser()
                .ignoringUnknownFields()
                .merge(jsonString, builder2);

        System.out.println(builder2.build());
    }
}
