package steps;

import elements.ProjectPageElements;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class ProjectPageSteps extends ProjectPageElements {

    public static void clickProjectLink() {
        ProjectLink.shouldBe(visible, Duration.ofSeconds(30)).click();
    }

    public static void clickProjectChoice() {
        ProjectChoice.shouldBe(visible, Duration.ofSeconds(30)).click();
    }

    public static void clickProjectSearch() {
        ProjectSearch.shouldBe(visible, Duration.ofSeconds(30)).pressEnter();
    }


    public static String projectCountGeneral() {
        String str = ProjectCount.getText();
        String[] parts = str.split("из");
        String lastPart = parts[parts.length - 1].trim();
        int lastNumber = Integer.parseInt(lastPart);
        System.out.println("Общее количество задач: " + lastNumber);
        return str;

    }


}
