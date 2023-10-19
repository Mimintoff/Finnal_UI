package steps;

import elements.TaskPageElements;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class TaskPageSteps extends TaskPageElements {

    public static void searchTaskInput(String taskNumber) {
        TaskSearchInput.shouldBe(visible, Duration.ofSeconds(30)).click();
        TaskSearchInput.shouldBe(visible, Duration.ofSeconds(30)).setValue(taskNumber);
    }

    public static void selectTask() {
        TaskChoice.shouldBe(visible, Duration.ofSeconds(20)).click();

    }

    public static String getTaskStatus() {

        return TaskStatus.shouldBe(visible, Duration.ofSeconds(20)).getText();
    }

    public static String getTaskVersion() {

        return TaskVersion.shouldBe(visible, Duration.ofSeconds(20)).getText();
    }
}
