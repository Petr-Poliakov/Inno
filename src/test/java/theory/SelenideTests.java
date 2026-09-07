package theory;
import com.codeborne.selenide.*;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SelenideTests {
    @BeforeEach
    void setup(){
        Selenide.open("http://localhost:8080");
    }

    @Test
    void selenideTest(){
        SelenideElement cartButton = $x("//*[@id='open-cart-btn']");
        cartButton.should(visible, Duration.ofSeconds(10));
        cartButton.click();
        cartButton.should(not(visible), Duration.ofSeconds(1));
        ElementsCollection cartTitleList = $$x("//*[contains(@id, card)/h4]");
        cartTitleList.forEach(cartTitle ->{
            System.out.println(cartTitle.text());
        });
    }
}
