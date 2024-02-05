package starter.saucedemo;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import net.serenitybdd.screenplay.annotations.CastMember;

@ExtendWith(SerenityJUnit5Extension.class)
class AddingItemsTestSuite {

    @CastMember(name = "The customer")
    Actor theCustomer;

    @Test
    void selectTheHighestPricedItem() {
        theCustomer.attemptsTo(
                Navigate.toTheHomePage(),
                Login.withUsernameAndPassword(),
                Select.waitForInventory()
        );
        theCustomer.attemptsTo(
                Select.theHighestPriceItem().then(
                        Navigate.toShoppingChart()
                ),
                Ensure.that(ShoppingChart.firstItemHeading()).isEqualTo("Sauce Labs Fleece Jacket")
        );
    }
}
