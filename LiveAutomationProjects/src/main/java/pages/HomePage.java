package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    //Contructor to initiliaze the WebElement
    public HomePage() {
        PageFactory.initElements(TestBase.driver, this);
    }

    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccountDropMenu;

    @FindBy(linkText = "Register")
    WebElement registerOption;

    @FindBy(linkText = "Login")
    WebElement loginOption;

    public void clickOnMyAccount() {
        myAccountDropMenu.click();
    }

    public RegisterPage selectRegisterOption() {
        registerOption.click();
        return new RegisterPage();
    }

    public LoginPage selectLoginOption() {
        loginOption.click();
        return new LoginPage();
    }
}
