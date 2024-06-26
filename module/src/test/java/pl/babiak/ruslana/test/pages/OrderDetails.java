package pl.babiak.ruslana.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderDetails {
    private WebDriver driver;


    @FindBy(xpath = "//div[@class='woocommerce-order']//p")
    private WebElement orderNotice;


    @FindBy(xpath = "//td[contains(@class, 'product-name')]")
    private WebElement productName;


    public OrderDetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getOrderNotice() {
        return orderNotice;
    }

    public WebElement getProductName() {
        return productName;
    }
}
