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
        return driver.findElement(By.linkText("New Item"));
    }
    public WebElement getSearchBox () {
        return driver.findElement(By.id("search"));
    }
    public WebElement waitForEditDialog (){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Edit Item")));
    }
    public WebElement waitForDeleteDialog (){
        return wait.until
                (ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//*[@class='v-toolbar__title white--text']")));
    }
    public WebElement getSaveButton (){
        return driver.findElement(By.linkText("Save"));
    }
    public WebElement getDeleteButton (){
        return driver.findElement(By.linkText("Delete"));
    }
    public void waitForNoOfRows (int row){
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
}
