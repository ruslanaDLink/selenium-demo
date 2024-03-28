package pl.babiak.ruslana.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private WebDriver driver;

    @FindBy(name = "add-to-cart")
    private WebElement addProductButton;

    @FindBy(xpath = "//h2[text()='BDD Cucumber']")
    private WebElement bddProduct;

    @FindBy(xpath = "//div[@class='woocommerce-message']//a[text()='View cart']")
    private WebElement viewCart;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductPage addProduct() {
        addProductButton.click();
        return this;
    }

    public CartPage clickOnViewCart() {
        viewCart.click();
        return new CartPage(driver);
    }

    public ProductPage clickOnBddCucumber() {
        bddProduct.click();
        return new ProductPage(driver);
    }
}
