package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    By Mrs_gender_radio = By.id("id_gender2");
    By Mr_gender_radio = By.id("id_gender1");
    By firstname_txt = By.id("customer_firstname");
    By lastname_txt = By.id("customer_lastname");
    By Password_txt = By.xpath("//input[@type=\"password\"]");
    By Date_of_birth_Days_LST = By.id("days");
    By Date_of_birth_Months_LST = By.id("months");
    By Date_of_birth_Years_LST = By.id("years");
    By Newsletter_Chk = By.id("uniform-newsletter");
    By Addressfirstname_txt = By.id("firstname");
    By Addresslastname_txt = By.id("lastname");
    By Address_txt = By.id("address1");
    By City_txt = By.id("city");
    By State_lst = By.id("id_state");
    By Postalcode_txt = By.id("postcode");
    By Countrylst = By.id("id_country");
    By Homephone_txt = By.id("phone");
    By Mobilephone_txt = By.id("phone_mobile");
    By alias_txt = By.id("alias");
    By Register_btn = By.id("submitAccount");
    By SignOut_btn = By.className("logout");

    public void CreateAccount(String Gender, String firstname, String lastname, String password, String address, String city, String State, String postalcode, String mobile, String Alias) {
        if (Gender == "Mr") {
            driver.findElement(Mr_gender_radio).click();
        }
        if (Gender == "Mrs") {
            driver.findElement(Mrs_gender_radio).click();
        }
        driver.findElement(firstname_txt).sendKeys(firstname);
        driver.findElement(lastname_txt).sendKeys(lastname);
        driver.findElement(Password_txt).sendKeys(password);
        //to be select the date of birth
        driver.findElement(Address_txt).sendKeys(address);
        driver.findElement(City_txt).sendKeys(city);
        Select statevalue = new Select(driver.findElement(State_lst));
        statevalue.selectByVisibleText(State);
        driver.findElement(Postalcode_txt).sendKeys(postalcode);
        driver.findElement(Mobilephone_txt).sendKeys(mobile);
        driver.findElement(alias_txt).clear();
        driver.findElement(alias_txt).sendKeys(Alias);
        driver.findElement(Register_btn).click();

    }
}