package pageobjects;

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
        return madeBurger.shouldBe(visible).isDisplayed();
    }

    // вкладка "Булки"
    @FindBy(how = How.XPATH, using = "//span[@class = 'text text_type_main-default' and contains(text(), 'Булки')]")
    private static SelenideElement btnBuns;
    // метод клика по разделу Булки
    public MainPage clickBtnBuns() {
        btnBuns.shouldBe(visible).click();
        return this;
    }
    public boolean isSectionBunsDisplayed() {
        return btnBuns.parent().attr("class").contains("tab_tab_type_current__2BEPc");
    }

    // вкладка "Соусы"
    @FindBy(how = How.XPATH, using = "//span[@class = 'text text_type_main-default' and contains(text(), 'Соусы')]")
    private static SelenideElement btnSauces;
    // метод клика по разделу Булки
    public MainPage clickBtnSauces() {
        btnSauces.shouldBe(visible).click();
        return this;
    }
    public boolean isSectionSaucesDisplayed() {
        return btnSauces.parent().attr("class").contains("tab_tab_type_current__2BEPc");
    }

    // вкладка "Начинки"
    @FindBy(how = How.XPATH, using = "//span[@class = 'text text_type_main-default' and contains(text(), 'Начинки')]")
    private static SelenideElement btnFillings;
    // метод клика по разделу Булки
    public MainPage clickBtnFillings() {
        btnFillings.shouldBe(visible).click();
        return this;
    }
    public boolean isSectionFillingsDisplayed() {
        return btnFillings.parent().attr("class").contains("tab_tab_type_current__2BEPc");
    }
}