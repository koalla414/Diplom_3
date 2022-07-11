package pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage extends Header {
    // поле Email
    @FindBy(how = How.XPATH, using = "//input[@type='text']")
    private SelenideElement inputEmail;

    // поле пароль
    @FindBy(how = How.XPATH, using = "//input[@type='password']")
    private SelenideElement inputPassword;

    // ссылка Зарегистрироваться
    @FindBy(how = How.XPATH, using = "//a[@href='/register']")
    private SelenideElement linkRegister;

    // кнопка Войти
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Войти')]")
    private SelenideElement btnEnter;

    // ссылка Восстановить пароль
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Восстановить пароль')]")
    private SelenideElement lnkForgotPassword;

    // метод заполнения поля Email
    public LoginPage setInputEmail(String value) {
        inputEmail.should(exist).click();
        inputEmail.setValue(value);
        return this;
    }

    // метод заполнения поля Пароль
    public LoginPage setInputPassword(String value) {
        inputPassword.shouldBe(visible).setValue(value);
        return this;
    }

    // метод клика по ссылке Зарегистрироваться
    public RegisterPage clickLinkRegister() {
        linkRegister.shouldBe(visible).click();
        return page(RegisterPage.class);
    }

    // метод клика кнопки Войти
    public MainPage clickBtnEnter() {
        btnEnter.shouldBe(visible).click();
        return page(MainPage.class);
    }
    public boolean isBtnEnterDisplayed() {
        return btnEnter.shouldBe(visible).isDisplayed();
    }

    // метод клика кнопки Войти
    public ForgotPasswordPage clickLnkForgotPassword() {
        lnkForgotPassword.shouldBe(visible).click();
        return page(ForgotPasswordPage.class);
    }
}