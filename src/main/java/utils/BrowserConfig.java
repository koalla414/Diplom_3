package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BrowserConfig {
    public static void initBrowser() {

        final String usingDriverPath = "DRIVER_PATH";
        Map<String, String> env = System.getenv();

        String webDriverPath = env.get(usingDriverPath);

        if (webDriverPath != null) {
            System.setProperty("webdriver.chrome.driver", webDriverPath);
            WebDriver driver = new ChromeDriver();
            setWebDriver(driver);
        }
    }
}