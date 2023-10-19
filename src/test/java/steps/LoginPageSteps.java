package steps;

import elements.LoginPageElements;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;


public class LoginPageSteps extends LoginPageElements {


    public static void enterUsername(String username) {
        usernameField.shouldBe(visible, Duration.ofSeconds(30)).setValue(username);//"AT10"

    }

    public static void enterPassword(String password) {
        passwordField.shouldBe(visible, Duration.ofSeconds(30)).setValue(password);//"Qwerty123"

    }

    public static void clickLoginButton() {
        loginButton.shouldBe(visible, Duration.ofSeconds(30)).click();
    }


}
