package pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
public class CartModal {

    private final SelenideElement closeButton = $("#close-modal");
    private final ElementsCollection cartItems = $$("#cart-items .cart-item");
    private final SelenideElement totalPrice = $("#total-price");
    private final SelenideElement checkoutButton = $("#makeOrder");

    // ---------------- click() ----------------

    public CartModal close() {
        closeButton.click();
        return this;
    }

    public void checkout() {
        checkoutButton.click();
    }

    public CartModal removeItem(String productName) {
        removeButton(productName).click();
        return this;
    }

    // ---------------- параметризованные локаторы по товару в корзине ----------------

    public SelenideElement itemByName(String productName) {
        return cartItems.findBy(text(productName));
    }

    public SelenideElement itemPrice(String productName) {
        // третий div внутри .cart-item — блок с ценой (0: название, 1: qty-controls, 2: цена)
        return itemByName(productName).$$("div").get(2);
    }

    public SelenideElement removeButton(String productName) {
        return itemByName(productName).$("button[data-action='remove']");
    }

    // ---------------- геттеры для PageAssert ----------------

    public SelenideElement closeButton() {
        return closeButton;
    }

    public ElementsCollection cartItems() {
        return cartItems;
    }

    public SelenideElement totalPrice() {
        return totalPrice;
    }

    public SelenideElement checkoutButton() {
        return checkoutButton;
    }
}