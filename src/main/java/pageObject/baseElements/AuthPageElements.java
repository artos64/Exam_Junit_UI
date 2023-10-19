package pageObject.baseElements;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class AuthPageElements {

    public SelenideElement usernameField = $x("//input[@name = 'os_username']").as("Поле 'Имя пользователя'");
    public SelenideElement passwordField = $x("//input[@name = 'os_password']").as("Поле 'Пароль'");
    public SelenideElement enterButton = $x("//input[@value= 'Вход']").as("Кнопка 'Вход'");
    public SelenideElement headingText = $x("//h1[text()='System Dashboard']").as("Заголовок 'System Dashboard'");

}
