package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage extends TestBase {

    //Constructor to initialize the WebElement
    public AccountSuccessPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Logout")
    private WebElement logoutOption;

    @FindBy(xpath = "//div[@id='common-success']//h1")
    private WebElement pageHeading;

    @FindBy(id = "content")
    private WebElement pageContent;

    @FindBy(xpath = "//a[text()='Continue']")
    private WebElement btnAccountSuccessContinue;

    @FindBy(xpath = "//ul[@class='breadcrumb']/li[3]/a[text()='Success']")
    private WebElement accountSuccessPageBreadcrumb;

    public boolean isLogoutOptionIsDisplayed() {
        return logoutOption.isDisplayed();
    }

    public String getPageHeading() {
        return pageHeading.getText();
    }

    public String getPageContent() {
        return pageContent.getText();
    }

    public AccountPage clickAccountSuccessContinueButton() {
        btnAccountSuccessContinue.click();
        return new AccountPage();
    }

    public boolean didWeNavigateToAccountSuccessPage() {
        return accountSuccessPageBreadcrumb.isDisplayed();
    }

}
