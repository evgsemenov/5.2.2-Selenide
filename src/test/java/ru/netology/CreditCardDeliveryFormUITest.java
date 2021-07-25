package ru.netology;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditCardDeliveryFormUITest {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @AfterEach
    void tearDown() {
        close();
    }

    @Test
    void shouldPlaceOrderPositiveTest() {
        $("[data-test-id='city']").$("[placeholder='Город']").setValue("Санкт-Петербург");
        LocalDate localDate = LocalDate.now();
        LocalDate newDate = localDate.plusDays(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String dateText = newDate.format(formatter);
        $("[data-test-id='date']").$("[placeholder='Дата встречи']").setValue(dateText);
        $("[data-test-id= 'name']").$("[name ='name']").setValue("Михаил Салтыков-Щедрин");
        $("[data-test-id='phone']").$("[name='phone']").setValue("+70123456789");
        $("[data-test-id='agreement']").click();
        $$("button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(15));
    }

//    @Test
//    void shouldRequiredValidCityIfCityNotIncludeTest() {
//        $("[data-test-id='city']").$("[placeholder='Город']").setValue("Вашингтон");
//        LocalDate localDate = LocalDate.now();
//        LocalDate newDate = localDate.plusDays(3);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        String dateText = newDate.format(formatter);
//        $("[data-test-id='date']").$("[placeholder='Дата встречи']").setValue(dateText);
//        $("[data-test-id= 'name']").$("[name ='name']").setValue("Михаил Салтыков-Щедрин");
//        $("[data-test-id='phone']").$("[name='phone']").setValue("+70123456789");
//        $("[data-test-id='agreement']").click();
//        $$("button").find(exactText("Забронировать")).click();
//        String expected = "Доставка в выбранный город недоступна";
//        String actual = $("[data-test-id='city']").$("[input__sub]").getText();
//        assertEquals(expected.trim(), actual.trim());
//    }
}


