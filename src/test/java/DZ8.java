
import com.codeborne.selenide.Configuration;
import config.Config;
import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@Slf4j
public class DZ8 {


    @BeforeEach
    void setup() {
        Config.printConfig();
        Configuration.baseUrl = Config.standUrl();
        Configuration.timeout = Config.elementTimeoutMs();
    }

    @Test
    void addProductViaAdmin() {
        open("/login");
        $("#username").setValue(Config.adminLogin());
        $("#password").setValue(Config.adminPassword());
        $("button[type='submit']").click();

        open("/admin");
        $("#n-name").shouldBe(visible).setValue(Config.defProductName());
        $("#n-price").setValue(String.valueOf(Config.defProductPrice()));
        $("#add-btn").click();

        open("/");
        $(".product-card[data-name='" + Config.defProductName() + "'] h4")
                .shouldHave(text(Config.defProductName()));
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}

