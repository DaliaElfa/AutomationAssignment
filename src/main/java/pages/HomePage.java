package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends PageBase {
    public WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    //locators
    By Signin_BTN =  By.xpath("//a[@class='login']");
    By signout_btn = By.xpath("//a[@title='Log me out']");
    By WomenCategory_lst = By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//a[@title='Women']");
    By Blouses_btn = By.xpath("//a[@title='Blouses']");
    By MyOrders_btn = By.xpath("//a[@title='My orders']");
    //Methods
    public void SignIn_Click() {
       sleep(1000);
        driver.findElement(Signin_BTN).click();
    }
    public void signout_Click() {
        sleep(1000);
        driver.findElement(signout_btn).click();
    }
    public boolean signout_IsDisplayed() {
        int x = driver.findElements(signout_btn).size();
        if (x == 0) {
            return false;
        } else
            return true;
    }
public void WomenCategory_Click() {
        sleep(1000);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(WomenCategory_lst)).perform();


    }
    public void Blouses_Click() {
        driver.findElement(Blouses_btn).click();
    }
    public void MyOrders_Click() {

        driver.findElement(MyOrders_btn).click();
    }
}
