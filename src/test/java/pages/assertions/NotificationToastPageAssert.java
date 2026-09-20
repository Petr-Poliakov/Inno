package pages.assertions;
import pages.NotificationToastPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
public class NotificationToastPageAssert {

    private NotificationToastPageAssert() {
        }

        public static NotificationToastPageAssert assertThat() {
            return new NotificationToastPageAssert();
        }

        public NotificationToastPageAssert isVisible() {
            NotificationToastPage.element().shouldBe(visible);
            return this;
        }

        public NotificationToastPageAssert messageIs(String expectedText) {
            NotificationToastPage.element().shouldHave(text(expectedText));
            return this;
        }
    }
