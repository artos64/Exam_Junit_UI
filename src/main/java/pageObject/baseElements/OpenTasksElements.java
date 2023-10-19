package pageObject.baseElements;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class OpenTasksElements {

    public SelenideElement counterTask = $x("//div[@class='pager']//div[@class='showing']//span").as("Счетчик Задач");
    public SelenideElement inputSearch = $x("//input[@id='quickSearchInput']").as("Строка поиска");

}

