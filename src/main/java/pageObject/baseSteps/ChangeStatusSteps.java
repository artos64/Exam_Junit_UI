package pageObject.baseSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pageObject.baseElements.ChangeStatusElements;
import java.time.Duration;
import static hooks.WebHooks.saveAsScreenshot;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ChangeStatusSteps extends ChangeStatusElements {

    @Step("Проверка смены статусов задачи")
    public void checkAndChangeStatus(){
        String stateTask = stateTask();

        while(!stateTask().contains("ГОТОВО")) {
            if(stateTask.contains("СДЕЛАТЬ")) {
                clickInWork();
                sleep(1000L);
                checkState(stateTask,stateTask());
            }
            if (stateTask.contains("В РАБОТЕ")){
                clickBusiness();
                clickDone();
                sleep(1000L);
                checkState(stateTask,stateTask());
            }
            stateTask = stateTask();
            saveAsScreenshot();
        }
    }

    @Step("Узнаем статус задачи")
    public String stateTask(){
        return activeStatusTask.shouldBe(Condition.visible, Duration.ofSeconds(10)).getText();
    }

    @Step("Нажатие кнопки 'В работе'")
    public void clickInWork(){
        buttonInProgress.shouldBe(Condition.visible,Duration.ofSeconds(15)).click();
        saveAsScreenshot();
    }

    @Step("Проверка изменения статуса")
    public void checkState(String state1, String state2){
        assertNotEquals(state1,state2,"Состояние не изменилось");
    }

    @Step("Нажатие кнопки бизнес-процессы")
    public void clickBusiness(){
        buttonBusinessProcess.shouldBe(Condition.visible,Duration.ofSeconds(10)).click();
    }
    @Step("Нажатие кнопки выполнено")
    public void clickDone(){
        buttonDone.shouldBe(Condition.visible,Duration.ofSeconds(15)).click();
        saveAsScreenshot();
    }
}