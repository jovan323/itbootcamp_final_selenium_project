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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='status']")));
    }
    //Elemente koji u sebi sadrze tekstove poruke
    public void getElementsWithTextMess(){
    }

    public WebElement getCloseButton(){
        return driver.findElement(By.linkText("Close"));
    }

    //metodu koja ceka da se verify your account dijalog pojavi
    public void waitForAccDialog(){
    }
    // metodu koja vraca zaglavlje iz verify your account dijaloga
    // koji sadrzi tekst IMPORTANT: Verify your account
    public WebElement getHeaderFromAccDialog(){
        return driver.findElement(By.linkText(""));
    }

    // Close dugme iz verify account dijaloga
    public WebElement getCloseButtonFromAccDialog() {
        return driver.findElement(By.linkText(""));
    }
}
