package tests;

import hooks.WebHooks;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pageObject.baseSteps.*;
import java.util.UUID;

public class RunTest extends WebHooks {

    public final AuthPageSteps authPageSteps = new AuthPageSteps();
    public final SystemDashboardSteps systemDashboardSteps = new SystemDashboardSteps();
    public final OpenTaskSteps openTaskSteps = new OpenTaskSteps();
    public final TaskSeleniumSteps taskSeleniumSteps = new TaskSeleniumSteps();
    public final WindowOfCreationSteps windowOfCreationSteps = new WindowOfCreationSteps();
    public final ChangeStatusSteps changeStatusSteps = new ChangeStatusSteps();

    @Test
    @Epic("Проверка сервиса EduJira")
    @Tag("AT-48771251")
    @DisplayName("Проверка создания новой задачи и изменение статусов на соответствии версии")
    @Owner("Tareev Nikita")
    public void checkCreateTaskTest(){
        authPageSteps.authorizationJira();
        systemDashboardSteps.openProject();
        int hashText = openTaskSteps.memberTask();
        openTaskSteps.findTask("TEST-28409");
        taskSeleniumSteps.checkVersionStatus();
        String nameTask ="Тема" + UUID.randomUUID().toString().substring(0,10);
        windowOfCreationSteps.createTask(nameTask);
        systemDashboardSteps.openProject();
        openTaskSteps.checkNumberOfTasks(hashText);
        openTaskSteps.findTask(nameTask);
        changeStatusSteps.checkAndChangeStatus();
    }
}
