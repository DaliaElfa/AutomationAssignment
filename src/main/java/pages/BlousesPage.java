package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlousesPage {

    private  WebDriver driver;

    public BlousesPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    //By Blosesitems_Blouses1 = By.xpath("//h5[@itemprop='name']//a[@title='Blouse']");

    //Methods

    public void SelectBlouseitem(String BlouseName){
        By Blosesitems_Blouses1 = By.xpath("//h5[@itemprop='name']//a[@title='"+BlouseName+"']");
        driver.findElement(Blosesitems_Blouses1).click();
    }

}
