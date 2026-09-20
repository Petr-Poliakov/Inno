package pages.assertions;
import pages.CartModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class CartModalAssert {

    private final CartModal modal;

    private CartModalAssert(CartModal modal) {
        this.modal = modal;
    }

    public static CartModalAssert assertThat(CartModal modal) {
        return new CartModalAssert(modal);
    }

    public CartModalAssert totalPriceIs(String expected) {
        modal.totalPrice().shouldHave(text(expected));
        return this;
    }

    public CartModalAssert itemIsInCart(String productName) {
        modal.itemByName(productName).shouldBe(visible);
        return this;
    }

    public CartModalAssert itemPriceIs(String productName, String expectedPrice) {
        modal.itemPrice(productName).shouldHave(text(expectedPrice));
        return this;
    }

    public CartModalAssert cartItemsCountIs(int expectedCount) {
        modal.cartItems().shouldHave(com.codeborne.selenide.CollectionCondition.size(expectedCount));
        return this;
    }
}
