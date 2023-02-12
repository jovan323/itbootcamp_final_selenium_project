package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasePage{
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getNewItemButton () {
        return driver.findElement
                (By.xpath("//span[contains(text(),' New Item ')]"));
    }
    public WebElement getSearchCityBox() {
        return driver.findElement(By.xpath("//input[@id='search']"));
    }
    public WebElement getInputCityBox(){
        return driver.findElement(By.id("name"));
    }
    public WebElement waitForEditDialog (){
        return wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@class='v-card v-sheet theme--light']")));
    }
    public WebElement waitForDeleteDialog (){
        return wait.until
                (ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//*[@class='v-toolbar__title white--text']")));
    }
    public WebElement getSaveButton (){
        return driver.findElement
                (By.xpath("//span[contains(text(), 'Save')]"));
    }
    public void waitForEditCreateMessage(){
        driver.findElement(By.xpath
                ("//*[contains(@class,'success')]/div[@class='v-snack__content']"));
    }
    public void waitProgressBarInvisible() {
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(
                By.xpath("//div[@role='progressbar']"))));
    }
    public WebElement getDeleteButton (){
        return driver.findElement(By.xpath("//span[text()=' Delete ']"));
    }
    public void waitForNumberOfRows (int row){
        wait.until(ExpectedConditions.numberOfElementsToBe
                (By.xpath("//tbody/tr"), row));
    }
    public WebElement getTableBodyCell(int row, int column) {
        return driver.findElement(
                By.xpath("//tbody/tr["+row+"]/td["+column+"]"));
    }
    public WebElement getEditButtonFromRow (int row) {
        return driver.findElement(By.xpath("//tbody/tr["+row+"]//button[@id='edit']"));
    }
    public WebElement getDeleteButtonFromRow (int row) {
        return driver.findElement(By.xpath("//tbody/tr["+row+"]//button[@id='delete']"));
    }
}
