package pl.babiak.ruslana.test.tests;

import org.testng.annotations.Test;
import pl.babiak.ruslana.test.pages.ProductPage;

public class BuyProductTest extends BaseTest {

    @Test
    public void buyProductTest() {
        new ProductPage(driver).clickOnBddCucumber().addProduct().clickOnViewCart().checkout();
    }
}
