package pl.babiak.ruslana.test.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.babiak.ruslana.test.pages.FieldGenerator;
import pl.babiak.ruslana.test.pages.HomePage;
import pl.babiak.ruslana.test.pages.LoggedUserPage;

import java.time.Duration;

public class RegisterUserTest extends BaseTest {

    @Test
    public void register() {
        //given
        HomePage homePage = new HomePage(driver);
        FieldGenerator fieldGenerator = new FieldGenerator();
        String email = fieldGenerator.generateEmail();
        String password = fieldGenerator.generatePassword();

        LoggedUserPage loggedUser = new LoggedUserPage(driver);

        //when
        homePage.openAccountPage().validRegistration(email, password);
        WebElement entryTitle = loggedUser.getEntryTitle();

        //then
        Assert.assertNotNull(email, "Enter email.");
        Assert.assertNotNull(password, "Enter password.");
        Assert.assertNotNull(entryTitle);
        Assert.assertTrue(entryTitle.isDisplayed());
    }

    @Test
    public void registerUserWithExistingEmailInDatabase() {
        //given
        HomePage homePage = new HomePage(driver);
        String email = "dolores1562@gmail.com";
        String password = "selenium3798!!!";

        LoggedUserPage loggedUser = new LoggedUserPage(driver);

        //when
        homePage.openAccountPage().invalidRegistration(email, password);
        WebElement error = loggedUser.getError();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //then
        Assert.assertTrue(error.getText().contains(" An account is already registered with your email address. Please log in."));

    }
}