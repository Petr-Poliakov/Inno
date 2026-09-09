package theory;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
public class Dnd_Test {
    SelenideElement firstCard = $x("//*[@id='card-10']");
    SelenideElement cartButton = $x("//*[@id='open-cart-btn']");


    @BeforeEach
    void setup(){
        open("http://localhost:8080");
    }

    @Test
    void simpleDnd(){
        sleep(1000);
        firstCard.dragAndDrop(DragAndDropOptions.to(cartButton));
        sleep(2000);
    }

    @Test
    void anotherDnd(){
        actions().moveToElement(firstCard)
                .clickAndHold()
                .pause(1000)
                .moveToElement(cartButton)
                .release()
                .pause(Duration.ofSeconds(2))
                .release();
    }

    @Test
    void slowDnd(){
        int firstCardX = firstCard.getCoordinates().inViewPort().getX() + firstCard.getSize().getWidth()/2; // после плюса мы вычисляем координаты центра переносимого объекта по Х. делается для того, чтобы центры объектов совпадали, без этого всегда будет верхний левый угол объекта может не совместится объекты
        int firstCardY = firstCard.getCoordinates().inViewPort().getY() + firstCard.getSize().getHeight()/2; // после плюса мы вычисляем координаты центра переносимого объекта по Y
        int cartBtnX = cartButton.getCoordinates().inViewPort().getX() + cartButton.getSize().getWidth()/2; // после плюса мы вычисляем координаты центра объекта к которому переносим по Х
        int cartBtnY = cartButton.getCoordinates().inViewPort().getY() + cartButton.getSize().getHeight()/2; // после плюса мы вычисляем координаты центра объекта к которому переносим по Y

        //для движения необходима вычислить координаты, для этого надо из понять разницу в кординатах,
        // для этого мы из Места куда нам надо вычитаем кординату начала движеня(может даже быть отрицательные значения , но это нормально )
        int diffX = cartBtnX - firstCardX;
        int diffY = cartBtnY - firstCardY;

        sleep(1000);
        Actions dndActions = actions().moveToElement(firstCard).clickAndHold();
        for (int i = 0; i < 50; i++){
            dndActions = dndActions.moveByOffset(diffX/50, diffY/50);
        }
        dndActions.release().perform();
        sleep(2000);
    }
}
