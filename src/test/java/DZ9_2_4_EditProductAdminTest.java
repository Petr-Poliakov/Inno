import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;
import config.Config;
import pages.AdminPage;
import pages.LoginPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static pages.assertions.MainPageAssert.assertThat;
public class DZ9_2_4_EditProductAdminTest {

    private static final long PRODUCT_ID = 11; // "Товар", 10 ₽ — см. таблицу в /admin

    @BeforeEach
    void setup() {
        Configuration.baseUrl = Config.standUrl();
        Configuration.timeout = Config.elementTimeoutMs();
    }

    @Test
    void editProductTest() {
        String newName = "Товар_55";
        String newPrice = "33";

        LoginPage loginPage = new LoginPage().open();
        loginPage.login(Config.adminLogin(), Config.adminPassword());

        AdminPage adminPage = new AdminPage();
        adminPage.setProductName(PRODUCT_ID, newName)
                .setProductPrice(PRODUCT_ID, newPrice)
                .clickSave(PRODUCT_ID)
                .clickBackToSite();

        MainPage mainPage = new MainPage();

        assertThat(mainPage)
                .productIsVisible(newName)
                .productNameIs(newName, newName)
                .productPriceIs(newName, newPrice + " ₽");
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
