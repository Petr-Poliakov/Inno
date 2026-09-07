package DZ5;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
public class DZ5_2_3 {
    @BeforeEach
    void setup() {
        Configuration.baseUrl = "http://localhost:8080";
        open("/login");
    }

    @Test
    void loginWithInvalidCredentials_showsErrorMessage() {
        $("#username").setValue("wrong_user_" + System.currentTimeMillis());
        $("#password").setValue("wrong_password");
        $("button[type='submit']").click();

        $(".alert-danger")
                .shouldBe(visible)
                .shouldHave(text("Неверные учетные данные пользователя"));
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
