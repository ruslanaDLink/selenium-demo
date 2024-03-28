package pl.babiak.ruslana.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//span[text()='My account']")
    private WebElement accountButton;

    @FindBy(xpath = "//span[text()='Shop']")
    private WebElement shopButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MyAccountPage openAccountPage() {
        accountButton.click();
        return new MyAccountPage(driver);
    }

    public ProductListPage openShopPage() {
        shopButton.click();
        return new ProductListPage(driver);
    }
}
