package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.CommonUtilities;

import java.time.Duration;
import java.util.Properties;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public void launchBrowser() {
        prop = CommonUtilities.loadProperties();
        String browser = prop.getProperty("browserName");
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
        driver.get(prop.getProperty("appURL"));
    }

    public void launchBrowserOne() {
        String browser = "chrome";
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
    }

    public void navigateToRegisterPage(String URL) {
        driver.navigate().to(URL);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void closeBrowser() {
        if (driver!=null) {
            driver.quit();
        }
    }
}
