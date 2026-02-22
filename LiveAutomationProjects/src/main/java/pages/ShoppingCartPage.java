package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends TestBase {

    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Shopping Cart']")
    private WebElement shoppingCartBreadcrumb;

    public boolean didWeNavigateToShoppingCartPage() {
        return shoppingCartBreadcrumb.isDisplayed();
    }
}
