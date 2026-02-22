package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage extends TestBase {

    public WishListPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Login']")
    private WebElement loginBreadcrumb;

    public boolean didWeNavigateToLoginPage() {
        return loginBreadcrumb.isDisplayed();
    }
}
