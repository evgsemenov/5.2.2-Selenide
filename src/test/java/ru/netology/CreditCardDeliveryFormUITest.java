package ru.netology;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
//    void shouldRequireValidCityIfCityNotIncludeTest() {
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

//    @Test
//    void shouldRequireValidDateIfTwoDaysTest() {
//        $("[data-test-id='city']").$("[placeholder='Город']").setValue("Санкт-Петербург");
//        LocalDate localDate = LocalDate.now();
//        LocalDate newDate = localDate.plusDays(2);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        String dateText = newDate.format(formatter);
//        $("[data-test-id='date']").$("[placeholder='Дата встречи']").setValue(dateText);
//        $("[data-test-id= 'name']").$("[name ='name']").setValue("Михаил Салтыков-Щедрин");
//        $("[data-test-id='phone']").$("[name='phone']").setValue("+70123456789");
//        $("[data-test-id='agreement']").click();
//        $$("button").find(exactText("Забронировать")).click();
//        String expected = "Заказ на выбранную дату невозможен";
//        String actual = $("[data-test-id='date']").$("[input__sub]").getText();
//        assertEquals(expected.trim(), actual.trim());
//    }

    @Test
    void shouldPlaceOrderIfFourDaysPositiveTest() {
        $("[data-test-id='city']").$("[placeholder='Город']").setValue("Санкт-Петербург");
        LocalDate localDate = LocalDate.now();
        LocalDate newDate = localDate.plusDays(4);
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
//    void shouldRequireValidNameIfNonCyrillicTest() {
//        $("[data-test-id='city']").$("[placeholder='Город']").setValue("Санкт-Петербург");
//        LocalDate localDate = LocalDate.now();
//        LocalDate newDate = localDate.plusDays(3);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        String dateText = newDate.format(formatter);
//        $("[data-test-id='date']").$("[placeholder='Дата встречи']").setValue(dateText);
//        $("[data-test-id= 'name']").$("[name ='name']").setValue("John Snow");
//        $("[data-test-id='phone']").$("[name='phone']").setValue("+70123456789");
//        $("[data-test-id='agreement']").click();
//        $$("button").find(exactText("Забронировать")).click();
//        String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
//        String actual = $("[data-test-id='name']").$("[input__sub]").getText();
//        assertEquals(expected.trim(), actual.trim());
//    }
//
//    @Test
//    void shouldRequireAgreementCheckboxTest() {
//        $("[data-test-id='city']").$("[placeholder='Город']").setValue("Санкт-Петербург");
//        LocalDate localDate = LocalDate.now();
//        LocalDate newDate = localDate.plusDays(3);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        String dateText = newDate.format(formatter);
//        $("[data-test-id='date']").$("[placeholder='Дата встречи']").setValue(dateText);
//        $("[data-test-id= 'name']").$("[name ='name']").setValue("Михаил Салтыков-Щедрин");
//        $("[data-test-id='phone']").$("[name='phone']").setValue("+70123456789");
//        $$("button").find(exactText("Забронировать")).click();
//        String expected = "Я соглашаюсь с условиями обработки и использования моих персональных данных";
//        String actual = $("[data-test-id='agreement']").$("[checkbox__text]").getText();
//        assertEquals(expected.trim(), actual.trim());
//    }
//
//    @Test
//    void shouldRequireValidTelephoneNumberIfNoPlusTest() {
//        $("[data-test-id='city']").$("[placeholder='Город']").setValue("Санкт-Петербург");
//        LocalDate localDate = LocalDate.now();
//        LocalDate newDate = localDate.plusDays(3);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        String dateText = newDate.format(formatter);
//        $("[data-test-id='date']").$("[placeholder='Дата встречи']").setValue(dateText);
//        $("[data-test-id= 'name']").$("[name ='name']").setValue("Михаил Салтыков-Щедрин");
//        $("[data-test-id='phone']").$("[name='phone']").setValue("70123456789");
//        $("[data-test-id='agreement']").click();
//        $$("button").find(exactText("Забронировать")).click();
//        String expected = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";
//        String actual = $("[data-test-id='phone']").$("[input__sub]").getText();
//        assertEquals(expected.trim(), actual.trim());
//    }
//
//    @Test
//    void shouldRequireValidTelephoneNumberIfTenNumbersTest() {
//        $("[data-test-id='city']").$("[placeholder='Город']").setValue("Санкт-Петербург");
//        LocalDate localDate = LocalDate.now();
//        LocalDate newDate = localDate.plusDays(3);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        String dateText = newDate.format(formatter);
//        $("[data-test-id='date']").$("[placeholder='Дата встречи']").setValue(dateText);
//        $("[data-test-id= 'name']").$("[name ='name']").setValue("Михаил Салтыков-Щедрин");
//        $("[data-test-id='phone']").$("[name='phone']").setValue("+7012345678");
//        $("[data-test-id='agreement']").click();
//        $$("button").find(exactText("Забронировать")).click();
//        String expected = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";
//        String actual = $("[data-test-id='phone']").$("[input__sub]").getText();
//        assertEquals(expected.trim(), actual.trim());
//    }
//
//    @Test
//    void shouldRequireValidTelephoneNumberIfElevenNumbersTest() {
//        $("[data-test-id='city']").$("[placeholder='Город']").setValue("Санкт-Петербург");
//        LocalDate localDate = LocalDate.now();
//        LocalDate newDate = localDate.plusDays(3);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        String dateText = newDate.format(formatter);
//        $("[data-test-id='date']").$("[placeholder='Дата встречи']").setValue(dateText);
//        $("[data-test-id= 'name']").$("[name ='name']").setValue("Михаил Салтыков-Щедрин");
//        $("[data-test-id='phone']").$("[name='phone']").setValue("+701234567890");
//        $("[data-test-id='agreement']").click();
//        $$("button").find(exactText("Забронировать")).click();
//        String expected = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";
//        String actual = $("[data-test-id='phone']").$("[input__sub]").getText();
//        assertEquals(expected.trim(), actual.trim());
//    }
//}


