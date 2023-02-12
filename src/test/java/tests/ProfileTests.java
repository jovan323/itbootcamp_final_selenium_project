package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        Assert.assertTrue(driver.getCurrentUrl().contains("/profile"));
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
        WebElement inputEmailElement = driver.findElement(By.xpath("//input[@disabled='disabled']"));
        String attrType = (String) js.executeScript("return arguments[0].getAttribute('type');", inputEmailElement);
        String attrDisabled = (String) js.executeScript("return arguments[0].getAttribute('disabled');", inputEmailElement);
        Assert.assertEquals(attrType,"email");
        Assert.assertEquals(attrDisabled, "disabled", "Value is not DISABLED");
//        Assert.assertTrue(profilePage.getNameBox().getAttribute("type").equals("text"));
//        profilePage.getNameBox().sendKeys("blablaba");

        profilePage.getTwitterBox().clear();
    }
}
