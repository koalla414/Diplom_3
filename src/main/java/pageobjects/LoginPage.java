package pageobjects;

import com.codeborne.selenide.SelenideElement;
import model.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage extends Header {
    //URL страницы авторизации
    public final static String URL = TestData.URL_LOGIN;

    // поле Email
    @FindBy(how = How.XPATH, using = "//input[@type='text']")
    private SelenideElement inputEmail;
    // метод заполнения поля Email
    public LoginPage setInputEmail(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        inputEmail.shouldBe(visible).setValue(value);
        return this;
    }

    // поле пароль
    @FindBy(how = How.XPATH, using = "//input[@type='password']")
    private SelenideElement inputPassword;
    // метод заполнения поля Пароль
    public LoginPage setInputPassword(String value) {
        inputPassword.shouldBe(visible).setValue(value);
        return this;
    }

    // ссылка Зарегистрироваться
    @FindBy(how = How.XPATH, using = "//a[@href='/register']")
    private SelenideElement linkRegister;
    // метод клика по ссылке Зарегистрироваться
    public RegisterPage clickLinkRegister() {
        linkRegister.shouldBe(visible).click();
        return page(RegisterPage.class);
    }

    // кнопка Войти
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Войти')]")
    private SelenideElement btnEnter;
    // метод клика кнопки Войти
    public MainPage clickBtnEnter() {
        btnEnter.shouldBe(visible).click();
        return page(MainPage.class);
    }



//    // метод отображения _________________ при авторизации
//    public boolean is(String email, String password) {
//        click
}
