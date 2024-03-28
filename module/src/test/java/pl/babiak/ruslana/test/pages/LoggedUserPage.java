package pl.babiak.ruslana.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedUserPage {
    private WebDriver driver;

    @FindBy(xpath = "//h1[@class='entry-title']")
    private WebElement entryTitle;

    @FindBy(linkText = "Dashboard")
    private WebElement dashboard;

    @FindBy(xpath = "//ul[@class='woocommerce-error']//li")
    private WebElement error;


    public LoggedUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getEntryTitle() {
        return entryTitle;
    }

    public WebElement getDashboard() {
        return dashboard;
    }

    public WebElement getError() {
        return error;
    }


}
