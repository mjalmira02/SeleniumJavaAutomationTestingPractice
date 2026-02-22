package testCases;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.CommonUtilities;

import java.io.File;
import java.io.IOException;

public class TC_RF_026 extends TestBase {

    @BeforeMethod
    public void setup() {
        launchBrowser();
    }

    @Test
    public void verifyUIOfRegisterAccountPatge() throws IOException {
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        TakesScreenshot ts = (TakesScreenshot)driver;
        File srcScreenshot = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(srcScreenshot, new File(System.getProperty("user.dir") + "\\Screenshots\\actUIRegisterPage.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertFalse(CommonUtilities.compareTwoScreenshots(System.getProperty("user.dir") + "\\Screenshots\\actUIRegisterPage.png", System.getProperty("user.dir") + "\\Screenshots\\expUIRegisterPage.png"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
