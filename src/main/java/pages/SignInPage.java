package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends PageBase {
    private WebDriver driver;
    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators
    By Create_an_account_Email_TXT = By.id("email_create");
    By Create_an_account_BTN = By.id("SubmitCreate");

    By Login_Mail_txt = By.id("email");
    By Login_Password_txt = By.id("passwd");
    By SubmitLogin_btn = By.id("SubmitLogin");
    //Methods
    public void Createanaccount_Click() {
        sleep(1000);
        driver.findElement(Create_an_account_BTN).click();
    }
    public void CreatenewaccountEmail_set(String Mail) {
        sleep(1000);
        driver.findElement( Create_an_account_Email_TXT).sendKeys(Mail);
    }
    public void Login_Mail_set(String Mail) {
        sleep(1000);
        driver.findElement( Login_Mail_txt).sendKeys(Mail);
    }
    public void Login_Password_set(String Passwd) {

        driver.findElement(Login_Password_txt).sendKeys(Passwd);
    }
    public void SubmitLogin_Click() {
        sleep(1000);
        driver.findElement(SubmitLogin_btn).click();
    }
}
