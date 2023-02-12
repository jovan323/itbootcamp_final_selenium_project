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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'success')]")));
    }
    public void waitForMessagePopUp(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='status']//li")));
    }
    public WebElement getElementsWithTextMessage(){
        return driver.findElement
                (By.xpath("//*[@role='status']//li"));
    }
    public WebElement getEditCreateCityMessage(){
        return driver.findElement
                (By.xpath("//*[@class='v-snack__wrapper v-sheet theme--dark success']/div"));
    }
    public WebElement getCloseButton(){
        return driver.findElement(By.linkText("Close"));
    }

    public void waitVerifyAccDialog(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='v-card v-sheet theme--light']")));
    }
    public WebElement getHeaderFromAccDialog(){
        return driver.findElement(By.xpath("//*[contains(@class, 'v-card__title')]"));
    }
    public WebElement getCloseButtonFromAccDialog() {
        return driver.findElement(By.xpath("//span[text()='Close']"));
    }
}
