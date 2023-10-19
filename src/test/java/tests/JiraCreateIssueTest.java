package tests;

import hooks.WebHooks;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static steps.CreateIssuePageSteps.*;
import static steps.LoginPageSteps.*;


public class JiraCreateIssueTest extends WebHooks {

    @BeforeAll
    @Step("Проверяем_авторизацию_на_стенде")
    public static void JiraOpen() {
        open("/");
        enterUsername("AT10");
        enterPassword("Qwerty123");
        clickLoginButton();
    }


    @Test
    @Tag("Проверяем_создание_задачи")
    public void testCreateIssue() {

        createIssue();
    }

    private void createIssue() {
        OpenCreateTaskWindow();
        FillRequiredFields("Ошибка", "Ошибка_Тестовая_Описание");
        FillFixVersionField();
        FillPriorityField();
        FillLabelsField();
        FillEnvironmentField();
        FillAffectedVersionField();
        selectIssueRelatedTasks();
        assignIssueToMe();
        enterIssueSprint();
        clickCreateIssueButton();
    }

    @Test
    @Tag("Проверяем_закрытие_задачи")
    public void ClosedIssueTest() {
        createIssue();
        checkCreatedIssueKey();
        checkCreatedIssueAssignToMe();
        clickIssueStatusInWork();
        clickIssueStatusWorkFlow();
        clickIssueFinalizationWindowCheckButton();
        checkIssueStatusClosed("РЕШЕННЫЕ");


    }


}











