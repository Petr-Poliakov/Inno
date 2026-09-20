package pages;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NotificationToastPage{

    public static SelenideElement element() {
        return $$("#toast-container .toast").last();
    }
}
