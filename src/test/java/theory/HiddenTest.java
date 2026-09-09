package theory;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.module.Configuration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class HiddenTest {
    @BeforeEach
    void setup(){
        open();
        open("http://localhost:8080");
    }

    @Test
    void hiddenTest(){
        SelenideElement addToCardButton = $x("//*[@data-action = 'add-to-card']");
        addToCardButton.click();
        addToCardButton.click();
        addToCardButton.click();

        SelenideElement notificationContainer = $x("(//*[@datatest = 'notification-container'])");
        SelenideElement secondNotificationContainer = $x("(//*[@datatest = 'notification-container'])");
        SelenideElement thirdNotificationContainer = $x("(//*[@datatest = 'notification-container'])");
        notificationContainer.shouldNot(visible);
        notificationContainer.should(exist);
        notificationContainer.$x("./..").should(visible);

        secondNotificationContainer.shouldNot(visible);
        secondNotificationContainer.should(exist);
        secondNotificationContainer.$x("./..").should(visible);

        thirdNotificationContainer.shouldNot(visible);
        thirdNotificationContainer.should(exist);
        thirdNotificationContainer.$x("./..").should(visible);
    }
}
