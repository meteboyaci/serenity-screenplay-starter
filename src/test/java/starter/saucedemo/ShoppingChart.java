package starter.saucedemo;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ShoppingChart {
    public static Question<String> firstItemHeading() {
        return Text.of(".inventory_item_name");
    }
}
