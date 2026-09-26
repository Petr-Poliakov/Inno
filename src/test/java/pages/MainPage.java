package pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import io.qameta.allure.Step;
public class MainPage {

//elements
private final SelenideElement cartButton = $("#open-cart-btn");
    private final SelenideElement cartCountBadge = $("#cart-count");
    private final SelenideElement adminLink = $("a.btn-outline[href='/admin']");


    private final ElementsCollection productCards = $$(".product-card");

    @Step("Открыть главную страницу")
    public MainPage open() {
        Selenide.open("/");
        return this;
    }

    //click()

    @Step("Открыть корзину")
    public MainPage openCart() {
        cartButton.click();
        return this;
    }

    @Step("Перейти в админку")
    public MainPage openAdmin() {
        adminLink.click();
        return this;
    }

    @Step("Добавить товар \"{productName}\" в корзину")
    public MainPage addToCart(String productName) {
        addToCartButton(productName).click();
        return this;
    }

    //input
    @Step("Установить количество \"{quantity}\" для товара \"{productName}\"")
    public MainPage setQuantity(String productName, String quantity) {
        SelenideElement input = quantityInput(productName);
        input.clear();
        input.sendKeys(quantity);
        return this;
    }



    public SelenideElement productCardByName(String productName) {
        return $(".product-card[data-name='" + productName + "']");
    }

    public SelenideElement productName(String productName) {
        return productCardByName(productName).$("h4");
    }

    public SelenideElement productPrice(String productName) {
        return productCardByName(productName).$(":scope > div:not(.qty-controls)");
    }

    public SelenideElement addToCartButton(String productName) {
        return productCardByName(productName).$("button[data-action='add-to-cart']");
    }

    public SelenideElement quantityInput(String productName) {
        return productCardByName(productName).$(".qty-input");
    }

    //геттеры для PageAssert

    public SelenideElement cartButton() {
        return cartButton;
    }

    public SelenideElement cartCountBadge() {
        return cartCountBadge;
    }

    public SelenideElement adminLink() {
        return adminLink;
    }

    public ElementsCollection productCards() {
        return productCards;
    }
}
