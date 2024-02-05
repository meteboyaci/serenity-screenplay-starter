package starter.saucedemo;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Select {

    public static Performable waitForInventory() {
        return Task.where("{0} selects the highest price item",
                Wait.until(WebElementQuestion.the(By.cssSelector("#inventory_container")), isVisible())
        );
    }

    public static Performable theHighestPriceItem() {
        int index = findTheHighestValue();
        return Task.where("{0} selects the highest price item",
                Click.on(By.xpath("//div[@class='inventory_item'][" + index + "]/div[2]/div[2]/button"))
        );
    }

    private static int findTheHighestValue() {
        double productPrice = 0.0;
        int priceIndex = 0;
        List<WebElement> allPrices = getDriver().findElements(By.cssSelector("div[class='inventory_item_price']"));

        for (int i = 0; i < allPrices.size(); i++) {
            double price = Double.parseDouble(allPrices.get(i).getText().substring(1));
            if (productPrice < price) {
                productPrice = price;
                priceIndex = i + 1;
            }
        }
        return priceIndex;
    }


}
