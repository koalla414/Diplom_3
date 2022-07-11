import api.UserClient;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import model.TestData;
import model.User;
import model.UserCredentials;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobjects.MainPage;
import pageobjects.RegisterPage;
import utils.BrowserConfig;

import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {
    @Before
    public void setup() {
        BrowserConfig.initBrowser();
    }
    @After
    public void clauseBrowser() {
        Selenide.webdriver().driver().close(); // закрыли браузер
    }

    @Test
    @DisplayName("Успешная регистрация по кнопке Личный кабинет")
    public void checkRegisterByButtonPersonalAccount() {
    User user = User.getRandomUser();
    MainPage openPage = Selenide.open(TestData.URL, MainPage.class); // открываем главную страницу
    webdriver().driver().getWebDriver().manage().window().maximize(); // разворачиваем окно браузера во весь экран
    openPage.clickBtnPersonalAccount() // нажимаем на ней кнопку Личный кабинет - попадаем на страницу авторизации
            .clickLinkRegister() //нажимаем ссылку Зарегистрироваться
            .setInputName(user.getName()) // заполняем поле Имя
            .setInputEmail(user.getEmail()) // заполняем поле email
            .setInputPassword(user.getPassword()) // заполняем поле Пароль
            .clickBtnRegistration() // нажимаем Зарегистрироваться
            .setInputEmail(user.getEmail()) // заполняем поле email
            .setInputPassword(user.getPassword()) // заполняем поле Пароль
            .clickBtnEnter(); // нажать кнопку Войти
    assertTrue(openPage.isBtnOrderDisplayed()); //проверяем, что отображается кнопка Оформить заказ

    UserCredentials creds = UserCredentials.from(user); // получаем учетные данные созданного пользователя для авторизации
    UserClient userClient = new UserClient();
    ExtractableResponse<Response> loginResponse = userClient.login(creds); // авторизуемся с полученными учетными данными созданного пользователя
    String accessToken = loginResponse.path("accessToken"); // получили accessToken
    userClient.delete(accessToken); // удалили пользователя
}

    @Test
    @DisplayName("Проверка точки входа на страницу регистрации по кнопке Войти в аккаунт")
    public void checkTransitionToRegisterByLoginButtonOnMainPage() {
        MainPage openPage = Selenide.open(TestData.URL, MainPage.class); // открываем главную страницу
        webdriver().driver().getWebDriver().manage().window().maximize(); // разворачиваем окно браузера во весь экран
        RegisterPage page = openPage
                .clickBtnLogin()
                .clickLinkRegister(); // нажимаем кнопку Войти в аккаунт
        assertTrue(page.isBtnRegistrationDisplayed()); //проверяем, что отображается кнопка Зарегистрироваться
    }

    @Test
    @DisplayName("Проверка ошибки для некорректного пароля (менее шести символов).")
    public void checkErrorByShortPassword() {
        String shortPassword = "Passw";
        User user = User.getRandomUser();
        MainPage openPage = Selenide.open(TestData.URL, MainPage.class); // открываем главную страницу
        webdriver().driver().getWebDriver().manage().window().maximize(); // разворачиваем окно браузера во весь экран
        RegisterPage page = openPage.clickBtnPersonalAccount() // нажимаем на ней кнопку Личный кабинет - попадаем на страницу авторизации
                .clickLinkRegister() //нажимаем ссылку Зарегистрироваться
                .setInputName(user.getName()) // заполняем поле Имя
                .setInputEmail(user.getEmail()) // заполняем поле email
                .setInputPassword(shortPassword) // заполняем поле Пароль
                .clickBtnRegistrationByShortPassword(); // нажимаем Зарегистрироваться
        // если пользователь создался, то удаляем его
        if (!page.isPasswordErrorDisplayed()) {
        user.setPassword(shortPassword);
        UserCredentials creds = UserCredentials.from(user); // получаем учетные данные созданного пользователя для авторизации
        UserClient userClient = new UserClient();
        ExtractableResponse<Response> loginResponse = userClient.login(creds); // авторизуемся с полученными учетными данными созданного пользователя
        String accessToken = loginResponse.path("accessToken"); // получили accessToken
        userClient.delete(accessToken); // удалили пользователя
        }
        assertTrue(page.isPasswordErrorDisplayed()); //проверяем, что отображается ошибка Некорректный пароль
    }
}