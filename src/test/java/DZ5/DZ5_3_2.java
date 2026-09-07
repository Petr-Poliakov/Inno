package DZ5;

import com.codeborne.selenide.Configuration;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class DZ5_3_2 {

    @BeforeEach
    void setup() {
        Configuration.baseUrl = "http://localhost:8080";
    }

    @Test
    void checkTotalCalculatedCorrectly() {
        String productName = "Ластик";

        // создаём третий товар с известной ценой, чтобы не зависеть от посторонних данных на сервере
        open("/login");
        $("#username").setValue("admin");
        $("#password").setValue("secret123");
        $("button[type='submit']").click();

        open("/admin");
        $("#n-name").shouldBe(visible).setValue(productName);
        $("#n-price").setValue("20");
        $("#add-btn").click();


        open("/");
        $("button[data-action='add-to-cart'][data-id='10']").click();
        $("button[data-action='add-to-cart'][data-id='11']").click();
        $(".product-card[data-name='" + productName + "'] button[data-action='add-to-cart']").click();

        $("#open-cart-btn").click();

        // Стакан (id=10, 25 ₽) + Товар (id=11, 10 ₽) + новый товар (20 ₽) -> ожидаемая сумма 55 ₽
        $("#total-price").shouldHave(text("55"));
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}