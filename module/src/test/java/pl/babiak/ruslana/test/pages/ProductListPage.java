package pl.babiak.ruslana.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pl.babiak.ruslana.test.utils.SeleniumHandler;

public class ProductListPage {
    private WebDriver driver;

    public ProductListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductPage openProduct(String name) {
        By product = By.xpath("//h2[text()='" + name + "']");
        SeleniumHandler.waitToBeClickable(product, driver);
        driver.findElement(product).click();
        return new ProductPage(driver);
    }
}
