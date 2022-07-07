package pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class Header {

    // кнопка Личный кабинет
    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Личный Кабинет')]")
    private SelenideElement btnPersonalAccount;

    // метод клика по кнопке Личный кабинет незарегистрированным пользователем
    public LoginPage clickBtnPersonalAccount() {
        btnPersonalAccount.shouldBe(visible).click();
        return page(LoginPage.class);
    }

    // метод клика по кнопке Личный кабинет зарегистрированным пользователем
    public ProfilePage clickBtnPersonalAccountByAuthorizedUser() {
        btnPersonalAccount.shouldBe(visible).click();
        return page(ProfilePage.class);
    }

    // кнопка Конструктор
    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Конструктор')]")
    private SelenideElement btnConstructor;

    // метод клика по кнопке Конструктор
    public MainPage clickBtnConstructor() {
        btnConstructor.shouldBe(visible).click();
        return page(MainPage.class);
    }

    // логотип Stellar Burgers
    @FindBy(how = How.CSS, using = ".AppHeader_header__logo__2D0X2 a")
    private SelenideElement logoStellarBurgers;
    // метод клика по кнопке Конструктор
    public MainPage clickLogoStellarBurgers() {
        logoStellarBurgers.shouldBe(visible).click();
        return page(MainPage.class);
    }
}