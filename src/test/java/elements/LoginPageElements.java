package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPageElements {
    public static SelenideElement usernameField = $(byXpath("//input[@id='login-form-username']"));
    public static SelenideElement passwordField = $(byXpath("//input[@id='login-form-password']"));
    public static SelenideElement loginButton = $(byXpath("//input[@id='login']"));


}