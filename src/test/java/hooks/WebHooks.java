package hooks;

import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WebHooks {
    private static Properties properties = new Properties();

    @BeforeAll
    static void setupClass() throws IOException {
        properties.load(ClassLoader.getSystemResourceAsStream("application.properties"));

        System.setProperty("selenide.browser", properties.getProperty("selenide.browser"));
        System.setProperty("selenide.pageLoadStrategy", properties.getProperty("selenide.pageLoadStrategy"));
        System.setProperty("selenide.browserSize", properties.getProperty("selenide.browserSize"));
        System.setProperty("selenide.baseUrl", properties.getProperty("selenide.baseUrl"));
        System.setProperty("selenide.timeout", properties.getProperty("selenide.timeout"));
    }

}