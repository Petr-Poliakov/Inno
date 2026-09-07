package DZ5;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class DZ5_3_1 {

    @BeforeEach
    void setup() {
        Configuration.baseUrl = "http://localhost:8080";
        open("/");
    }

    @Test
    void orderThreeUnits() {
        $("button[data-action='qty-change'][data-step='1'][data-id='10']").click();
        $("button[data-action='qty-change'][data-step='1'][data-id='10']").click();
        $("#q-10").shouldHave(value("3"));

        $("button[data-action='add-to-cart'][data-id='10']").click();

        $("#open-cart-btn").click();
        $("#makeOrder").click();


        $$("#toast-container .toast")
                .findBy(text("Заказ принят в обработку!"))
                .shouldBe(visible);
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}