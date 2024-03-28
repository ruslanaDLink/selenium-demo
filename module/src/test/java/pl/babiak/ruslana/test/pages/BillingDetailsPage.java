package pl.babiak.ruslana.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class BillingDetailsPage {
    public WebDriver driver;

    @FindBy(id = "billing_first_name")
    private WebElement firstNameInput;

    @FindBy(id = "billing_last_name")
    private WebElement lastNameInput;

    @FindBy(id = "billing_country")
    private WebElement countryButton;

    @FindBy(id = "billing_address_1")
    private WebElement streetInput;

    @FindBy(id = "billing_address_2")
    private WebElement apartmentInput;

    @FindBy(id = "billing_state")
    private WebElement stateButton;

    @FindBy(id = "billing_postcode")
    private WebElement postcodeInput;

    @FindBy(id = "billing_city")
    private WebElement cityInput;

    @FindBy(id = "billing_phone")
    private WebElement phoneInput;

    @FindBy(id = "billing_email")
    private WebElement emailInput;

    @FindBy(name = "woocommerce_checkout_place_order")
    private WebElement orderButton;

    @FindBy(xpath = "//a[text()='Click here to enter your code']")
    private WebElement couponButton;

    @FindBy(id = "coupon_code")
    private WebElement couponCodeField;

    @FindBy(name = "apply_coupon")
    private WebElement applyCouponButton;


    public BillingDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public OrderDetails typeAddressDetails(String firstName, String lastName, String country, String street, String apartment, String state, String zipCode, String city, String phone, String email) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        Select selectCountry = new Select(countryButton);
        selectCountry.selectByVisibleText(country);
        Select selectState = new Select(stateButton);
        selectState.selectByVisibleText(state);
        streetInput.sendKeys(street);
        apartmentInput.sendKeys(apartment);
        postcodeInput.sendKeys(zipCode);
        cityInput.sendKeys(city);
        phoneInput.sendKeys(phone);
        emailInput.sendKeys(email);

        orderButton.click();

        return new OrderDetails(driver);
    }

    public OrderDetails applyCoupon(String coupon) {
        couponButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        couponCodeField.sendKeys(coupon);
        applyCouponButton.click();
        return new OrderDetails(driver);
    }
}
