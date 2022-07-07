package pageobjects;

import com.codeborne.selenide.SelenideElement;
import model.TestData;
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
    @FindBy(how = How.XPATH, using = "//a[@class='AppHeader_header__link__3D_hX AppHeader_header__link_active__1IkJo']")
    private SelenideElement btnConstructor;

    // метод клика по кнопке Конструктор
    public MainPage clickBtnConstructor() {
        btnConstructor.shouldBe(visible).click();
        return page(MainPage.class);
    }
}