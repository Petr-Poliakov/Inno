package pages.assertions;
import pages.CartModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import io.qameta.allure.Step;

public class CartModalAssert {

    private final CartModal modal;

    private CartModalAssert(CartModal modal) {
        this.modal = modal;
    }

    public static CartModalAssert assertThat(CartModal modal) {
        return new CartModalAssert(modal);
    }

    @Step("Проверить, что сумма в корзине равна \"{expected}\"")
    public CartModalAssert totalPriceIs(String expected) {
        modal.totalPrice().shouldHave(text(expected));
        return this;
    }

    @Step("Проверить, что товар \"{productName}\" есть в корзине")
    public CartModalAssert itemIsInCart(String productName) {
        modal.itemByName(productName).shouldBe(visible);
        return this;
    }

    @Step("Проверить, что цена товара \"{productName}\" в корзине равна \"{expectedPrice}\"")
    public CartModalAssert itemPriceIs(String productName, String expectedPrice) {
        modal.itemPrice(productName).shouldHave(text(expectedPrice));
        return this;
    }

    @Step("Проверить, что число позиций в корзине равно {expectedCount}")
    public CartModalAssert cartItemsCountIs(int expectedCount) {
        modal.cartItems().shouldHave(com.codeborne.selenide.CollectionCondition.size(expectedCount));
        return this;
    }
}
