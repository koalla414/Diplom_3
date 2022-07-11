package pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordPage extends Header {
    // ссылка Войти
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Войти')]")
    private SelenideElement lnkEnter;

    // метод клика по кнопке Зарегистрироваться
    public LoginPage clickLnkEnter() {
        lnkEnter.shouldBe(visible).click();
        return page(LoginPage.class);
    }
}
