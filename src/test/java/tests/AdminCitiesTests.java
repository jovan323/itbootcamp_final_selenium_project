package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {
    @BeforeMethod
    @Test (priority = 1)
    @Description("Test #1: Visit admin cities page and list cities" +
            "Credentials:" +
            "admin email: admin@admin.com" +
            "admin password: 12345")
    public void citiesList() {
        navPage.getLogInButton().click();
        loginPage.getEmailBox().sendKeys("admin@admin.com");
        loginPage.getPasswordBox().sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getAdminLink().click();
        navPage.getAdminCitiesLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),
                "URL doesn't contain correct route");
    }

    @Test(priority = 2)
    @Description("Test #2: Checks input types for create/edit new city")
    public void inputForEditCreate() {
//        navPage.getLogInButton().click();
//        loginPage.getEmailBox().sendKeys("admin@admin.com");
//        loginPage.getPasswordBox().sendKeys("12345");
//        loginPage.getLoginButton().click();
        navPage.getAdminLink().click();
        navPage.getAdminCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditDialog();
        Assert.assertTrue(citiesPage.getInputCityBox().getAttribute("type").contains("text"));
    }

    @Test(priority = 3)
    @Description("Test #3: Create new city" +
            "Credentials:" +
            "city: [First and Last name]’s city")
    public void createNewCity() {
//        navPage.getLogInButton().click();
//        loginPage.getEmailBox().sendKeys("admin@admin.com");
//        loginPage.getPasswordBox().sendKeys("12345");
//        loginPage.getLoginButton().click();
        navPage.getAdminLink().click();
        navPage.getAdminCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditDialog();
        citiesPage.getInputCityBox().sendKeys("Bangkok");
        citiesPage.getSaveButton().click();
        messagePopUpPage.waitForPopUp();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'success')]")).getText().contains("Saved successfully"),
                "Dialog doesn't display the correct message");
    }

    @Test(priority = 4)
    @Description("Test #4: Edit city" +
            "Credentials:" +
            "old city name: [First and last name]’s city" +
            "new city name: [First and last name]’s city Edited")
    public void editCity() throws InterruptedException {
//        navPage.getLogInButton().click();
//        loginPage.getEmailBox().sendKeys("admin@admin.com");
//        loginPage.getPasswordBox().sendKeys("12345");
//        loginPage.getLoginButton().click();
        navPage.getAdminLink().click();
        navPage.getAdminCitiesLink().click();
        citiesPage.getSearchCityBox().sendKeys("Bangkok");
        citiesPage.waitForNumberOfRows(1);
        Thread.sleep(2000);
        citiesPage.getEditButtonFromRow(1).click();
        citiesPage.getInputCityBox().clear();
        citiesPage.getInputCityBox().sendKeys("Bangkok");
        citiesPage.getSaveButton().click();
        messagePopUpPage.waitForPopUp();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'success')]")).getText().contains("Saved successfully"),
                "Dialog doesn't display the correct message");
    }

    @Test(priority = 5)
    @Description("Test #5: Search city")
    public void searchCity() throws InterruptedException {
//        navPage.getLogInButton().click();
//        loginPage.getEmailBox().sendKeys("admin@admin.com");
//        loginPage.getPasswordBox().sendKeys("12345");
//        loginPage.getLoginButton().click();
        navPage.getAdminLink().click();
        navPage.getAdminCitiesLink().click();
        citiesPage.getSearchCityBox().sendKeys("Bangkok");
        citiesPage.waitForNumberOfRows(1);
        Thread.sleep(2000);
        Assert.assertTrue(citiesPage.getTableBodyCell(1, 2).getText().contains("Bangkok"),
                "Cell doesn't contain the name of the city");
    }

    @Test(priority = 6)
    @Description("Test #6: Delete city")
    public void deleteCity() throws InterruptedException {
//        navPage.getLogInButton().click();
//        loginPage.getEmailBox().sendKeys("admin@admin.com");
//        loginPage.getPasswordBox().sendKeys("12345");
//        loginPage.getLoginButton().click();
        navPage.getAdminLink().click();
        navPage.getAdminCitiesLink().click();
        citiesPage.getSearchCityBox().sendKeys("Bangkok");
        citiesPage.waitForNumberOfRows(1);
        Thread.sleep(2000);
        Assert.assertTrue(citiesPage.getTableBodyCell(1, 2).getText().contains("Bangkok"),
                "Cell doesn't contain the name of the city");
        citiesPage.getDeleteButtonFromRow(1).click();
        citiesPage.getDeleteButton().click();
        messagePopUpPage.waitForPopUp();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'success')]")).getText().contains("Deleted successfully"),
                "Dialog doesn't display the correct message");
    }

}
