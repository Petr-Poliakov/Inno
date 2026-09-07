import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class DZ5_3_3{

    @BeforeEach
    void setup() {
        Configuration.baseUrl = "http://localhost:8080";
    }

    @Test
    void addProductCheckToast() {
        String productName = "Ежедневник";

        open("/login");
        $("#username").setValue("admin");
        $("#password").setValue("secret123");
        $("button[type='submit']").click();

        open("/admin");
        $("#n-name").shouldBe(visible).setValue(productName);
        $("#n-price").setValue("30");
        $("#add-btn").click();

        $("#toast-container .toast")
                .shouldBe(visible)
                .shouldHave(text("Товар успешно добавлен!"));
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
 