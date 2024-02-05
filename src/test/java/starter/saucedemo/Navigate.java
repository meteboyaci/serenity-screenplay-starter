package starter.saucedemo;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Navigate {
    public static Performable toTheHomePage() {
        return Open.url("https://www.saucedemo.com/");
    }

    public static Performable toShoppingChart() {
        return Task.where("{0} navigates to shopping chart",
                Click.on(By.xpath("//a[@class='shopping_cart_link']")).then(
                        Wait.until(WebElementQuestion.the(By.cssSelector(".cart_list")), isVisible())
                )
                );
    }
}
