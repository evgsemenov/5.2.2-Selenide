package ru.netology;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

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
        $("[data-test-id='city']").setValue("Санкт-Петербург");
        $("[data-test-id='name']").setValue("Михаил Салтыков-Щедрин");
        $("[data-test-id='phone']").setValue("+70123456789");
        $("[data-test-id='agreement']").click();
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DAY_OF_MONTH, 3);
        Date newDate = instance.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String dateText = dateFormat.format(instance);
        $("[data-test-id='date']").setValue(dateText);
        $$("button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldPlaceOrderPositiveV2Test() {
        $("[placeholder='Город']").setValue("Санкт-Петербург");
        $("[name='name']").setValue("Михаил Салтыков-Щедрин");
        $("[name='phone']").setValue("+70123456789");
        $("[data-test-id='agreement']").click();
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DAY_OF_MONTH, 3);
        Date newDate = instance.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String dateText = dateFormat.format(instance);      // Дата не форматируется в String
        $("[placeholder='Дата встречи']").setValue(dateText);
        $$("button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldPlaceOrderPositiveV3Test() {
        $("[placeholder='Город']").setValue("Санкт-Петербург");
        $("[name='name']").setValue("Михаил Салтыков-Щедрин");
        $("[name='phone']").setValue("+70123456789");
        $("[data-test-id='agreement']").click();
        LocalDate localDate = LocalDate.now();
        LocalDate newDate = localDate.plusDays(3);
        String dateText = new SimpleDateFormat("dd.MM.yyyy").format(newDate);   // Дата не форматируется в String
        $("[placeholder='Дата встречи']").setValue(dateText);
        $$("button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(15));
    }
}
