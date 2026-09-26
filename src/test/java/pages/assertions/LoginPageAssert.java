package pages.assertions;

import pages.LoginPage;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import io.qameta.allure.Step;

public class LoginPageAssert {

    private final LoginPage page;

    private LoginPageAssert(LoginPage page) {
        this.page = page;
    }

    public static LoginPageAssert assertThat(LoginPage page) {
        return new LoginPageAssert(page);
    }
    @Step("Проверить, что поле логина видно")
    public LoginPageAssert loginFieldIsVisible() {
        page.loginInput().shouldBe(visible);
        return this;
    }

    @Step("Проверить, что поле логина содержит \"{expected}\"")
    public LoginPageAssert loginFieldHasValue(String expected) {
        page.loginInput().shouldHave(value(expected));
        return this;
    }

    @Step("Проверить, что поле пароля видно")
    public LoginPageAssert passwordFieldIsVisible() {
        page.passwordInput().shouldBe(visible);
        return this;
    }

    @Step("Проверить, что кнопка \"Войти\" видна")
    public LoginPageAssert submitButtonIsVisible() {
        page.submitButton().shouldBe(visible);
        return this;
    }
}
