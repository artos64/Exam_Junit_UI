package hooks;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;

public abstract class WebHooks {

    @BeforeAll
    public static void driverSetup() {
        Configuration.pageLoadStrategy="eager";
    }

    @AfterAll
    public static void closeDriver(){
        getWebDriver().close();

    }

    @BeforeAll
    public static void allureSubthreadParallel(){
        String listenerName = "AllureSelenide";
        if (!(SelenideLogger.hasListener(listenerName)))
            SelenideLogger.addListener(listenerName,
                    (new AllureSelenide().screenshots(true).savePageSource(false)));
    }

    @Attachment(value = "screen",type = "image/png")
    public static byte[] saveAsScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }

}


