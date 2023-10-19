package pageObject.baseSteps;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import pageObject.baseElements.WindowOfCreationElements;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;
import static hooks.WebHooks.saveAsScreenshot;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WindowOfCreationSteps extends WindowOfCreationElements {

    @Step("Создание новой задачи")
    public void createTask(String nameTask) {

        clickCreate();

        Assertions.assertEquals("Создание задачи",
                titleOfWindowCreation.shouldBe(visible, Duration.ofSeconds(10)).getText(),
                "Текст заголовка не соответствует");

        selectTypeTask("Ошибка");
        inputTheme(nameTask);
        inputDescription();
        selectVersion();
        selectPriority("High");
        inputMark("bugfix");
        inputEnvironment();
        selectAffectedVersion();
        selectAffectedTask();
        selectTask("TEST-28409");
        clickAssignedMe();
        createTask.shouldBe(visible, Duration.ofSeconds(10)).click();
        createTask.shouldNotBe(visible,Duration.ofSeconds(10));
        sleep(500L);
        assertTrue(successCreatedTaskWindow.is(visible),"Отсутсвует пуш-окно об успешном создании задачи");
        saveAsScreenshot();
    }

    @Step("Нажимаем кнопку создать")
    public void clickCreate(){
        Assertions.assertEquals("Создать",
                createButton.shouldBe(visible, Duration.ofSeconds(10)).getText(),
                "Текст кнопки не соответствует");
        createButton.click();
        saveAsScreenshot();
    }

    @Step("Выбираем Тип задачи: '{typeTask}'")
    public void selectTypeTask(String typeTask){
        selectOfWindowCreation.shouldBe(visible, Duration.ofSeconds(10)).click();
        selectOfWindowCreation.sendKeys(Keys.CONTROL+Keys.chord("A")+Keys.DELETE);
        selectOfWindowCreation.sendKeys(typeTask);
        assertEquals(typeTask,selectOfWindowCreation.parent().getAttribute("data-query"),"Вставился неверный тип задачи");
        selectOfWindowCreation.sendKeys(Keys.ENTER);
        saveAsScreenshot();
    }

    @Step("Вводим название темы '{name}'")
    public void inputTheme(String name){
        summaryOfWindowCreation.shouldBe(visible, Duration.ofSeconds(10)).setValue(name);
        saveAsScreenshot();
    }

    @Step("Вводим описание")
    public void inputDescription(){
        Selenide.switchTo().frame("mce_7_ifr");
        frameBody.sendKeys("Описание теста");
        Selenide.switchTo().defaultContent();
        saveAsScreenshot();
    }

    @Step("Выбираем значение в исправить в версиях")
    public void selectVersion(){
        elementRepair.shouldBe(visible, Duration.ofSeconds(10)).click();
        saveAsScreenshot();
    }

    @Step("Выбираем приоритет")
    public void selectPriority(String namePriority){
        priorityField.shouldBe(visible, Duration.ofSeconds(10)).click();
        priorityField.sendKeys(Keys.CONTROL+Keys.chord("A")+Keys.DELETE);
        priorityField.sendKeys(namePriority);
        assertEquals(namePriority,priorityField.parent().getAttribute("data-query"),"Вставился неверный приоритет");
        priorityField.sendKeys(Keys.ENTER);
        saveAsScreenshot();
    }

    @Step("Указываем метку")
    public void inputMark(String mark){
        markField.shouldBe(visible, Duration.ofSeconds(10)).setValue(mark).pressEnter();
        saveAsScreenshot();
    }

    @Step("Вводим окружение")
    public void inputEnvironment(){
        Selenide.switchTo().frame("mce_8_ifr");
        frameBody.sendKeys("Окружение теста");
        Selenide.switchTo().defaultContent();
        saveAsScreenshot();
    }

    @Step("Выбираем затронутую версию")
    public void selectAffectedVersion(){
        elementAffectedVersions.shouldBe(visible, Duration.ofSeconds(10)).click();
        elementAffectedVersions.shouldBe(visible, Duration.ofSeconds(10)).click();
        saveAsScreenshot();
    }

    @Step("Выбираем связанную задачу")
    public void selectAffectedTask(){
        elementAffectedVersions.shouldBe(visible, Duration.ofSeconds(10)).click();
        listAffectedTask.shouldBe(visible, Duration.ofSeconds(10)).click();
        saveAsScreenshot();
    }

    @Step("Выбираем задачу")
    public void selectTask(String nameTask){
        fieldAffectedTask.shouldBe(visible, Duration.ofSeconds(10)).click();
        fieldAffectedTask.sendKeys(Keys.CONTROL+Keys.chord("A")+Keys.DELETE);
        fieldAffectedTask.sendKeys(nameTask);
        sleep(1000L);
        assertEquals(nameTask,fieldAffectedTask.parent().getAttribute("data-query"),"Вставилась неверная задача");
        fieldAffectedTask.sendKeys(Keys.ENTER);
        saveAsScreenshot();
    }

    @Step("Нажимаем 'назначить меня'")
    public void clickAssignedMe(){
        buttonAssigned.shouldBe(visible, Duration.ofSeconds(10)).click();
        saveAsScreenshot();
    }
}

