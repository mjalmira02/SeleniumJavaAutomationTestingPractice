package testCases;

import base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.CommonUtilities;

import java.time.Duration;
import java.util.Properties;

public class TC_RF_027 {

    public static WebDriver driver;
    public static Properties prop;

    @Test(dataProvider = "environmentsSupplier")
    public void verifyRegisterAccountInDifferentTestEnvironment(String envs) {
        prop = CommonUtilities.loadProperties();
        String browser = envs;
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");

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

        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']/li[3]/a[text()='Success']")).isDisplayed());
        driver.findElement(By.linkText("Continue")).click();
        Assert.assertEquals(driver.getTitle(), "My Account");
    }

    @DataProvider(name = "environmentsSupplier")
    public Object[][] passTestEnvironment() {
        Object[][] envs = {{"chrome"}, {"firefox"}, {"edge"}};
        return envs;
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
