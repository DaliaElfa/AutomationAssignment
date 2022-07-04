package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SignInPage;
import base.PageBase;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class CreateNewAccountTest {
    // variables
    private WebDriver driver;
    HomePage HomePageObj;
     SignInPage SignInPageObj;
    RegistrationPage RegisterPageObj;

    @BeforeTest
    public void BeforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        //driver.manage().window().
    }

    @Test
    public void CreateNewAccount()  {
        HomePageObj = new HomePage(driver);
        HomePageObj.SignIn_Click();
        SignInPageObj = new SignInPage(driver);
        SignInPageObj.CreatenewaccountEmail_set("hkjhkj@yahoo.com");
        SignInPageObj.Createanaccount_Click();
        RegisterPageObj = new RegistrationPage(driver);
        RegisterPageObj.CreateAccount("Mr", "mohamed", "Mahmoud", "797979797", "haram", "giza", "Florida", "87654","018873663362","iuuouo");
        boolean logout = driver.findElement(By.className("logout")).isDisplayed();
        Assert.assertEquals(logout,true);
    }
}
