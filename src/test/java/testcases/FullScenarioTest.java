package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class FullScenarioTest {
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

    @Test(priority = 1)
    public void CreateNewAccount()  {
        HomePageObj = new HomePage(driver);
        HomePageObj.SignIn_Click();
        SignInPageObj = new SignInPage(driver);
        SignInPageObj.CreatenewaccountEmail_set("toto@yahoo.com");
        SignInPageObj.Createanaccount_Click();
        RegisterPageObj = new RegistrationPage(driver);
        RegisterPageObj.CreateAccount("Mr", "mohamed", "Mahmoud", "797979797", "haram", "giza", "Florida", "87654","018873663362","iuuouo");
        boolean logout = driver.findElement(By.className("logout")).isDisplayed();
        Assert.assertEquals(logout,true);
    }

    @Test(priority = 2)
    public void AuthenticateNewUser(){
        HomePageObj = new HomePage(driver);
        HomePageObj.signout_Click();
        HomePageObj.SignIn_Click();
        SignInPageObj = new SignInPage(driver);
        SignInPageObj.Login_Mail_set("toto@yahoo.com");
        SignInPageObj.Login_Password_set("797979797");
        SignInPageObj.SubmitLogin_Click();
        boolean logout = driver.findElement(By.className("logout")).isDisplayed();
        Assert.assertEquals(logout,true);
    }
    @Test(priority = 3)
    public void SelectBlouseCategory(){
        HomePage HomePageObj = new HomePage(driver);
        HomePageObj.WomenCategory_Click();
        HomePageObj.Blouses_Click();
        BlousesPage BlousesPageObj = new BlousesPage(driver);
        boolean blouses_displayed = BlousesPageObj.CheckCategoryNameIsBlouses();
        Assert.assertEquals(blouses_displayed,true);
    }
    @Test(priority = 4)
    public void Selectresultedproduct(){
        BlousesPage BlousesPageObj = new BlousesPage(driver);
        BlousesPageObj.SelectBlouseitem();
    }
    @Test(priority = 5)
    public void FollowCheckoutProcedure() {
        AddToCartPage AddToCartObj = new AddToCartPage(driver);
        AddToCartObj.AddToCart_Click();
        AddToCartObj.ProceedToCheckOut_Click();
        ShoppingCartPage ShoppingCartObj = new ShoppingCartPage(driver);
        ShoppingCartObj.ProceedToCheckOut_summary_Click();
        ShoppingCartObj.ProceedToCheckOut_Address_Click();
        ShoppingCartObj.TermsOfService_Check();
        ShoppingCartObj.ProceedToCheckOut_Carrier_Click();
    }
    @Test(priority = 6)
    public void Confirmorderbyselectingbankwireoption() {
        PaymentPage PaymentObj = new PaymentPage(driver);
        PaymentObj.PayByBankWire_Click();
        PaymentObj.ConfirmMyOrder_Click();
    }
    @Test(priority = 7)
    public void Validateorderwasplacedfromorderhistorypage() {
        PaymentPage PaymentObj = new PaymentPage(driver);
        String ReferenceId = PaymentObj.GetOrderreferenceId();
        HomePageObj.MyOrders_Click();
        OrderHistoryPage OrderHistoryObj = new OrderHistoryPage(driver);
        boolean flag = OrderHistoryObj.IsOrderPlaceInHistory(ReferenceId);
        Assert.assertEquals(flag,true);
    }


    @AfterTest
    public void AfterTest(){
        driver.close();
    }
}
