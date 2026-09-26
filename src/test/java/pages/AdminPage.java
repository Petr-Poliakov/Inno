package pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import io.qameta.allure.Step;
public class AdminPage {

    private final SelenideElement newProductNameInput = $("#n-name");
    private final SelenideElement newProductPriceInput = $("#n-price");
    private final SelenideElement addProductButton = $("#add-btn");
    private final SelenideElement backToSiteLink = $(byText("Вернуться на сайт"));

    @Step("Открыть админ-панель")
    public AdminPage open() {
        Selenide.open("/admin");
        return this;
    }

    // ---------------- sendKeys() ----------------
    @Step("Ввести название нового товара \"{name}\"")
    public AdminPage setNewProductName(String name) {
        newProductNameInput.sendKeys(name);
        return this;
    }
    @Step("Ввести цену нового товара \"{price}\"")
    public AdminPage setNewProductPrice(String price) {
        newProductPriceInput.sendKeys(price);
        return this;
    }

    @Step("Изменить название товара id={productId} на \"{newName}\"")
    public AdminPage setProductName(long productId, String newName) {
        SelenideElement input = nameField(productId);
        input.clear();
        input.sendKeys(newName);
        return this;
    }

    @Step("Изменить цену товара id={productId} на \"{newPrice}\"")
    public AdminPage setProductPrice(long productId, String newPrice) {
        SelenideElement input = priceField(productId);
        input.clear();
        input.sendKeys(newPrice);
        return this;
    }

    // ---------------- click() ----------------

    @Step("Нажать кнопку \"Создать\"")
    public AdminPage clickAddProduct() {
        addProductButton.click();
        return this;
    }

    @Step("Сохранить изменения товара id={productId}")
    public AdminPage clickSave(long productId) {
        saveButton(productId).click();
        return this;
    }

    @Step("Вернуться на сайт из админки")
    public void clickBackToSite() {
        backToSiteLink.click();
    }

    // ---------------- параметризованные локаторы по id товара в таблице ----------------

    public SelenideElement nameField(long productId) {
        return $("#nm-" + productId);
    }

    public SelenideElement priceField(long productId) {
        return $("#pr-" + productId);
    }

    public SelenideElement saveButton(long productId) {
        return $("button[data-action='update'][data-id='" + productId + "']");
    }

    public SelenideElement deleteButton(long productId) {
        return $("button[data-action='delete'][data-id='" + productId + "']");
    }

    // ---------------- геттеры для PageAssert ----------------

    public SelenideElement newProductNameInput() {
        return newProductNameInput;
    }

    public SelenideElement newProductPriceInput() {
        return newProductPriceInput;
    }

    public SelenideElement addProductButton() {
        return addProductButton;
    }
}