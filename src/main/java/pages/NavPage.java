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
        return driver.findElement(By.xpath("//span[text()=' Home ']"));
    }
    public WebElement getAboutLink(){
        return driver.findElement(By.xpath("//span[text()=' About ']"));
    }
    public WebElement getLogInButton(){
        return driver.findElement(By.xpath("//span[text()=' Login ']"));
    }
    public WebElement getSignUpButton(){
        return driver.findElement(By.xpath("//span[text()=' Sign Up ']"));
    }
    public WebElement getMyProfileLink(){
        return driver.findElement(By.xpath("//span[text()=' My Profile ']"));
    }
    public WebElement getLanguageButton(){
        return driver.findElement(By.xpath("//button[contains(@class, 'btnLocaleActivation ')]"));
    }
    public WebElement getEnButton(){
        return driver.findElement(By.xpath("//*[@class='flag f-gb small-flag']"));
    }
    public WebElement getEsButton(){
        return driver.findElement
                (By.xpath("//*[@class='flag f-es small-flag']"));
    }
    public WebElement getFrButton(){
        return driver.findElement
                (By.xpath("//*[@class='flag f-fr small-flag']"));
    }
    public WebElement getCnButton(){
        return driver.findElement
                (By.xpath("//*[@class='flag f-cn small-flag']"));
    }
    public WebElement getUAButton(){
        return driver.findElement
                (By.xpath("//*[@class='flag f-ua small-flag']"));
    }
    public WebElement getAdminLink(){
        return driver.findElement(By.xpath("//span[text()=' Admin ']"));
    }
    public WebElement getAdminCitiesLink(){
        return driver.findElement(By.linkText("Cities"));
    }
    public WebElement getAdminUsersLink(){
        return driver.findElement(By.linkText("Users"));
    }

    public WebElement getLogOutButton(){
        return driver.findElement
                (By.xpath("//span[text()=' Logout ']"));
    }
    public WebElement getHeaderForLocale(){
        return driver.findElement(By.xpath("//h1"));
    }
}
