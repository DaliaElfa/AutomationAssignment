package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage {
    private WebDriver driver;



    //Locators

    By AddToCart_btn = By.id("add_to_cart");
    By ProceedToCheckOut_btn = By.xpath("//a[@title='Proceed to checkout']");

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }
    //Methods
    public boolean AddToCart_IsDisplayed(){
        return driver.findElement(AddToCart_btn).isDisplayed();
    }
    public void AddToCart_Click(){
        driver.findElement(AddToCart_btn).click();
    }

    public void ProceedToCheckOut_Click(){
        driver.findElement(ProceedToCheckOut_btn).click();
    }
}
