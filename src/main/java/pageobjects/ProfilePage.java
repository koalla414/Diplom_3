package pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage extends Header {
    // поле Имя
    @FindBy(how = How.XPATH, using = "")
    private SelenideElement inputName;
    // метод заполнения поля Имя
    public ProfilePage setInputName(String value) {
        inputName.setValue(value);
        return this;
    }

    // поле Email
    @FindBy(how = How.XPATH, using = "")
    private SelenideElement inputEmail;
    // метод заполнения поля Email
    public ProfilePage setInputEmail(String value) {
        inputEmail.setValue(value);
        return this;
    }

    // кнопка Сохранить
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Сохранить')]")
    private SelenideElement btnSave;
    // метод проверки отображения кнопки Сохранить
    public boolean checkBtnSaveDisplayed() {
        return btnSave.isDisplayed();
    }

    // Выход
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Выход')]")
    private SelenideElement btnExit;
    // метод клика по кнопке Выход
    public ProfilePage clickBtnExit() {
        btnExit.click();
        return this;
    }

    // Профиль
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Профиль')]")
    private SelenideElement profile;
    // метод проверки отображения пункта меню Профиль
    public boolean checkProfileDisplayed() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return profile.isDisplayed();
    }
}