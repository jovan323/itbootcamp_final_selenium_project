package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasePage{
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void waitForPopUp(){
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[contains(@class, 'success')]")));
    }
    public void waitForMessagePopUp(){
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@role='status']//li")));
    }

    public WebElement getMessage() {
        return driver.findElement
                (By.xpath("//div[contains(@class, 'succes')]"));
    }
    public WebElement getMessageText() {
        return driver.findElement
                (By.xpath("//div[contains(@class, 'succes')]/div[@role='status']"));
    }
    public WebElement getMessageTextLog(){
        return driver.findElement
                (By.xpath("//*[@role='status']//li"));
    }
    public WebElement getCloseButton(){
        return driver.findElement
                (By.linkText("Close"));
    }

    public void waitVerifyAccDialog(){
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@class='v-card v-sheet theme--light']")));
    }
    public WebElement getHeaderFromAccDialog(){
        return driver.findElement
                (By.xpath("//*[contains(@class, 'v-card__title')]"));
    }
    public WebElement getCloseButtonFromAccDialog() {
        return driver.findElement
                (By.xpath("//span[text()='Close']"));
    }
}
