package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage{
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getHomeLink(){
        return driver.findElement(By.linkText("Home"));
    }
    public WebElement getAboutLink(){
        return driver.findElement(By.linkText("About"));
    }
    public WebElement getMyProfileLink(){
        return driver.findElement(By.linkText("My Profile"));
    }
    public WebElement getAdminLink(){
        return driver.findElement(By.linkText("Admin"));
    }
    public WebElement getAdminCitiesLink(){
        return driver.findElement(By.linkText("Cities"));
    }
    public WebElement getAdminUsersLink(){
        return driver.findElement(By.linkText("Users"));
    }
    public WebElement getSignUpButton(){
        return driver.findElement(By.linkText("Sign Up"));
    }
    public WebElement getLogInButton(){
        return driver.findElement(By.linkText("Login"));
    }
    public WebElement getLogOutButton(){
        return driver.findElement(By.linkText("Logout"));
    }
    public WebElement getLanguageButton(){
        return driver.findElement(By.xpath("//button[contains(@class, 'btnLocaleActivation ')]"));
    }
    public WebElement getEnButton(){
        return driver.findElement(By.linkText("EN"));
    }
    public WebElement getEsButton(){
        return driver.findElement(By.linkText("ES"));
    }
    public WebElement getFrButton(){
        return driver.findElement(By.linkText("FR"));
    }
    public WebElement getCnButton(){
        return driver.findElement(By.linkText("Logout"));
    }
    public WebElement getUAButton(){
        return driver.findElement(By.linkText("UA"));
    }
}
