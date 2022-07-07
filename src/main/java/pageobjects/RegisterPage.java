package pageobjects;

import com.codeborne.selenide.SelenideElement;
import model.TestData;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class RegisterPage extends Header{
    //URL страницы регистрации
    public final static String URL = TestData.URL_REGISTER;

    // метод проверки видимости поля Имя
    public static boolean isInputNameDisplayed() {
        return inputName.isDisplayed();
    }

    // поле Имя
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Имя')]//following::input[1]")
    private static SelenideElement inputName;
    // метод заполнения поля Имя
    public RegisterPage setInputName(String value) {
        inputName.shouldBe(visible).setValue(value);
        return this;
    }

    // поле Email
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Имя')]//following::input[2]")
   private SelenideElement inputEmail;
    // метод заполнения поля Email
    public RegisterPage setInputEmail(String value) {
        inputEmail.shouldBe(visible).setValue(value);
        return this;
    }

    // поле пароль
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Имя')]//following::input[3]")
    private SelenideElement inputPassword;
    // метод заполнения поля Пароль
    public RegisterPage setInputPassword(String value) {
        inputPassword.shouldBe(visible).setValue(value);
        return this;
    }

    // кнопка Зарегистрироваться
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Зарегистрироваться')]")
    private SelenideElement btnRegistration;
    // метод клика по ссылке Зарегистрироваться
    public LoginPage clickBtnRegistration() {
        btnRegistration.shouldBe(visible).click();
        return page(LoginPage.class);
    }
    public RegisterPage clickBtnRegistrationByShortPassword() {
        btnRegistration.shouldBe(visible).click();
        return this;
    }
    //метод проверки отображения кнопки Зарегистрироваться
    public boolean isBtnRegistrationDisplayed() {
        return btnRegistration.isDisplayed();
    }

    // Некорректный пароль
    @FindBy(how = How.XPATH, using = "//p[contains(text(), 'Некорректный пароль')]")
    private SelenideElement passwordError;
    //метод проверки отображения ошибки пароля
    public boolean isPasswordErrorDisplayed() {
        return passwordError.isDisplayed();
    }

    // ссылка Войти
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Войти')]")
    private SelenideElement lnkEnter;
    // метод клика по кнопке Зарегистрироваться
    public LoginPage clickLnkEnter() {
        lnkEnter.shouldBe(visible).click();
        return page(LoginPage.class);
    }
}