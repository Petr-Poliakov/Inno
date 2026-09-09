package DZ6;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
public class DZ6_2 {
    @BeforeEach
    void setup() {
        Configuration.baseUrl = "http://localhost:8080";
        open("/");
    }

    @Test
    void removeItemFromCart() {
        // добавляем товар обычным способом
        $("button[data-action='add-to-cart'][data-id='10']").click();

        $("#open-cart-btn").click();
        $$("#cart-items .cart-item b").shouldHave(itemWithText("Стакан"));

        // удаляем его из корзины (кнопка "x" внутри карточки cart-item-10)
        $("#cart-item-10 button[data-action='remove']").click();

        // корзина должна снова показывать "Пусто"
        $("#cart-items").shouldHave(text("Пусто"));
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
