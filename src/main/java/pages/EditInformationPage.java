package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditInformationPage extends TestBase {

    public EditInformationPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-firstname")
    private WebElement txtFirstName;
    @FindBy(id = "input-lastname")
    private WebElement txtLastName;
    @FindBy(id = "input-email")
    private WebElement txtEmail;
    @FindBy(id = "input-telephone")
    private WebElement txtTelephone;

    public String getFirstNameFieldValue() {
        return txtFirstName.getDomAttribute("value");
    }

    public String getLastNameFieldValue() {
        return txtLastName.getDomAttribute("value");
    }

    public String getEmailFieldValue() {
        return txtEmail.getDomAttribute("value");
    }

    public String getTelephoneFieldValue() {
        return txtTelephone.getDomAttribute("value");
    }
}
