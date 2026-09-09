package DZ6;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DZ6_1 {
    @BeforeEach
    void setup() {
        Configuration.baseUrl = "http://localhost:8080";
        open("/");
    }

    @Test
    void dragProductToCart() {
        // Стакан, id=10 — карточка draggable="true", drop-зона — кнопка корзины (.btn-cart)
        new Actions(getWebDriver())
                .dragAndDrop($("#card-10"), $("#open-cart-btn"))
                .perform();

        $("#open-cart-btn").click();
        $$("#cart-items .cart-item b").shouldHave(itemWithText("Стакан"));
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
