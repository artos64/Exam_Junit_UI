package pageObject.baseElements;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class ChangeStatusElements {

    public SelenideElement activeStatusTask = $x("//span[@id='status-val']//span").as("Активный статус созданной задачи");
    public SelenideElement buttonInProgress = $x("//a[@id='action_id_21']//span[text()='В работе']").as("Кнопка 'В работе'");
    public SelenideElement buttonBusinessProcess= $x("//span[text()='Бизнес-процесс']").as("Кнопка 'Бизнес-процесс'");
    public SelenideElement buttonDone = $x("//span[text()='Выполнено']").as("Кнопка выполнено");

}

