package DZ5;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;
public class DZ5_2_4 {
    @BeforeEach
    void setup() {
        Configuration.baseUrl = "http://localhost:8080";
        open("/");
    }

    @Test
    void cartContents_persistAfterPageRefresh() {
        $(".product-card[data-name='Стакан'] button[data-action='add-to-cart']").click();

        refresh();

        $("#open-cart-btn").click();
        $$("#cart-items .cart-item b").shouldHave(itemWithText("Стакан"));
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
