package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ProjectPageElements {
    public static SelenideElement ProjectLink = $(byXpath("//a[@id='browse_link']"));
    public static SelenideElement ProjectChoice = $(byXpath("//a[@id='admin_main_proj_link_lnk']"));

    public static SelenideElement ProjectSearch = $(byXpath("//input[@id='quickSearchInput']"));
    public static SelenideElement ProjectCount = $(byXpath("//div[@class='showing']//span"));


}







