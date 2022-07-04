package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHistoryPage {
    private WebDriver driver;

    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators


    public boolean IsOrderPlaceInHistory(String OrderReferenceId){
        By OrderRecord = By.xpath("//a[contains(text(),'"+OrderReferenceId+"')]");
        return driver.findElement(OrderRecord).isDisplayed();
    }
}
