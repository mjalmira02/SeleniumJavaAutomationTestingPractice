package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsletterPage extends TestBase {

    //Constructor to initialize the WebElement
    public NewsletterPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Newsletter']")
    private WebElement newsletterBreadcrumb;

    @FindBy(xpath = "//input[@name='newsletter'][@value='1']")
    private WebElement rdbNewsletterYes;

    @FindBy(xpath = "//input[@name='newsletter'][@value='0']")
    private WebElement rdbNewsletterNo;

    public boolean didWeNavigateToNewsletterPage() {
        return newsletterBreadcrumb.isDisplayed();
    }

    public boolean isYesNewsletterOptionSelected() {
        return rdbNewsletterYes.isSelected();
    }

    public boolean isNoNewsletterOptionSelected() {
        return rdbNewsletterNo.isSelected();
    }
}
