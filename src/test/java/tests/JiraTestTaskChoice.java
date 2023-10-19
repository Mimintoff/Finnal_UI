package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.TaskPageSteps;

import static com.codeborne.selenide.Selenide.open;
import static steps.LoginPageSteps.*;

public class JiraTestTaskChoice extends TaskPageSteps {


    @BeforeAll
    @Tag("Проверяем_авторизацию_на_стенде")
    public static void JiraOpen() {
        open("/");
        enterUsername("AT10");
        enterPassword("Qwerty123");
        clickLoginButton();
    }

    @Test
    @Tag("Проверяем_версию_и_статус_задачи")
    public void TaskSearchTest() {
        searchTaskInput("TEST-21967");
        selectTask();
        String version = getTaskVersion();
        String status = getTaskStatus();
        System.out.println("Версия задачи: " + version);
        System.out.println("Статус задачи: " + status);

    }
}
