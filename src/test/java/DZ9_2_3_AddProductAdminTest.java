import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;
import config.Config;
import pages.AdminPage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static pages.assertions.NotificationToastPageAssert.assertThat;

public class DZ9_2_3_AddProductAdminTest {

    @BeforeEach
    void setup() {
        Configuration.baseUrl = Config.standUrl();
        Configuration.timeout = Config.elementTimeoutMs();
    }

    @Test
    void NotificationAddUnit() {
        LoginPage loginPage = new LoginPage().open();
        loginPage.login(Config.adminLogin(), Config.adminPassword());

        String productName = "Товар_" + System.currentTimeMillis();

        AdminPage adminPage = new AdminPage();
        adminPage.setNewProductName(productName)
                .setNewProductPrice("15")
                .clickAddProduct();

        assertThat().messageIs("Товар успешно добавлен!");
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
