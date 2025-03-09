package org.example;

import java.time.LocalTime;

public class Main {

    public static String INVALID = "Invalid Input";
    public static String NO_DISCOUNT = "No Discount";
    public static String DISCOUNT_5 = "5% Discount";
    public static String DISCOUNT_10 = "10% Discount";

    public static int YOUNGEST_AGE = 0;
    public static int OLDEST_AGE = 150;
    public static int OLDEST_CHILDREN_AGE = 10;

    public static LocalTime OPEN_TIME = LocalTime.of(7, 0);
    public static LocalTime CLOSE_TIME = LocalTime.of(23, 0);
    public static LocalTime START_NOONTIME = LocalTime.of(11, 0);
    public static LocalTime END_NOONTIME = LocalTime.of(13, 0);


    public static String handle_ticket(int age, LocalTime time) {
        if (YOUNGEST_AGE > age || age > OLDEST_AGE ||
                time.isAfter(CLOSE_TIME) || time.isBefore(OPEN_TIME)) {
            return INVALID;
        } else if (OLDEST_CHILDREN_AGE <= age &&
                (time.isBefore(START_NOONTIME) && time.isAfter(END_NOONTIME))) {
            /* Error: time.isBefore(START_NOONTIME) && time.isAfter(END_NOONTIME)
             * Correct: time.isBefore(START_NOONTIME) || time.isAfter(END_NOONTIME) */
            return NO_DISCOUNT;
        } else if (age < OLDEST_CHILDREN_AGE &&
                (time.isBefore(START_NOONTIME) || time.isAfter(END_NOONTIME))) {
            // Children & Not noontime
            return DISCOUNT_5;
        } else {
            // Noontime
            return DISCOUNT_10;
        }
    }

    public static void main(String[] args) {
        LocalTime localTime = LocalTime.parse("23:30");
        System.out.println(handle_ticket(65, localTime));
    }
}