package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SignInPage;
import base.PageBase;
import testdata.LoadProperties;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class CreateNewAccountTest {
    // variables
    private WebDriver driver;
    HomePage HomePageObj;
     SignInPage SignInPageObj;
    RegistrationPage RegisterPageObj;
    String Email = LoadProperties.UserData.getProperty("Email");
    String Gender = LoadProperties.UserData.getProperty("Gender");
    String Fname = LoadProperties.UserData.getProperty("FirstName");
    String Lname = LoadProperties.UserData.getProperty("LastName");
    String PWord = LoadProperties.UserData.getProperty("Password");
    String Address = LoadProperties.UserData.getProperty("Address");
    String City = LoadProperties.UserData.getProperty("City");
    String State = LoadProperties.UserData.getProperty("State");
    String Postalcode = LoadProperties.UserData.getProperty("Postalcode");
    String Mobile = LoadProperties.UserData.getProperty("Mobile");
    String Alias = LoadProperties.UserData.getProperty("Alias");
    @BeforeTest
    public void BeforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        //driver.manage().window().
    }

    @Test(priority = 1)
    public void CreateNewAccount()  {
        HomePageObj = new HomePage(driver);
        HomePageObj.SignIn_Click();
        SignInPageObj = new SignInPage(driver);
        SignInPageObj.CreatenewaccountEmail_set(Email);
        SignInPageObj.Createanaccount_Click();
        RegisterPageObj = new RegistrationPage(driver);
        RegisterPageObj.CreateAccount(Gender, Fname, Lname, PWord, Address, City, State, Postalcode, Mobile,Alias);
        boolean logout = HomePageObj.signout_IsDisplayed();
        Assert.assertEquals(logout,true);
    }

    @Test(priority = 2)
    public void AuthenticateNewUser(){
        HomePageObj = new HomePage(driver);
        HomePageObj.signout_Click();
        HomePageObj.SignIn_Click();
        SignInPageObj = new SignInPage(driver);
        SignInPageObj.Login_Mail_set(Email);
        SignInPageObj.Login_Password_set(PWord);
        SignInPageObj.SubmitLogin_Click();
        boolean logout = HomePageObj.signout_IsDisplayed();
        Assert.assertEquals(logout,true);
    }

    @AfterTest
    public void AfterTest(){
        driver.close();
    }
}
