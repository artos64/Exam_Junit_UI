package pageObject.baseSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pageObject.baseElements.SystemDashboardElements;
import java.time.Duration;

import static hooks.WebHooks.saveAsScreenshot;

public class SystemDashboardSteps extends SystemDashboardElements {
    @Step("Переход к списку проектов")
    public void openProject(){
        listProject.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        buttonTest.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        saveAsScreenshot();
    }
}