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
import testdata.LoadProperties;

import java.util.concurrent.TimeUnit;

public class FullScenarioTest {
    private WebDriver driver;
    HomePage HomePageObj;
    SignInPage SignInPageObj;
    RegistrationPage RegisterPageObj;
    BlousesPage BlousesPageObj;
    AddToCartPage AddToCartObj;
    ShoppingCartPage ShoppingCartObj;
    PaymentPage PaymentObj;
    OrderHistoryPage OrderHistoryObj;
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
        RegisterPageObj.CreateAccount(Gender,Fname,Lname,PWord,Address,City,State,Postalcode,Mobile,Alias);
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
    @Test(priority = 3)
    public void SelectBlouseCategory(){
        HomePageObj = new HomePage(driver);
        HomePageObj.WomenCategory_Click();
        HomePageObj.Blouses_Click();
        BlousesPageObj = new BlousesPage(driver);
        boolean blouses_displayed = BlousesPageObj.CheckCategoryNameIsBlouses();
        Assert.assertEquals(blouses_displayed,true);
    }
    @Test(priority = 4)
    public void Selectresultedproduct(){
        BlousesPageObj = new BlousesPage(driver);
        BlousesPageObj.SelectBlouseitem();
        AddToCartObj = new AddToCartPage(driver);
        boolean AddToCart_Displayed = AddToCartObj.AddToCart_IsDisplayed();
        Assert.assertEquals(AddToCart_Displayed,true);
    }
    @Test(priority = 5)
    public void FollowCheckoutProcedure() {
        AddToCartObj = new AddToCartPage(driver);
        AddToCartObj.AddToCart_Click();
        AddToCartObj.ProceedToCheckOut_Click();
        ShoppingCartObj = new ShoppingCartPage(driver);
        ShoppingCartObj.ProceedToCheckOut_summary_Click();
        ShoppingCartObj.ProceedToCheckOut_Address_Click();
        ShoppingCartObj.TermsOfService_Check();
        ShoppingCartObj.ProceedToCheckOut_Carrier_Click();
        PaymentObj = new PaymentPage(driver);
        boolean Payment_displayed = PaymentObj.PayByBankWire_IsDisplayed();
        Assert.assertEquals(Payment_displayed,true);
    }
    @Test(priority = 6)
    public void Confirmorderbyselectingbankwireoption() {
        PaymentObj = new PaymentPage(driver);
        PaymentObj.PayByBankWire_Click();
        PaymentObj.ConfirmMyOrder_Click();
        boolean OrderConfirmed =  PaymentObj.OrderConfirmation_IsDisplayed();
        Assert.assertEquals(OrderConfirmed,true);
    }
    @Test(priority = 7)
    public void Validateorderwasplacedfromorderhistorypage() {
        PaymentObj = new PaymentPage(driver);
        String ReferenceId = PaymentObj.GetOrderreferenceId();
        HomePageObj.MyOrders_Click();
         OrderHistoryObj = new OrderHistoryPage(driver);
        boolean OrderPlaced = OrderHistoryObj.IsOrderPlaceInHistory(ReferenceId);
        Assert.assertEquals(OrderPlaced,true);
    }

    @AfterTest
    public void AfterTest(){
        driver.close();
    }
}
