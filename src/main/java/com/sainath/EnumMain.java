package com.sainath;

import example.enumerations.EnumExample.DayOfTheWeek;
import example.enumerations.EnumExample.EnumMessage;

public class EnumMain {
    public static void main(String[] args) {
        System.out.println("Example for enum");

        EnumMessage.Builder builder = EnumMessage.newBuilder();
        builder.setId(345);
        builder.setDayOfTheWeek(DayOfTheWeek.FRIDAY);

        EnumMessage message = builder.build();
        System.out.println(message);
    }
}
