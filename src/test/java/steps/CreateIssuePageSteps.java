package steps;

import elements.CreateIssuePageElements;
import io.qameta.allure.Step;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.visible;
import static elements.ProjectPageElements.ProjectSearch;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateIssuePageSteps extends CreateIssuePageElements {

    @Step("Открыть окно создания задачи")
    public static void OpenCreateTaskWindow() {
        CreateButton.shouldBe(visible, Duration.ofSeconds(30)).click();
        CreateWindow.shouldBe(visible, Duration.ofSeconds(30));
    }

    @Step("Зполняем поля:выбора проекта, типа задачи, названия задачи, поле описание")
    public static void FillRequiredFields(String Summary, String Description) {
        ProjectField.shouldBe(visible, Duration.ofSeconds(30));
        ProjectField.shouldBe(visible, Duration.ofSeconds(30));
        IssueSummary.shouldBe(visible, Duration.ofSeconds(30)).setValue(Summary);//"Ошибка_Тестовая"
        IssueDescriptionType.shouldBe(visible, Duration.ofSeconds(30)).click();//поле описание
        IssueDescription.shouldBe(visible, Duration.ofSeconds(30)).setValue(Description);//"Ошибка_Тестовая_Описание"
    }


    @Step("Заполняем поле Исправить в версиях")
    public static void FillFixVersionField() {
        IssueFixVersion.shouldBe(visible, Duration.ofSeconds(30)).click();
    }

    @Step("Заполняем поле приоритета задачи")
    public static void FillPriorityField() {

        PriorityField.shouldBe(visible, Duration.ofSeconds(30)).click();
    }

    @Step("Заполняем поле Метки")
    public static void FillLabelsField() {
        Issuelabels.shouldBe(visible, Duration.ofSeconds(30)).click();
    }

    @Step("Заполняем поле окружения задачи")
    public static void FillEnvironmentField() {
        IssueEnvironmentType.shouldBe(visible, Duration.ofSeconds(30)).click();
        IssueEnvironment.shouldBe(visible, Duration.ofSeconds(30)).click();
    }

    @Step("Заполняем поле Затронуты версии")
    public static void FillAffectedVersionField() {
        IssueAffectedVersion.shouldBe(visible, Duration.ofSeconds(30)).click();
    }

    @Step("Заполняем поля Связанные задачи")
    public static void selectIssueRelatedTasks() {
        IssueRelatedTasksType.shouldBe(visible, Duration.ofSeconds(30)).click();
        IssueRelatedTasks.shouldBe(visible, Duration.ofSeconds(30)).click();//вставить текст
    }

    @Step("Нажимаем кнопку Назначить на меня")
    public static void assignIssueToMe() {
        IssueAssignToMe.shouldBe(visible, Duration.ofSeconds(30)).click();
    }

    @Step("Заполняем поле Спринт")
    public static void enterIssueSprint() {
        IssueSprint.shouldBe(visible, Duration.ofSeconds(30)).click();
    }

    @Step("Нажимаем на кнопку создать")
    public static void clickCreateIssueButton() {
        CreateIssueButton.shouldBe(visible, Duration.ofSeconds(30)).click();
    }

    @Step("Получаем Код  созданной задачи")
    public static void checkCreatedIssueKey() {
        CreatedIssueKey.shouldBe(visible, Duration.ofSeconds(30));
        String issueKey = CreatedIssueKey.getText();
        Pattern patternTestIssue = Pattern.compile("(TEST-\\d+)");
        Matcher issueKeyTest = patternTestIssue.matcher(issueKey);
        String issueKeyTestMatcher = new String();
        if (issueKeyTest.find()) {
            issueKeyTestMatcher = issueKeyTest.group(1);
        }
        ProjectSearch.shouldBe(visible, Duration.ofSeconds(30)).setValue(String.valueOf(issueKeyTestMatcher)).pressEnter();
    }

    @Step("Проверяем что задача назначена на меня")
    public static void checkCreatedIssueAssignToMe() {
        checkAssignToME.shouldBe(visible, Duration.ofSeconds(30));
    }

    @Step("Переводим в статус Вработе")
    public static void clickIssueStatusInWork() {
        IssueStatusInWork.shouldBe(visible, Duration.ofSeconds(30)).click();
    }

    @Step("Нажимаем на кнопку бизнес процесс")
    public static void clickIssueStatusWorkFlow() {

        int count = 0;
        do {

            IssueStatusWorkFlow.click();
            count++;
        } while (count < 5 && !IssueFinalizationWindowCheck.isDisplayed());


        IssueFinalizationWindowCheck.click();
    }


    @Step("Нажимаем на кнопку Исполнено")
    public static void clickIssueFinalizationWindowCheckButton() {
        IssueFinalizationWindowCheckButton.shouldBe(visible, Duration.ofSeconds(30)).click();
    }

    @Step("Проверяем статус Закрыто")
    public static void checkIssueStatusClosed(String solvedStatus) {

        String closedStatus;

        int count = 0;
        do {

            closedStatus = checkIssueStatusClosed.getText();
            count++;
        } while (count < 5 && closedStatus != solvedStatus);
        assertEquals(solvedStatus, closedStatus);
    }


}



