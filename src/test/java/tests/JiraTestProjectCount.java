package tests;

import hooks.WebHooks;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static steps.LoginPageSteps.*;
import static steps.ProjectPageSteps.*;
import static steps.ProjectPageSteps.projectCountGeneral;

public class JiraTestProjectCount extends WebHooks {
    @BeforeAll
    @Tag("Проверяем_авторизацию_на_стенде")
    public static void JiraOpen() {
        open("/");
        enterUsername("AT10");
        enterPassword("Qwerty123");
        clickLoginButton();
    }


    @Test
    @Tag("Проверяем_общее_Количество_задач")
    public void checkTotalTasks() {
        clickProjectLink();
        clickProjectChoice();
        clickProjectSearch();
        projectCountGeneral();
    }
}
