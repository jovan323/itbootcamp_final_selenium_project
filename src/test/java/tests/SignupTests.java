package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest{
    @Test(priority = 1)
    @Description("Test #1: Visit the signup page")
    public void visitSignupPage(){
        navPage.getSignUpButton().click();
        Assert.assertTrue
                (driver.getCurrentUrl().contains("/signup"),
                        "URl doesn't contain SIGNUP");
    }
    @Test(priority = 2)
    @Description("Test #2: Check input types")
    public void checkInputTypes(){
        navPage.getSignUpButton().click();
        Assert.assertTrue
                (signupPage.getEmailBox().getAttribute("type").contains("email"),
                "EmailBox attribute type doesn't contain EMAIL");
        Assert.assertTrue
                (signupPage.getPasswordBox().getAttribute("type").contains("password"),
                "PasswordBox attribute type doesn't contain PASSWORD");
        Assert.assertTrue
                (signupPage.getConfirmPasswordBox().getAttribute("type").contains("password"),
                "ConfirmPasswordBox attribute type doesn't contain PASSWORD");
    }
    @Test(priority = 3)
    @Description("Test #3: Display errors when used already exists")
    public void errorExistingUsers(){
        navPage.getSignUpButton().click();
        Assert.assertTrue
                (driver.getCurrentUrl().contains("/signup"),
                        "URl doesn't contain SIGNUP");
        signupPage.getNameBox().sendKeys("Another User");
        signupPage.getEmailBox().sendKeys("admin@admin.com");
        signupPage.getPasswordBox().sendKeys("12345");
        signupPage.getConfirmPasswordBox().sendKeys("12345");
        signupPage.getSignUpButton().click();
        messagePopUpPage.waitForMessagePopUp();
        Assert.assertTrue
                (messagePopUpPage.getMessageTextLog().
                        getText().equals("E-mail already exists"),
                        "Wrong text displayed in popup");
    }
    @Test(priority = 4)
    @Description("Test #4: Valid signup with credentials")
    public void validSignup() throws InterruptedException {
        navPage.getSignUpButton().click();
        signupPage.getNameBox().sendKeys("Joe Piscopo");
        signupPage.getEmailBox().sendKeys("joepiscopo@itbootcamp.rs");
        signupPage.getPasswordBox().sendKeys("12345");
        signupPage.getConfirmPasswordBox().sendKeys("12345");
        signupPage.getSignUpButton().click();
        Thread.sleep(2000);
        Assert.assertTrue
                (driver.getCurrentUrl().contains("/home"),
                        "URL doesn't contain HOME");
        Assert.assertTrue
                (messagePopUpPage.getHeaderFromAccDialog().getText().
                        contains("IMPORTANT: Verify your account"),
                        "Dialog header doesn't contain right message");
        messagePopUpPage.getCloseButtonFromAccDialog().click();
        Thread.sleep(2000);
        navPage.getLogOutButton().click();
    }
}
