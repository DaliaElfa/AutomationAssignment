package pages;

import net.jodah.failsafe.internal.util.DelegatingExecutorService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class PaymentPage {

    private WebDriver driver;



    //Locators
    By PayByBankWire_link = By.xpath("//a[@title='Pay by bank wire']");
    By ConfirmMyOrder_btn = By.xpath("//span[contains(text(),'I confirm my order')]");
    By OrderConfirmationTitle = By.xpath("//h1[contains(text(),'Order confirmation')]");
    By OrderDetailsMsg = By.xpath("//div[@class='box']");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean PayByBankWire_IsDisplayed(){
        return driver.findElement(PayByBankWire_link).isDisplayed();
    }
    public void PayByBankWire_Click() {
        driver.findElement(PayByBankWire_link).click();
    }
    public void ConfirmMyOrder_Click() {
        driver.findElement(ConfirmMyOrder_btn).click();
    }
    public boolean OrderConfirmation_IsDisplayed(){
        return driver.findElement(OrderConfirmationTitle).isDisplayed();
    }
    public String GetOrderreferenceId(){
        String msg = driver.findElement(OrderDetailsMsg).getText();
        String [] words = msg. split(" ");
        int x =0;
        String referenceid = null;
        for (String word : words) {
              if (x==1)
                   referenceid = word;
              if (Objects.equals(word, "reference"))
                  x = 1;
              else
                  x=0;
            }
        return referenceid;
    }
}
