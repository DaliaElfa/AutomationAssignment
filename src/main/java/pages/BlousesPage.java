package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlousesPage {
    private  WebDriver driver;
    //Locators
    By Blousesitems_Blouses = By.xpath("//h5[@itemprop='name']//a[@title='Blouse']");

    By Blouses = By.xpath("//span[contains(text(),'Blouses')]");

    public BlousesPage(WebDriver driver) {
        this.driver = driver;
    }

    //Methods

    public boolean CheckCategoryNameIsBlouses()
    {
        return driver.findElement(Blouses).isDisplayed();
    }
    public void SelectBlouseitem(){
       // By Blosesitems_Blouses = By.xpath("//h5[@itemprop='name']//a[@title='"+BlouseName+"']");
        driver.findElement(Blousesitems_Blouses).click();
    }
}
