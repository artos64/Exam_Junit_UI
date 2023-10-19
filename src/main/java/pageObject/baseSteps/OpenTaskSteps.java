package pageObject.baseSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pageObject.baseElements.OpenTasksElements;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static hooks.WebHooks.saveAsScreenshot;

public class OpenTaskSteps extends OpenTasksElements {

    @Step("Запоминаем количество тестов")
    public int memberTask(){
        int hashText = counterTask.shouldBe(Condition.visible, Duration.ofSeconds(10)).getText().hashCode();
        return hashText;
    }

    @Step("Сравнение счетчика, поиск задачи")
    public void checkNumberOfTasks(int hashText){
        assertNotEquals(hashText,memberTask(),"Значение количества задач не поменялось");
        saveAsScreenshot();
    }

    @Step("Поиск задачи '{numberTask}'")
    public void findTask(String numberTask){
        inputSearch.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(numberTask).pressEnter();
        saveAsScreenshot();
    }
}

