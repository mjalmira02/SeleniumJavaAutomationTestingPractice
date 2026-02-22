package testCases;

import io.opentelemetry.sdk.logs.data.Body;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

public class TC_RF_002 {

    public static void main(String[] args) throws InterruptedException {
        //Start Chrome
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

        driver.findElement(By.xpath("//button[text()='Continue shopping']")).click();
        driver.findElement(By.xpath("//span[text()='Hello, sign in']")).click();
        driver.findElement(By.xpath("//a[normalize-space(text())='Need help?']")).click();
        //Switch to new tab
        Set<String> tabs = driver.getWindowHandles();
        String originalTab = driver.getWindowHandle();
        for (String tab : tabs) {
            if (!tab.equals(originalTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }
        Thread.sleep(3000);
        //Select an option from dropdown
        WebElement drpdwnChooseTopic = driver.findElement(By.xpath("//select[@id='cu-select-firstNode']"));
        Select select = new Select(drpdwnChooseTopic);
        select.selectByValue("2");
        driver.findElement(By.xpath("//a[normalize-space(text())='Password Reset']")).click();

        String email = "mjalmira720@gmail.com";
        String appPasscode = "hcow whes qfoz tcyz";

        driver.findElement(By.id("ap_email")).sendKeys("mjalmira720@gmail.com");
        driver.findElement(By.id("continue")).click();

        // Gmail IMAP configuration
        String host = "imap.gmail.com";
        String port = "993";
        String username = email; // Your Gmail address
        String appPassword = appPasscode; // Your app password
        String expectedSubject = "TutorialsNinja - Welcome to your account";
        String expectedFromEmail = "account-update@tn.in>";
        String expectedBodyContent = "Confirm your email to activate your account";

        boolean b = false;

        Message message;
//        try {
//            // Mail server connection properties
//            Properties properties = new Properties();
//            properties.put("mail.store.protocol", "imaps");
//            properties.put("mail.imap.host", host);
//            properties.put("mail.imap.port", port);
//            properties.put("mail.imap.ssl.enable", "true");
//
//            // Connect to the mail server
//            Session emailSession = Session.getDefaultInstance(properties);
//            Store store = emailSession.getStore("imaps");
//            store.connect(host, username, appPassword); // replace email password with App password
//
//            // Open the inbox folder
//            Folder inbox = store.getFolder("INBOX");
//            inbox.open(Folder.READ_ONLY);
//
//            // Search for unread emails
//            Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
//
//            boolean found = false;
//            for (int i = messages.length - 1; i >= 0; i--) {
//
//                message = messages[i];
//
//                if (message.getSubject().contains(expectedSubject)) {
//                    found = true;
//                    System.out.println("Email Subject: " + message.getSubject());
//                    System.out.println("Email From: " + message.getFrom()[0].toString());
//                    System.out.println("Email body: " + getTextFromMessage(message));
//                    break;
//                }
//
////                if (message.getSubject().contains(expectedSubject)) {
////                    found = true;
////                    Assert.assertEquals(message.getSubject(), expectedSubject);
////                    Assert.assertEquals(message.getFrom()[0].toString(), expectedFromEmail);
////                    String actualEmailBody = CommonUtils.getTextFromMessage(message);
////                    Assert.assertTrue(actualEmailBody.contains(expectedBodyContent));
////
////                    break;
////                }
//            }
//
//            if (!found) {
//                System.out.println("No confirmation email found.");
//            }
//
//            // Close the store and folder objects
//            inbox.close(false);
//            store.close();
//            b = true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            b = false;
//        }
//
//        Assert.assertTrue(b);
//
//        private static String getTextFromMessage (Message message)MimeMultipart mimeMultipart;
//        {
//            String result = "";
//            if (message.isMimeType("type/plain")) {
//                result = message.getContent().toString();
//            } else if (message.isMimeType("text/html")) {
//                result = message.getContent().toString();
//            } else if (message.isMimeType("multipart/*")) {
//                mimeMultipart = (MimeMultipart) message.getContent();
//                result = getTextFromMimeMultipart(mimeMultipart);
//            }
//            return result;
//        }
//
//        private static String getTextFromMimeMultipart(MimeMultipart mimeMultipart){
//            StringBuilder result = new StringBuilder();
//            int count = mimeMultipart.getCount();
//            for (int i = 0; i < count; i++) {
//                BodyPart bodyPart = mimeMultipart.getBodyPart(i);
//                if (bodyPart.isMimeType("text/plain")) {
//                    result.append(bodyPart.getContent());
//                } else if (bodyPart.isMimeType("text/html")) {
//                    result.append(bodyPart.getContent());
//                } else if (bodyPart.getContent() instanceof MimeMultipart) {
//                    result.append(getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent()));
//                }
//            }
//            return result.toString();
//        }
    }
}
