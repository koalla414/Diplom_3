import api.UserClient;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import model.TestData;
import model.User;
import org.junit.Before;
import org.junit.Test;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.ProfilePage;

import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.Assert.assertTrue;

public class TransitionsToSectionsTest {
    private UserClient userClient;
    private User user;

    @Before
    public void setup() {
        userClient = new UserClient();
        user = User.getRandomUser(); // сгенерировали данные пользователя
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет»")
    public void checkTransitionByButtonProfile1() {
        ExtractableResponse<Response> createResponse = userClient.create(user); // регистрация пользователя - отправили сгенерированные данные на ручку АПИ
        String accessToken = createResponse.path("accessToken"); // получили accessToken

        MainPage openPage = Selenide.open(TestData.URL, MainPage.class); // открываем главную страницу
        webdriver().driver().getWebDriver().manage().window().maximize(); // разворачиваем окно браузера во весь экран
        ProfilePage page = openPage
                .clickBtnLogin()
                .setInputEmail(user.getEmail()) // заполняем поле email
                .setInputPassword(user.getPassword()) // заполняем поле Пароль
                .clickBtnEnter() // нажать кнопку Войти
                .clickBtnPersonalAccountByAuthorizedUser(); // нажимаем кнопку Личный кабинет - попадаем на страницу авторизации
        assertTrue(page.checkProfileDisplayed()); //проверяем, что отображается меню Профиль

        userClient.delete(accessToken); // удалили пользователя
    }

    @Test
    @DisplayName("ППереход из личного кабинета в конструктор по клику на «Конструктор»")
    public void checkTransitionFromPersonalAccountToConstructorByButtonConstructor() {
        ExtractableResponse<Response> createResponse = userClient.create(user); // регистрация пользователя - отправили сгенерированные данные на ручку АПИ
        String accessToken = createResponse.path("accessToken"); // получили accessToken

        MainPage openPage = Selenide.open(TestData.URL, MainPage.class); // открываем главную страницу
        webdriver().driver().getWebDriver().manage().window().maximize(); // разворачиваем окно браузера во весь экран
        openPage.clickBtnLogin()
                .setInputEmail(user.getEmail()) // заполняем поле email
                .setInputPassword(user.getPassword()) // заполняем поле Пароль
                .clickBtnEnter() // нажать кнопку Войти
                .clickBtnPersonalAccountByAuthorizedUser() // нажимаем кнопку Личный кабинет - попадаем на страницу авторизации
                .clickBtnConstructor();
        assertTrue(openPage.isMadeBurgerDisplayed()); //проверяем, что отображается меню Профиль

        userClient.delete(accessToken); // удалили пользователя
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void checkTransitionFromPersonalAccountToConstructorByStellarBurgersLogo() {
        ExtractableResponse<Response> createResponse = userClient.create(user); // регистрация пользователя - отправили сгенерированные данные на ручку АПИ
        String accessToken = createResponse.path("accessToken"); // получили accessToken

        MainPage openPage = Selenide.open(TestData.URL, MainPage.class); // открываем главную страницу
        webdriver().driver().getWebDriver().manage().window().maximize(); // разворачиваем окно браузера во весь экран
        openPage.clickBtnLogin()
                .setInputEmail(user.getEmail()) // заполняем поле email
                .setInputPassword(user.getPassword()) // заполняем поле Пароль
                .clickBtnEnter() // нажать кнопку Войти
                .clickBtnPersonalAccountByAuthorizedUser() // нажимаем кнопку Личный кабинет - попадаем на страницу авторизации
                .clickLogoStellarBurgers(); // нажимаем на логотип
        assertTrue(openPage.isMadeBurgerDisplayed()); //проверяем, что отображается меню Профиль

        userClient.delete(accessToken); // удалили пользователя
    }

    @Test
    @DisplayName("Выход из аккаунта по кнопке «Выйти» в личном кабинете")
    public void checkLogoutByButtonExitOfProfilePage() {
        ExtractableResponse<Response> createResponse = userClient.create(user); // регистрация пользователя - отправили сгенерированные данные на ручку АПИ
        String accessToken = createResponse.path("accessToken"); // получили accessToken

        MainPage openPage = Selenide.open(TestData.URL, MainPage.class); // открываем главную страницу
        webdriver().driver().getWebDriver().manage().window().maximize(); // разворачиваем окно браузера во весь экран
        LoginPage page = openPage.clickBtnLogin()
                .setInputEmail(user.getEmail()) // заполняем поле email
                .setInputPassword(user.getPassword()) // заполняем поле Пароль
                .clickBtnEnter() // нажать кнопку Войти
                .clickBtnPersonalAccountByAuthorizedUser() // нажимаем кнопку Личный кабинет - попадаем на страницу авторизации
                .clickBtnExit(); // нажимаем Выход
        assertTrue(page.isBtnEnterDisplayed()); //проверяем, что отображается кнопка Войти для авторизации

        userClient.delete(accessToken); // удалили пользователя
    }

    @Test
    @DisplayName("Переход в разделе «Конструктор» к разделу «Булки»")
    public void checkTransitionToBuns() {
        MainPage openPage = Selenide.open(TestData.URL, MainPage.class); // открываем главную страницу
        webdriver().driver().getWebDriver().manage().window().maximize(); // разворачиваем окно браузера во весь экран
        openPage.clickBtnSauces()
                .clickBtnBuns();
        assertTrue(openPage.isSectionBunsDisplayed()); //проверяем, что отображается раздел «Булки»
    }

    @Test
    @DisplayName("Переход в разделе «Конструктор» к разделу «Соусы»")
    public void checkTransitionToSauces() {
        MainPage openPage = Selenide.open(TestData.URL, MainPage.class); // открываем главную страницу
        webdriver().driver().getWebDriver().manage().window().maximize(); // разворачиваем окно браузера во весь экран
        openPage.clickBtnSauces();
                assertTrue(openPage.isSectionSaucesDisplayed()); //проверяем, что отображается раздел «Соусы»
    }

    @Test
    @DisplayName("Переход в разделе «Конструктор» к разделу «Начинки»")
    public void checkTransitionToFillings() {
        MainPage openPage = Selenide.open(TestData.URL, MainPage.class); // открываем главную страницу
        webdriver().driver().getWebDriver().manage().window().maximize(); // разворачиваем окно браузера во весь экран
        openPage.clickBtnFillings();
                assertTrue(openPage.isSectionFillingsDisplayed()); //проверяем, что отображается раздел «Начинки»
    }
}