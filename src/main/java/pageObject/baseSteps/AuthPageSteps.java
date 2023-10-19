package pageObject.baseSteps;

import com.codeborne.selenide.WebDriverRunner;
import config.Properties;
import pageObject.baseElements.AuthPageElements;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static hooks.WebHooks.saveAsScreenshot;
import static com.codeborne.selenide.Selenide.open;

public class AuthPageSteps extends AuthPageElements {

    protected static Properties properties = Properties.properties;

    @Step("Авторизация на сервисе eduJira")
    public void authorizationJira() {
        open(properties.baseUrl());
        WebDriverRunner.getWebDriver().manage().window().maximize();
        usernameField.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(properties.login());
        saveAsScreenshot();
        passwordField.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(properties.password());
        saveAsScreenshot();
        enterButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        assertTrue(headingText.is(Condition.visible), "Заголовок System Dashboard не найден");
        saveAsScreenshot();
    }
}