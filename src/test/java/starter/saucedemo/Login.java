package starter.saucedemo;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.ui.InputField;
import net.serenitybdd.screenplay.waits.Wait;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login {

    public static Performable withUsernameAndPassword() {
        return Task.where("{0} logins with username and password",
                Wait.until(WebElementQuestion.the(By.cssSelector("[data-test='username']")), isVisible()),
                Enter.theValue("standard_user").into(InputField.located(By.cssSelector("[data-test='username']"))),
                Enter.theValue("secret_sauce").into(InputField.located(By.cssSelector("[data-test='password']"))),
                Click.on("[data-test='login-button']")
        );
    }
}
