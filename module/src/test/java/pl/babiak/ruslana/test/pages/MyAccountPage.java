package pl.babiak.ruslana.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    private WebDriver driver;

    @FindBy(id = "reg_email")
    private WebElement emailInput;

    @FindBy(id = "reg_password")
    private WebElement passwordInput;

    @FindBy(name = "register")
    private WebElement registerButton;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordLogin;

    @FindBy(name = "login")
    private WebElement loginButton;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void signUp(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        registerButton.click();
    }

    public LoggedUserPage validRegistration(String email, String password) {
        signUp(email, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage invalidRegistration(String email, String password) {
        signUp(email, password);
        return this;
    }

    public LoggedUserPage validLogIn(String username, String password){
        logIn(username, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage invalidLogIn(String username, String password){
        logIn(username, password);
        return this;
    }

    private void logIn(String username, String password){
        usernameInput.sendKeys(username);
        passwordLogin.sendKeys(password);
        loginButton.click();
    }
}
