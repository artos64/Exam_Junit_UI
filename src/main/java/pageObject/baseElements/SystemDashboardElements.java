package pageObject.baseElements;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class SystemDashboardElements {

    public SelenideElement listProject = $x("//a[text()='Проекты']").as("Кнопка 'Проекты'");
    public SelenideElement buttonTest = $x("//a[text()='Test (TEST)']").as("Кнопка проекта 'Test (TEST)'");

}

