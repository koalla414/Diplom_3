import api.UserClient;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import model.TestData;
import model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageobjects.MainPage;
import utils.BrowserConfig;

import static com.codeborne.selenide.Selenide.webdriver;

public class LoginTest {
    private UserClient userClient;
    private User user;
    String accessToken;

    @Before
    public void setup() {
        BrowserConfig.initBrowser();
        userClient = new UserClient();
        user = User.getRandomUser(); // сгенерировали данные пользователя
        ExtractableResponse<Response> createResponse = userClient.create(user); // регистрация пользователя - отправили сгенерированные данные на ручку АПИ
        accessToken = createResponse.path("accessToken"); // получили accessToken
    }

    @After
    public void delTestUser() {
        userClient.delete(accessToken); // удалили пользователя
        Selenide.webdriver().driver().close(); // закрыли браузер
    }

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void checkLoginByButtonEnterOnMainPage() {
        MainPage openPage = Selenide.open(TestData.URL, MainPage.class); // открываем главную страницу
        webdriver().driver().getWebDriver().manage().window().maximize(); // разворачиваем окно браузера во весь экран
        openPage.clickBtnLogin() // нажимаем кнопу Войти в аккаунт
                .setInputEmail(user.getEmail()) // заполняем поле email
                .setInputPassword(user.getPassword()) // заполняем поле Пароль
                .clickBtnEnter(); // нажать кнопку Войти
        Assert.assertTrue(openPage.isBtnOrderDisplayed()); //проверяем, что отображается кнопка Оформить заказ
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void checkLoginByButtonPersonalAccount() {
        MainPage openPage = Selenide.open(TestData.URL, MainPage.class); // открываем главную страницу
        webdriver().driver().getWebDriver().manage().window().maximize(); // разворачиваем окно браузера во весь экран
        openPage.clickBtnLogin() // нажимаем кнопу
                .setInputEmail(user.getEmail()) // заполняем поле email
                .setInputPassword(user.getPassword()) // заполняем поле Пароль
                .clickBtnEnter(); // нажать кнопку Войти
        Assert.assertTrue(openPage.isBtnOrderDisplayed()); //проверяем, что отображается кнопка Оформить заказ
    }

    @Test
    @DisplayName("вход через ссылку в форме регистрации")
    public void checkLoginByLinkOnRegisterPage() {
        MainPage openPage = Selenide.open(TestData.URL, MainPage.class); // открываем страницу регистрации
        webdriver().driver().getWebDriver().manage().window().maximize(); // разворачиваем окно браузера во весь экран
        openPage.clickBtnLogin()
                .clickLinkRegister()
                .clickLnkEnter() // нажимаем кнопу
                .setInputEmail(user.getEmail()) // заполняем поле email
                .setInputPassword(user.getPassword()) // заполняем поле Пароль
                .clickBtnEnter(); // нажать кнопку Войти
        Assert.assertTrue(openPage.isBtnOrderDisplayed()); //проверяем, что отображается кнопка Оформить заказ
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void checkLoginByBtnOnForgotPasswordPage() {
        MainPage openPage = Selenide.open(TestData.URL, MainPage.class); // открываем страницу регистрации
        webdriver().driver().getWebDriver().manage().window().maximize(); // разворачиваем окно браузера во весь экран
        openPage.clickBtnLogin()
                .clickLnkForgotPassword()
                .clickLnkEnter()
                .setInputEmail(user.getEmail()) // заполняем поле email
                .setInputPassword(user.getPassword()) // заполняем поле Пароль
                .clickBtnEnter(); // нажать кнопку Войти
        Assert.assertTrue(openPage.isBtnOrderDisplayed()); //проверяем, что отображается кнопка Оформить заказ
    }
}