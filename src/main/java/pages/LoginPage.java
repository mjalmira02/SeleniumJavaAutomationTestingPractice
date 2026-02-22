package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //Contructor to initiliaze the WebElement
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "//a[@class='btn btn-primary'][text()='Continue']")
    private WebElement btnNewCustomerContinue;

    @FindBy(xpath = "//a[@class='list-group-item'][text()='Register']")
    private WebElement lgbRegister;

    public RegisterPage clickNewCustomerContinueButton() {
        btnNewCustomerContinue.click();
        return new RegisterPage();
    }

    public RegisterPage clickRegisterListGroupButton() {
        lgbRegister.click();
        return new RegisterPage();
    }
}
