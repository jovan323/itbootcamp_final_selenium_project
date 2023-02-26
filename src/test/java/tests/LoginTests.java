package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest{
    @Test(priority = 1)
    @Description("Test #1: Visits the login page")
    public void visitTheLoginPage () throws InterruptedException {
        driver.get(baseUrl + "/login");
        navPage.getLanguageButton().click();
        Thread.sleep(2000);
        navPage.getEnButton().click();
        loginPage.getLoginButton().click();
        Assert.assertTrue
                (driver.getCurrentUrl().contains("/login"),
                        "URL doesn't contain /login");

    }
    @Test(priority = 2)
    @Description("Test #2: Checks input types")
    public void checkInputType(){
        navPage.getLogInButton().click();
        Assert.assertTrue
                (loginPage.getEmailBox().getAttribute("type").equals("email"),
                        "Attribute TYPE is not EMAIL");
        Assert.assertTrue
                (loginPage.getPasswordBox().getAttribute("type").equals("password"),
                        "Attribute TYPE is not PASSWORD");
    }
    @Test(priority = 3)
    @Description("Test #3: Displays errors when user does not exist")
    public void errorNonExistantUser() {
        navPage.getLogInButton().click();
        loginPage.getEmailBox().sendKeys("non-existing-user@gmal.com");
        loginPage.getPasswordBox().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForMessagePopUp();
        Assert.assertTrue
                (messagePopUpPage.getMessageTextLog().getText().equals("User does not exists"));
        Assert.assertTrue
                (driver.getCurrentUrl().contains("/login"),
                        "URL doesn't contain /login");
    }
    @Test(priority = 4)
    @Description("Test #4: Displays errors when password is wrong")
    public void errorWrongPassword(){
        navPage.getLogInButton().click();
        loginPage.getEmailBox().sendKeys("admin@admin.com");
        loginPage.getPasswordBox().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForMessagePopUp();
        Assert.assertTrue
                (messagePopUpPage.getMessageTextLog().
                        getText().equals("Wrong password"),
                        "Error box is not displayed");
    }
    @Test(priority = 5)
    @Description("Test #5: Login with correct credentials")
    public void login() throws InterruptedException {
        navPage.getLogInButton().click();
        loginPage.getEmailBox().sendKeys("admin@admin.com");
        loginPage.getPasswordBox().sendKeys("12345");
        loginPage.getLoginButton().click();
        Thread.sleep(2000);
        Assert.assertTrue
                (driver.getCurrentUrl().contains("/home"),
                        "URL doesn't contain HOME");
    }

    @Test
    @Description("Test #6")
    public void logout() throws InterruptedException {
        navPage.getLogInButton().click();
        loginPage.getEmailBox().sendKeys("admin@admin.com");
        loginPage.getPasswordBox().sendKeys("12345");
        loginPage.getLoginButton().click();
        Thread.sleep(2000);
        Assert.assertTrue
                (navPage.getLogOutButton().isDisplayed(),
                "Logout button is not visible");
        navPage.getLogOutButton().click();
    }
}
