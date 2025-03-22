package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @ParameterizedTest
    @CsvSource({
            "-10, 15:00, Invalid Input", "65, 23:30, Invalid Input", "3, 15:00, 5% Discount",
            "3, 12:00, 10% Discount", "65, 15:00, No Discount", "65, 12:00, 10% Discount"
    })
    void dTestHandleTicket(int age, String time, String expected) {
        LocalTime localTime = LocalTime.parse(time);
        assertEquals(expected, Main.handle_ticket(age, localTime));
    }

    @ParameterizedTest
    @CsvSource({
            "65, 15:00, 'No Discount'", "0, 15:00, '5% Discount'", "1, 15:00, '5% Discount'",
            "9, 15:00, '5% Discount'", "10, 15:00, 'No Discount'", "11, 15:00, 'No Discount'",
            "129, 15:00, 'No Discount'", "130, 15:00, 'No Discount'", "65, 07:00, 'No Discount'",
            "65, 07:01, 'No Discount'", "65, 10:59, 'No Discount'", "65, 11:00, '10% Discount'",
            "65, 11:01, '10% Discount'", "65, 12:59, '10% Discount'", "65, 13:00, '10% Discount'",
            "65, 13:01, 'No Discount'", "65, 22:59, 'No Discount'", "65, 23:00, 'No Discount'"
    })
    void bTestHandleTicket(int age, String time, String expectedDiscount) {
        LocalTime localTime = LocalTime.parse(time);
        assertEquals(expectedDiscount, Main.handle_ticket(age, localTime));
    }

    @ParameterizedTest
    @CsvSource({
            "-1, 15:00, Invalid Input",
            "5, 15:00, 5% Discount", "20, 12:00, 10% Discount"
    })
    void C2_TestHandleTicket(int age, String time, String expected) {
        LocalTime localTime = LocalTime.parse(time);
        assertEquals(expected, Main.handle_ticket(age, localTime));
    }

    @ParameterizedTest
    @CsvSource({
            "-1, 12:00, Invalid Input",
            "151, 12:00, Invalid Input",
            "5, 08:00, 5% Discount",
            "20, 12:00, 10% Discount",
            "20, 23:30, Invalid Input",
            "20, 06:00, Invalid Input",
            "20, 10:00, No Discount",
            "5, 10:00, 5% Discount",
            "5, 14:00, 5% Discount",
            "5, 12:00, 10% Discount"
    })
    void dfg_TestHandleTicket(int age, String time, String expected) {
        LocalTime localTime = LocalTime.parse(time);
        assertEquals(expected, Main.handle_ticket(age, localTime));
    }
}
