package DZ5;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
public class DZ5_2_2 {
    @BeforeEach
    void setup() {
        Configuration.baseUrl = "http://localhost:8080";
    }

    @Test
    void addToCart_thenVisibleInCart() {
        String productName = "Учебник JAVA_" + System.currentTimeMillis();

        // логинимся и создаём товар, чтобы тест не зависел от того, что уже есть на сервере
        open("/login");
        $("#username").setValue("admin");
        $("#password").setValue("secret123");
        $("button[type='submit']").click();

        open("/admin");
        $("#n-name").shouldBe(visible).setValue(productName);
        $("#n-price").setValue("50");
        $("#add-btn").click();

        // кладём товар в корзину на витрине
        open("/");
        $(".product-card[data-name='" + productName + "'] button[data-action='add-to-cart']").click();

        // открываем корзину и проверяем содержимое
        $("#open-cart-btn").click();
        $$("#cart-items .cart-item b").shouldHave(itemWithText(productName));
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
