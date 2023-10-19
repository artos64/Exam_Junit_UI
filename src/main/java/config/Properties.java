package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Reloadable;

@Config.Sources({
        "file:src/test/resources/properties/test.properties",
        "file:src/test/resources/target/allure-results"
})

public interface Properties extends Reloadable {
    Properties properties = ConfigFactory.create(Properties.class);

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("baseLogin.url")
    String baseUrl();
}
