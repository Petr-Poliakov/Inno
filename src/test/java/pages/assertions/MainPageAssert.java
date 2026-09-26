package pages.assertions;

import pages.MainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import io.qameta.allure.Step;

public class MainPageAssert {

    private final MainPage page;

    private MainPageAssert(MainPage page) {
        this.page = page;
    }

    public static MainPageAssert assertThat(MainPage page) {
        return new MainPageAssert(page);
    }

    @Step("Проверить, что кнопка корзины видна")
    public MainPageAssert cartButtonIsVisible() {
        page.cartButton().shouldBe(visible);
        return this;
    }

    @Step("Проверить, что ссылка на админку видна")
    public MainPageAssert adminLinkIsVisible() {
        page.adminLink().shouldBe(visible);
        return this;
    }

    @Step("Проверить, что счётчик корзины равен \"{expected}\"")
    public MainPageAssert cartCountIs(String expected) {
        page.cartCountBadge().shouldHave(text(expected));
        return this;
    }

    @Step("Проверить, что товар \"{productName}\" виден на странице")
    public MainPageAssert productIsVisible(String productName) {
        page.productCardByName(productName).shouldBe(visible);
        return this;
    }

    @Step("Проверить, что название товара \"{productName}\" равно \"{expectedText}\"")
    public MainPageAssert productNameIs(String productName, String expectedText) {
        page.productName(productName).shouldHave(text(expectedText));
        return this;
    }
    @Step("Проверить, что цена товара \"{productName}\" равна \"{expectedPriceText}\"")
    public MainPageAssert productPriceIs(String productName, String expectedPriceText) {
        page.productPrice(productName).shouldHave(text(expectedPriceText));
        return this;
    }

    @Step("Проверить, что поле количества товара \"{productName}\" содержит \"{expectedValue}\"")
    public MainPageAssert quantityInputHasValue(String productName, String expectedValue) {
        page.quantityInput(productName).shouldHave(value(expectedValue));
        return this;
    }

    @Step("Проверить, что число карточек товаров равно {expectedCount}")
    public MainPageAssert productCardsCountIs(int expectedCount) {
        page.productCards().shouldHave(com.codeborne.selenide.CollectionCondition.size(expectedCount));
        return this;
    }
}