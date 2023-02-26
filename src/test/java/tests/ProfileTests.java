package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BasicTest {

    @Test(priority = 1)
    @Description("Test #1: Visits the profile page")
    public void visitProfilePage() throws InterruptedException {
        navPage.getLogInButton().click();
        loginPage.getEmailBox().sendKeys("admin@admin.com");
        loginPage.getPasswordBox().sendKeys("12345");
        loginPage.getLoginButton().click();
        Thread.sleep(1000);
        driver.get(baseUrl + "/profile");
        Assert.assertTrue
                (driver.getCurrentUrl().contains("/profile"),
                        "URL doesn't contain PROFILE");
        Thread.sleep(1000);
        Assert.assertEquals
                (profilePage.getEmailBox().getAttribute("value"), "admin@admin.com",
                        "Incorrect text for attribute VALUE");
        navPage.getLogOutButton().click();
    }
    @Test(priority = 2)
    @Description("Test #2: Checks input types")
    public void checkInputType() throws InterruptedException {
        navPage.getLogInButton().click();
        loginPage.getEmailBox().sendKeys("admin@admin.com");
        loginPage.getPasswordBox().sendKeys("12345");
        loginPage.getLoginButton().click();
        Thread.sleep(1000);
        navPage.getMyProfileLink().click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String attrDisabled = (String) js.executeScript("return arguments[0].getAttribute('disabled');", profilePage.getEmailBox());
        Assert.assertEquals
                (profilePage.getEmailBox().getAttribute("type"),"email",
                        "Incorrect type for EMAIL");
        Assert.assertEquals
                (attrDisabled, "disabled",
                        "Value is not DISABLED");
        Assert.assertTrue
                (profilePage.getNameBox().getAttribute("type").equals("text"),
                        "Attribute type not TEXT");
        Assert.assertTrue
                (profilePage.getCityBox().getAttribute("type").equals("text"),
                        "Attribute type not TEXT");
        Assert.assertTrue(profilePage.getCountryBox().getAttribute("type").equals("text"),
                "Attribute type not TEXT");
        Assert.assertTrue(profilePage.getTwitterBox().getAttribute("type").equals("url"),
                "Attribute type not URL");
        Assert.assertTrue(profilePage.getGithubBox().getAttribute("type").equals("url"),
                "Attribute type not URL");
        Assert.assertTrue(profilePage.getPhoneBox().getAttribute("type").equals("tel"),
                "Attribute type not TEL");
        navPage.getLogOutButton().click();
    }
    @Test
    @Description("Test #3: Edit profile")
    public void editProfile() throws InterruptedException {
        navPage.getLogInButton().click();
        loginPage.getEmailBox().sendKeys("admin@admin.com");
        loginPage.getPasswordBox().sendKeys("12345");
        loginPage.getLoginButton().click();
        Thread.sleep(1000);
        navPage.getMyProfileLink().click();
        profilePage.getNameBox().click();
        profilePage.getNameBox().sendKeys((Keys.CONTROL + "a"));
        profilePage.getNameBox().sendKeys("Uvwuvwuevwuevwue");
        profilePage.getPhoneBox().click();
        profilePage.getPhoneBox().sendKeys((Keys.CONTROL + "a"));
        profilePage.getPhoneBox().sendKeys("+555-1234");
        profilePage.getCityBox().click();
        profilePage.getCityBox().sendKeys((Keys.CONTROL + "a"));
        profilePage.getCityBox().sendKeys("New York");
        profilePage.getCountryBox().click();
        profilePage.getCountryBox().sendKeys((Keys.CONTROL + "a"));
        profilePage.getCountryBox().sendKeys("New York");
        profilePage.getTwitterBox().click();
        profilePage.getTwitterBox().sendKeys((Keys.CONTROL + "a"));
        profilePage.getTwitterBox().sendKeys("https://twitter.com/LosZao");
        profilePage.getGithubBox().click();
        profilePage.getGithubBox().sendKeys((Keys.CONTROL + "a"));
        profilePage.getGithubBox().sendKeys("https://github.com/topics/javascript-executor");
        profilePage.getSaveButton().click();
        Thread.sleep(1000);
        Assert.assertTrue
                (messagePopUpPage.getMessage().isDisplayed(),
                "Message doesn't appear");
        Assert.assertTrue
                (messagePopUpPage.getMessageText().getText()
                        .contains("Profile saved successfuly"),
                        "Wrong text for message popup");
        navPage.getLogOutButton().click();
    }
}
