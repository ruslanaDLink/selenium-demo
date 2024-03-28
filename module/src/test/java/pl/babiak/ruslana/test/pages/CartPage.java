package pl.babiak.ruslana.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[text()='Remove this item']")
    private WebElement removeElementButton;

    @FindBy(linkText = "Proceed to checkout")
    private WebElement checkout;

    @FindBy(name = "Update cart")
    private WebElement updateCart;


    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void removeProductFromCart(){
        removeElementButton.click();
    }

    public BillingDetailsPage checkout(){
        checkout.click();
        return new BillingDetailsPage(driver);
    }

    public void updateCart(){
        updateCart.click();
    }
}
