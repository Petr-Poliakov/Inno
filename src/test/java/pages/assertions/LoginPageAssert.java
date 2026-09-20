package pages.assertions;

import pages.LoginPage;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;

public class LoginPageAssert {

    private final LoginPage page;

    private LoginPageAssert(LoginPage page) {
        this.page = page;
    }

    public static LoginPageAssert assertThat(LoginPage page) {
        return new LoginPageAssert(page);
    }

    public LoginPageAssert loginFieldIsVisible() {
        page.loginInput().shouldBe(visible);
        return this;
    }

    public LoginPageAssert loginFieldHasValue(String expected) {
        page.loginInput().shouldHave(value(expected));
        return this;
    }

    public LoginPageAssert passwordFieldIsVisible() {
        page.passwordInput().shouldBe(visible);
        return this;
    }

    public LoginPageAssert submitButtonIsVisible() {
        page.submitButton().shouldBe(visible);
        return this;
    }
}
