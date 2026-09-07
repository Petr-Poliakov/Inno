package DZ5;

import com.codeborne.selenide.Configuration;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.confirm;
import static com.codeborne.selenide.Selenide.open;

public class DZ5_2_5 {
    @BeforeEach
    void setup() {
        Configuration.baseUrl = "http://localhost:8080";
    }

    @Test
    void checkout_withOrderOver300_showsJsAlert() {
        String productName = "ДорогойТовар_" + System.currentTimeMillis();


        open("/login");
        $("#username").setValue("admin");
        $("#password").setValue("secret123");
        $("button[type='submit']").click();

        open("/admin");
        $("#n-name").shouldBe(visible).setValue(productName);
        $("#n-price").setValue("350");
        $("#add-btn").click();

        // кладём товар в корзину и оформляем заказ
        open("/");
        $(".product-card[data-name='" + productName + "'] button[data-action='add-to-cart']").click();

        $("#open-cart-btn").click();
        $("#makeOrder").click();

        // Selenide.confirm() ждёт появления JS Alert, читает его текст и нажимает OK.
        // Если алерт не появится вовсе — метод сам бросит исключение с понятной причиной.
        String alertText = confirm();

        Assertions.assertThat(alertText)
                .as("После оформления заказа на сумму выше 300 \u20BD должен появиться JS Alert с непустым текстом")
                .isNotBlank();
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
