package testCases;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_RF_023 extends TestBase {

    @BeforeMethod
    public void setup() {
        launchBrowser();
    }

    @Test
    public void verifyWorkingOfEveryLinkOnRegisterAccountPage() {
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        // <-------------- Navigation bar -------------->

        //Verify the 123456789 navigation bar
        driver.findElement(By.xpath("//a/i[@class='fa fa-phone']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Contact Us']")).isDisplayed());
        driver.navigate().back();

        //Verify the Wish List(0) navigation bar
        driver.findElement(By.xpath("//a/i[@class='fa fa-heart']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify the Shopping Cart navigation bar
        driver.findElement(By.xpath("//span[text()='Shopping Cart']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Shopping Cart']")).isDisplayed());
        driver.navigate().back();

        //Verify Checkout navigation bar
        driver.findElement(By.xpath("//span[text()='Checkout']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Shopping Cart']")).isDisplayed());
        driver.navigate().back();

        // <-------------- Menu -------------->

        //Verify the Qafox.com logo page
        driver.findElement(By.xpath("//div[@id='logo']//a[text()='Qafox.com']")).click();
        Assert.assertEquals(driver.getCurrentUrl() ,"https://tutorialsninja.com/demo/index.php?route=common/home");
        driver.navigate().back();

        //Verify the search button
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Search']")).isDisplayed());
        driver.navigate().back();

        // <-------------- Bread Crumbs -------------->

        //Verify Register page in bread crumb
        driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());

        //Verify Account page in bread crumb
        driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Account']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify Icon home page in bread crumb
        driver.findElement(By.xpath("//ul[@class='breadcrumb']//i[@class='fa fa-home']")).click();
        Assert.assertEquals(driver.getCurrentUrl() ,"https://tutorialsninja.com/demo/index.php?route=common/home");
        driver.navigate().back();

        // <-------------- Page Link -------------->

        //Verify login page link
        driver.findElement(By.xpath("//a[text()='login page']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify Policy Privacy link
        driver.findElement(By.xpath("//a[@class='agree']//b[text()='Privacy Policy']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement xOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='×']")));
        Assert.assertTrue(xOption.isDisplayed());
        xOption.click();

        //Verify the register page with warning messages
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());
        driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).click();

        // <-------------- List Group Item -------------->

        //Verify login page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Login']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify register page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Register']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());
        driver.navigate().back();

        //Verify forgotten password page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Forgotten Password']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Forgotten Password']")).isDisplayed());

        //Verify my account page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='My Account']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify address book page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Address Book']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify wish list page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Wish List']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify order history page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Order History']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify download page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Downloads']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify Recurring payments page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Recurring payments']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify Reward Points page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Reward Points']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify Returns page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Returns']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify Transactions page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Transactions']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify Newsletter page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Newsletter']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        // <-------------- Footer Option -------------->

        //Verify About Us page in the footer
        driver.findElement(By.linkText("About Us")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='About Us']")).isDisplayed());
        driver.navigate().back();

        //Verify Delivery Information page in the footer
        driver.findElement(By.linkText("Delivery Information")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Delivery Information']")).isDisplayed());
        driver.navigate().back();

        //Verify Privacy Policy page in the footer
        driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[text()='Privacy Policy']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Privacy Policy']")).isDisplayed());
        driver.navigate().back();

        //Verify Terms & Conditions page in the footer
        driver.findElement(By.linkText("Terms & Conditions")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Terms & Conditions']")).isDisplayed());
        driver.navigate().back();

        //Verify Contact Us page in the footer
        driver.findElement(By.linkText("Contact Us")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Contact Us']")).isDisplayed());
        driver.navigate().back();

        //Verify Returns page in the footer
        driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[text()='Returns']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Product Returns']")).isDisplayed());
        driver.navigate().back();

        //Verify Site Map page in the footer
        driver.findElement(By.linkText("Site Map")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Site Map']")).isDisplayed());
        driver.navigate().back();

        //Verify Brands page in the footer
        driver.findElement(By.linkText("Brands")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Brand']")).isDisplayed());
        driver.navigate().back();

        //Verify Gift Certificates page in the footer
        driver.findElement(By.linkText("Gift Certificates")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Gift Certificate']")).isDisplayed());
        driver.navigate().back();

        //Verify Affiliate page in the footer
        driver.findElement(By.linkText("Affiliate")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify Specials page in the footer
        driver.findElement(By.linkText("Specials")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Special Offers']")).isDisplayed());
        driver.navigate().back();

        //Verify My Account page in the footer
        driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[text()='My Account']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify Order History page in the footer
        driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[text()='Order History']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify Wish List page in the footer
        driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[text()='Wish List']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify Newsletter page in the footer
        driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[text()='Newsletter']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify OpenCart link in the footer
        driver.findElement(By.linkText("OpenCart")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='navbar-brand']//img[@title='OpenCart - Open Source Shopping Cart Solution']")).isDisplayed());
        driver.navigate().back();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
