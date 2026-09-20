import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;
import config.Config;
import pages.CartModal;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static pages.assertions.CartModalAssert.assertThat;
public class DZ9_2_2_CartTotalSumTest {

    @BeforeEach
    void setup() {
        Configuration.baseUrl = Config.standUrl();
        Configuration.timeout = Config.elementTimeoutMs();
    }

    @Test
    void cartTotalPriceTest() {
        int expectedTotal = 25 + 10 * 2 + 50;

        MainPage mainPage = new MainPage().open();
        mainPage.addToCart("Стакан")
                .setQuantity("Товар", "2")
                .addToCart("Товар")
                .addToCart("Учебник Python")
                .openCart();

        CartModal cartModal = new CartModal();

        assertThat(cartModal)
                .totalPriceIs(String.valueOf(expectedTotal));
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}