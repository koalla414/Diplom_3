package pageobjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import model.TestData;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

@Data
public class MainPage extends Header{
    //URL главной страницы
    public final static String URL = TestData.URL;

    // кнопка "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Войти в аккаунт')]")
    private SelenideElement btnLogin;
    // метод клика по кнопке Войти в аккаунт
    public LoginPage clickBtnLogin() {
        btnLogin.shouldBe(visible);
        btnLogin.click();
        return page(LoginPage.class);
    }

    // кнопка "Оформить заказ"
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Оформить заказ')]")
    private static SelenideElement btnOrder;
    // метод клика по кнопке Войти в аккаунт
    public MainPage clickBtnOrder() {
        btnOrder.shouldBe(visible).click();
        return this;
    }
    //метод проверки отображения кнопки "Оформить заказ"
    public boolean isBtnOrderDisplayed() {
        return btnOrder.shouldBe(visible).isDisplayed();
    }

    // заголовок "Соберите бургер"
    @FindBy(how = How.XPATH, using = "//h1[contains (text(), 'Соберите бургер')]")
    private static SelenideElement madeBurger;
    //метод проверки отображения заголовка "Соберите бургер"
    public static boolean isMadeBurgerDisplayed() {
        return madeBurger.isDisplayed();
    }
}