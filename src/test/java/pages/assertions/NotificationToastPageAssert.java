package pages.assertions;
import pages.NotificationToastPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import io.qameta.allure.Step;
public class NotificationToastPageAssert {

    private NotificationToastPageAssert() {
        }

        public static NotificationToastPageAssert assertThat() {
            return new NotificationToastPageAssert();
        }

    @Step("Проверить, что toast-уведомление видно")
        public NotificationToastPageAssert isVisible() {
            NotificationToastPage.element().shouldBe(visible);
            return this;
        }

    @Step("Проверить, что текст toast-уведомления равен \"{expectedText}\"")
        public NotificationToastPageAssert messageIs(String expectedText) {
            NotificationToastPage.element().shouldHave(text(expectedText));
            return this;
        }
    }
