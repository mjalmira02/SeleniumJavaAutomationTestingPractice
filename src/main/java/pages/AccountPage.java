package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends TestBase {

    //Constructor to initialize the WebElement
    public AccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Subscribe / unsubscribe to newsletter")
    private WebElement lnkSubscribeUnscribeToNewsLetter;

    @FindBy(linkText = "Edit your account information")
    private WebElement lnkEditYourAccountInformation;

    public EditInformationPage clickEditYourAccountInformation() {
        lnkEditYourAccountInformation.click();
        return new EditInformationPage();
    }

    public boolean isEditYourAccountInformationIsDisplayed() {
        return lnkEditYourAccountInformation.isDisplayed();
    }

    public NewsletterPage clickSubscribeUnscribeToNewsLetterLink() {
        lnkSubscribeUnscribeToNewsLetter.click();
        return new NewsletterPage();
    }
}
