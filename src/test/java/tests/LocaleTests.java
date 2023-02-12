package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

public class LocaleTests extends BasicTest {
    @Test
    @Description("Test #1: Set locale to ES")
    public void setLocaleSpanish() throws InterruptedException {
        navPage.getLanguageButton().click();
        navPage.getEsButton().click();
        Assert.assertTrue(navPage.getHeaderForLocale().getText().contains("Página de aterrizaje"),
                "Header doesn't display correct text");
    }
    @Test
    @Description("Test #2: Set locale to EN")
    public void setLocaleEnglish() throws InterruptedException {
        navPage.getLanguageButton().click();
        navPage.getEnButton().click();
        Assert.assertTrue(navPage.getHeaderForLocale().getText().contains("Landing"),
                "Header doesn't display correct text");
    }
    @Test
    @Description("Test #3: Set locale to CN")
    public void setLocaleChinese() throws InterruptedException {
        navPage.getLanguageButton().click();
        navPage.getCnButton().click();
        Assert.assertTrue(navPage.getHeaderForLocale().getText().contains("首页"),
                "Header doesn't display correct text");
    }
    @Test
    @Description("Test #3: Set locale to FR")
    public void setLocaleFrench() throws InterruptedException {
        navPage.getLanguageButton().click();
        navPage.getFrButton().click();
        Assert.assertTrue(navPage.getHeaderForLocale().getText().contains("Page d'atterrissage"),
                "Header doesn't display correct text");
    }
}
