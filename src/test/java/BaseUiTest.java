import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.Config;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import pages.MainPage;
public class BaseUiTest {

    protected MainPage mainPage = new MainPage();

    @BeforeEach
    void baseSetup() {
        Configuration.baseUrl = Config.standUrl();
        Configuration.timeout = Config.elementTimeoutMs();

        SelenideLogger.addListener(
                "AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true)
        );
    }
}
