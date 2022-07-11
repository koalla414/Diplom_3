package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ProfilePage extends Header {
    // поле Имя
    @FindBy(how = How.XPATH, using = "")
    private SelenideElement inputName;

    // поле Email
    @FindBy(how = How.XPATH, using = "")
    private SelenideElement inputEmail;

    // кнопка Сохранить
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Сохранить')]")
    private SelenideElement btnSave;

    // Выход
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Выход')]")
    private SelenideElement btnExit;

    // Профиль
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Профиль')]")
    private SelenideElement profile;

    // метод заполнения поля Имя
    public ProfilePage setInputName(String value) {
        inputName.setValue(value);
        return this;
    }

    // метод заполнения поля Email
    public ProfilePage setInputEmail(String value) {
        inputEmail.setValue(value);
        return this;
    }

    // метод проверки отображения кнопки Сохранить
    public boolean checkBtnSaveDisplayed() {
        return btnSave.isDisplayed();
    }

    // метод клика по кнопке Выход
    public LoginPage clickBtnExit() {
        btnExit.click();
        return page(LoginPage.class);
    }

    // метод проверки отображения пункта меню Профиль
    public boolean checkProfileDisplayed() {
        profile.should(Condition.exist);
        return profile.isDisplayed();
    }
}