package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import java.util.concurrent.TimeUnit;

public class OrderBlouseTest {
    // variables
    private WebDriver driver;

    By Blouses = By.xpath("//span[contains(text(),'Blouses')]");

    @BeforeTest
    public void BeforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1024,768));
        //driver.manage().window().
    }

    @Test(priority = 1)
    public void SelectBlouseCategory(){
        HomePage HomePageObj = new HomePage(driver);
        HomePageObj.WomenCategory_Click();
        HomePageObj.Blouses_Click();
        boolean blouses_displayed = driver.findElement(Blouses).isDisplayed();
        Assert.assertEquals(blouses_displayed,true);
    }
    @Test(priority = 2)
    public void Selectresultedproduct(){
        BlousesPage BlousesPageObj = new BlousesPage(driver);
        BlousesPageObj.SelectBlouseitem("Blouse");
    }
    @Test(priority = 3)
    public void FollowCheckoutProcedure(){
        AddToCartPage AddToCartObj = new AddToCartPage(driver);
        AddToCartObj.AddToCart_Click();
        AddToCartObj.ProceedToCheckOut_Click();
        ShoppingCartPage ShoppingCartObj = new ShoppingCartPage(driver);
        ShoppingCartObj.ProceedToCheckOut_summary_Click();
        //to be check sign in or not then do if condition
        HomePage HomePageObj = new HomePage(driver);
        SignInPage SignInObj = new SignInPage(driver);
        if(!HomePageObj.signout_IsDisplayed())
        {
        SignInObj.Login_Mail_set("Dalia_123@gmail.com");
        SignInObj.Login_Password_set("123456");
        SignInObj.SubmitLogin_Click();}
        ShoppingCartObj.ProceedToCheckOut_Address_Click();
        ShoppingCartObj.TermsOfService_Check();
        ShoppingCartObj.ProceedToCheckOut_Carrier_Click();
        PaymentPage PaymentObj = new PaymentPage(driver);
        PaymentObj.PayByBankWire_Click();
        PaymentObj.ConfirmMyOrder_Click();

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
