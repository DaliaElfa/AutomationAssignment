package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    private WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    By ProceedToCheckOut_summary_btn = By.xpath("//P[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']");
    By ProceedToCheckOut_Address_btn = By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]");
    By ProceedToCheckOut_Carrier_btn = By.xpath("//button[@name='processCarrier']");
    By TermsOfService_chk = By.id("uniform-cgv");
    public void ProceedToCheckOut_summary_Click() {
        driver.findElement(ProceedToCheckOut_summary_btn).click();
    }
    public void ProceedToCheckOut_Address_Click() {
        driver.findElement(ProceedToCheckOut_Address_btn).click();
    }
    public void ProceedToCheckOut_Carrier_Click() {
        driver.findElement(ProceedToCheckOut_Carrier_btn).click();
    }
    public void TermsOfService_Check() {
        driver.findElement(TermsOfService_chk).click();
    }
}
