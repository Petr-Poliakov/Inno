package pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class LoginPage {

    private final SelenideElement loginInput = $("#username");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement submitButton = $("button[type='submit']");

    public LoginPage open() {
        Selenide.open("/login");
        return this;
    }

    //input

    public LoginPage setLogin(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    //click()

    public void clickSubmitButton() {
        submitButton.click();
    }

    //auth

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