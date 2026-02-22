package testCases;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.CommonUtilities;

import java.util.Date;

public class TC_RF_005 extends TestBase {

    @BeforeMethod
    public void setup() {
        launchBrowser();
    }

    @Test
    public void verifyRegisterAccountBySubcribingYesToNewsLetter() {
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
        driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
        driver.findElement(By.id("input-email")).sendKeys(CommonUtilities.generateNewEmail());
        driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNumber"));
        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        driver.findElement(By.linkText("Continue")).click();

        driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Newsletter']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).isSelected());

        driver.quit();

    }
}
