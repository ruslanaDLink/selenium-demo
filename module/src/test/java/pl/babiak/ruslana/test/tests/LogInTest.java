package pl.babiak.ruslana.test.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.babiak.ruslana.test.pages.FieldGenerator;
import pl.babiak.ruslana.test.pages.HomePage;
import pl.babiak.ruslana.test.pages.LoggedUserPage;
import pl.babiak.ruslana.test.pages.MyAccountPage;

public class LogInTest extends BaseTest{

    @Test
    public void logInValidDataTest(){
        HomePage homePage = new HomePage(driver);
        MyAccountPage myAccountPage = homePage.openAccountPage();
        String email = "email@gmail.com";
        String password = "password";

        myAccountPage.validLogIn(email, password);
    }

    @Test
    public void logInInvalidDataTest(){
        //given
        HomePage homePage = new HomePage(driver);
        MyAccountPage myAccountPage = homePage.openAccountPage();
        FieldGenerator fieldGenerator = new FieldGenerator();
        String email = fieldGenerator.generateEmail();
        String password = fieldGenerator.generatePassword();
        LoggedUserPage loggedUser = new LoggedUserPage(driver);

        //when
        myAccountPage.invalidLogIn(email, password);
        WebElement error = loggedUser.getError();

        //then
        Assert.assertTrue(error.getText().contains(": Incorrect username or password."));
    }
}
