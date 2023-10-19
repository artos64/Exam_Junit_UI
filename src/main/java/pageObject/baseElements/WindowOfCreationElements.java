package pageObject.baseElements;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class WindowOfCreationElements {

    public SelenideElement createButton = $x("//a[@id='create_link']").as("Кнопка создания новой задачи");
    public SelenideElement titleOfWindowCreation = $x("//h2[@id='jira-dialog2__heading']").as("Заголовок окна создания задачи");
    public SelenideElement selectOfWindowCreation = $x("//input[@id='issuetype-field']").as("Селект с типами задач");
    public SelenideElement summaryOfWindowCreation = $x("//input[@id='summary']").as("Поле Тема");
    public SelenideElement frameBody = $x("//body[@id='tinymce']/p").as("Поле описания");
    public SelenideElement elementRepair = $x("//select[@id='fixVersions']//option[@value='10001']").as("Вариант выбора 'Version 2.0' в 'Исправленых версиях'");
    public SelenideElement priorityField = $x("//input[@id='priority-field']").as("Поле 'Приоритет'");
    public SelenideElement markField = $x("//textarea[@id='labels-textarea']").as("Поле 'Метки'");
    public SelenideElement elementAffectedVersions = $x("//select[@id='versions']//option[@value='10001']").as("Вариант выбора 'Version 2.0' в 'Затронутых версих'");
    public SelenideElement listAffectedTask = $x("//select[@id='issuelinks-linktype']//option[@value='is duplicated by']").as("Список 'Связанные задачи'");
    public SelenideElement fieldAffectedTask = $x("//textarea[@id='issuelinks-issues-textarea']").as("Поле 'Задачи'");
    public SelenideElement buttonAssigned  = $x("//button[@data-field-id='#assignee']").as("Кнопка 'Назначить меня'");
    public SelenideElement createTask = $x("//input[@value='Создать']").as("Кнопка 'Создать'");
    public SelenideElement successCreatedTaskWindow = $x("//div[@class='aui-message closeable aui-message-success aui-will-close']").as("Сообщение об успешном создании задачи");

}