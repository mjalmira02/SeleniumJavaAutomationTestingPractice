package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class CommonUtilities {

    public static String generateNewEmail() {
        return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "")+"@gmail.com";
    }

    public static boolean compareTwoScreenshots(String actualImagePath, String expectedImagePath) throws IOException {
        BufferedImage actBImg = ImageIO.read(new File(actualImagePath));
        BufferedImage expBImg = ImageIO.read(new File(expectedImagePath));

        ImageDiffer imgDiffer = new ImageDiffer();
        ImageDiff imgDifference = imgDiffer.makeDiff(expBImg, actBImg);

        return imgDifference.hasDiff();
    }

    public static Properties loadProperties() {
        Properties prop = new Properties();
        try {
            FileReader fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\projectData.properties");
            prop.load(fr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static WebDriver takeScreenshot(WebDriver driver, String pathToBeCopied) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File srcScreenshot = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(srcScreenshot, new File(System.getProperty("user.dir") + pathToBeCopied ));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return driver;
    }

}
