package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends TestBase {

    public ContactUsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Contact Us']")
    private WebElement contactUsBreadcrumb;

    public boolean didWeNavigateToContactUsPage() {
        return contactUsBreadcrumb.isDisplayed();
    }
}
