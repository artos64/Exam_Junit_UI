package pageObject.baseElements;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class TaskSeleniumElements {

    public String url_test = "https://edujira.ifellow.ru/browse/TEST-28409";
    public SelenideElement statusButton = $x("//li[@class='item item-right']//span[text()='Сделать']").as("Статус задачи TestSelenium TEST-28409");
    public SelenideElement taskVersion = $x("//li[@class='item item-right']//a[@title = 'Version 2.0 ']").as("Версия задачи TestSelenium TEST-28409");

}