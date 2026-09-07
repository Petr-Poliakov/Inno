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
public class DZ5_2_1 {
    @BeforeEach
    void setup() {
        Configuration.baseUrl = "http://localhost:8080";
    }

    @Test
    void addProductViaAdmin_thenVisibleOnStorefront() {
        String productName = "НовыйТовар_" + System.currentTimeMillis();

        // логин в админку
        open("/login");
        $("#username").setValue("admin");
        $("#password").setValue("secret123");
        $("button[type='submit']").click();

        // добавляем товар (если #n-name не появится — значит логин не прошёл)
        open("/admin");
        $("#n-name").shouldBe(visible).setValue(productName);
        $("#n-price").setValue("99");
        $("#add-btn").click();

        // проверяем товар на витрине
        open("/");
        $$("#products-list .product-card h4").shouldHave(itemWithText(productName));
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

}
