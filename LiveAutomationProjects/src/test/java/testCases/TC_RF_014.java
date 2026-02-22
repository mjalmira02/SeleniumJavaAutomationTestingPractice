package testCases;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_RF_014 extends TestBase {

    @BeforeMethod
    public void setup() {
        launchBrowser();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            closeBrowser();
        }
    }

    @Test
    public void verifyMandatoryFieldsSymbolAndColorInRegisterAccountPage() {
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        String expContent = "\"* \"";
        String expColor = "rgb(255, 0, 0)";

        //First Name
        WebElement firstNameLabel = driver.findElement(By.cssSelector("label[for='input-firstname']"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String actFNContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", firstNameLabel);
        String actFNColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", firstNameLabel);
        Assert.assertEquals(actFNContent, expContent);
        Assert.assertEquals(actFNColor, expColor);

        //Last Name
        WebElement lastNameLabel = driver.findElement(By.cssSelector("label[for='input-lastname']"));
        String actLNContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", lastNameLabel);
        String actLNColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", lastNameLabel);
        Assert.assertEquals(actLNContent, expContent);
        Assert.assertEquals(actLNColor, expColor);

        //Email
        WebElement emailLabel = driver.findElement(By.cssSelector("label[for='input-email']"));
        String actEmailContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", emailLabel);
        String actEmailColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", emailLabel);
        Assert.assertEquals(actEmailContent, expContent);
        Assert.assertEquals(actEmailColor, expColor);

        //Telephone
        WebElement telephoneLabel = driver.findElement(By.cssSelector("label[for='input-telephone']"));
        String actTelephoneContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", telephoneLabel);
        String actTelephoneColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", telephoneLabel);
        Assert.assertEquals(actTelephoneContent, expContent);
        Assert.assertEquals(actTelephoneColor, expColor);

        //Password
        WebElement passwordLabel = driver.findElement(By.cssSelector("label[for='input-password']"));
        String actPasswordContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", passwordLabel);
        String actPasswordColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", passwordLabel);
        Assert.assertEquals(actPasswordContent, expContent);
        Assert.assertEquals(actPasswordColor, expColor);

        //Confirm Password
        WebElement confirmPasswordLabel = driver.findElement(By.cssSelector("label[for='input-confirm']"));
        String actConfirmPasswordContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", confirmPasswordLabel);
        String actConfirmPasswordColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", confirmPasswordLabel);
        Assert.assertEquals(actConfirmPasswordContent, expContent);
        Assert.assertEquals(actConfirmPasswordColor, expColor);

        //Privacy Policy
        WebElement privacyPolicyLabel = driver.findElement(By.cssSelector("[class='pull-right']"));
        String actPrivacyPolicyContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", privacyPolicyLabel);
        String actPrivacyPolicyColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", privacyPolicyLabel);
        Assert.assertEquals(actPrivacyPolicyContent, expContent);
        Assert.assertEquals(actPrivacyPolicyColor, expColor);
    }
}