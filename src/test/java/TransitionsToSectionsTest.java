import api.UserClient;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import model.TestData;
import model.User;
import model.UserCredentials;
import org.junit.Before;
import org.junit.Test;
import pageobjects.Header;
import pageobjects.MainPage;
import pageobjects.ProfilePage;
import pageobjects.RegisterPage;

import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.Assert.assertEquals;
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
    @DisplayName("Переход по клику на «Конструктор»")
    public void checkTransitionByButtonProfile() {

    }

//    Переход по клику на и на логотип Stellar Burgers.
//    Выход по кнопке «Выйти» в личном кабинете.
//
//    Переходы в разделе «Конструктор» к разделам:
//            «Булки»,
//            «Соусы»,
//            «Начинки».



}
