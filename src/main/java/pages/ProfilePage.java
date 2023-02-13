package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getEmailBox(){
        return driver.findElement(By.id("email"));
    }
    public WebElement getNameBox(){
        return driver.findElement(By.id("name"));
    }
    public WebElement getPhoneBox(){
        return driver.findElement(By.id("phone"));
    }
    public WebElement getCityBox(){
        return driver.findElement(By.id("city"));
    }
    public WebElement getCountryBox(){
        return driver.findElement(By.id("country"));
    }
    public WebElement getTwitterBox(){
        return driver.findElement(By.id("urlTwitter"));
    }
    public WebElement getGithubBox(){
        return driver.findElement(By.id("urlGitHub"));
    }
    public WebElement getSaveButton(){
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }
}
