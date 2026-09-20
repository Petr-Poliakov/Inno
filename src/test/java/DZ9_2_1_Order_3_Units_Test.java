import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;
import config.Config;
import pages.CartModal;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static pages.assertions.NotificationToastPageAssert.assertThat;
public class DZ9_2_1_Order_3_Units_Test { @BeforeEach
void setup() {
    Configuration.baseUrl = Config.standUrl();
    Configuration.timeout = Config.elementTimeoutMs();
}

    @Test
    void order3Units() {
        MainPage mainPage = new MainPage().open();
        mainPage.setQuantity("Стакан", "3")
                .addToCart("Стакан")
                .openCart();

        CartModal cartModal = new CartModal();
        cartModal.checkout();

        assertThat().messageIs("Заказ принят в обработку!");
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
