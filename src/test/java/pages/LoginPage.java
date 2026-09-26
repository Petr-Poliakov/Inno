package pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import io.qameta.allure.Step;
public class LoginPage {

    private final SelenideElement loginInput = $("#username");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement submitButton = $("button[type='submit']");

    @Step("Открыть страницу входа в админку")
    public LoginPage open() {
        Selenide.open("/login");
        return this;
    }

    //input

    @Step("Ввести логин \"{login}\"")
    public LoginPage setLogin(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    @Step("Ввести пароль")
    public LoginPage setPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    //click()
    @Step("Нажать кнопку \"Войти\"")
    public void clickSubmitButton() {
        submitButton.click();
    }

    //auth

    @Step("Войти в админку под логином \"{login}\"")
    public void login(String login, String password) {
        setLogin(login);
        setPassword(password);
        clickSubmitButton();
    }

    //геттеры для PageAssert

    public SelenideElement loginInput() {
        return loginInput;
    }

    public SelenideElement passwordInput() {
        return passwordInput;
    }

    public SelenideElement submitButton() {
        return submitButton;
    }
}