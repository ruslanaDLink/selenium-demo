package pl.babiak.ruslana.test.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.babiak.ruslana.test.pages.HomePage;
import pl.babiak.ruslana.test.pages.OrderDetails;
import pl.babiak.ruslana.test.pages.ProductPage;

import java.time.Duration;

public class FillingAddressDetailsTest extends BaseTest {

    @Test
    public void fillAddressFields() {
        //given
        new HomePage(driver).openShopPage();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //when
        OrderDetails orderDetails = new ProductPage(driver)
                .clickOnBddCucumber()
                .addProduct()
                .clickOnViewCart()
                .checkout()
                .typeAddressDetails(
                        "Lila",
                        "Rose",
                        "Australia",
                        "Valley 397",
                        "4",
                        "Victoria",
                        "89-771",
                        "Melbourne",
                        "+1728173931",
                        "lilirosie@gmail.com");

        //then
        Assert.assertEquals(orderDetails.getOrderNotice().getText(), "Thank you. Your order has been received.");
        Assert.assertEquals(orderDetails.getProductName().getText(), "BDD Cucumber × 1");
    }

    @Test
    public void applyCouponTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        new ProductPage(driver)
                .clickOnBddCucumber()
                .addProduct()
                .clickOnViewCart()
                .checkout()
                .applyCoupon("Coupon Selenium 6729376");

    }
}
