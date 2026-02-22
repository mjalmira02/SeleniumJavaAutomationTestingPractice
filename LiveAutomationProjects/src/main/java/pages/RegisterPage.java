package pages;

import base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends TestBase {

    //Constructor to initialize the WebElement
    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

    //Navigation bar menu
    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement mnuMyAccountDrop;
    @FindBy(xpath = "//a/i[@class='fa fa-phone']")
    private WebElement mnuPhoneIcon;
    @FindBy(xpath = "//a/i[@class='fa fa-heart")
    private WebElement mnuWishList;
    @FindBy(xpath = "//span[text()='Shopping Cart']")
    private WebElement mnuShoppingCart;
    @FindBy(xpath = "//span[text()='Checkout']")
    private WebElement mnuCheckout;

    //Option
    @FindBy(xpath = "//div[@id='logo']//a[text()='Qafox.com']")
    private WebElement logoOption;

    @FindBy(linkText = "Login")
    private WebElement loginOption;

    //All Textbox Fields
    @FindBy(id = "input-firstname")
    private WebElement txtFirstName;
    @FindBy(id = "input-lastname")
    private WebElement txtLastName;
    @FindBy(id = "input-email")
    private WebElement txtEmail;
    @FindBy(id = "input-telephone")
    private WebElement txtTelephone;
    @FindBy(id = "input-password")
    private WebElement txtPassword;
    @FindBy(id = "input-confirm")
    private WebElement txtConfirmPassword;

    //Checkbox Privacy Policy
    @FindBy(name = "agree")
    private WebElement chkPrivacyPolicy;

    //Register Continue Button
    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement btnRegisterContinue;

    //Register Heading
    @FindBy(xpath = "//div[@id='content']//h1[text()='Register Account']")
    private WebElement registerAccountHeading;

    //Radio Button Newsletter field
    @FindBy(xpath = "//input[@name='newsletter'][@value='1']")
    private WebElement rdbNewsLetterYes;
    @FindBy(xpath = "//input[@name='newsletter'][@value='0']")
    private WebElement rdbNewsLetterNo;

    //All Fields Warning
    @FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
    private WebElement firstNameWarningMessage;
    @FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
    private WebElement lastNameWarningMessage;
    @FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
    private WebElement emailWarningMessage;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement existingEmailWarningMessage;
    @FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
    private WebElement telephoneWarningMessage;
    @FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
    private WebElement passwordWarningMessage;
    @FindBy(xpath = "//input[@id='input-confirm']/following-sibling::div")
    private WebElement confirmPasswordWarningMessage;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement privacyPolicyWarningMessage;

    //Register Breadcrumb
    @FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Register']")
    private WebElement registerBreadcrumb;

    //Label of all Fields
    @FindBy(css = "label[for='input-firstname']")
    private WebElement firstNameLabel;
    @FindBy(css = "label[for='input-lastname']")
    private WebElement lastNameLabel;
    @FindBy(css = "label[for='input-email']")
    private WebElement emailLabel;
    @FindBy(css = "label[for='input-telephone']")
    private WebElement telephoneLabel;
    @FindBy(css = "label[for='input-password']")
    private WebElement passwordLabel;
    @FindBy(css = "label[for='input-confirm']")
    private WebElement confirmPasswordLabel;
    @FindBy(css = "[class='pull-right']")
    private WebElement privacyPolicyLabel;

    // Navigation Bar ----------------------
    public void clickOnMyAccount() {
        mnuMyAccountDrop.click();
    }

    public ContactUsPage clickOnPhoneIcon() {
        mnuPhoneIcon.click();
        return new ContactUsPage();
    }

    public WishListPage clickOnWishList() {
        mnuWishList.click();
        return new WishListPage();
    }

    public ShoppingCartPage clickOnShoppingCart() {
        mnuShoppingCart.click();
        return new ShoppingCartPage();
    }

    public CheckoutPage clickOnCheckout() {
        mnuCheckout.click();
        return new CheckoutPage();
    }

    public LoginPage selectLoginOption() {
        loginOption.click();
        return new LoginPage();
    }

    // Options ----------------------
    public HomePage clickLogoOption() {
        logoOption.click();
        return new HomePage();
    }

    // All Enter Fields ----------------
    public void enterFirstName(String firstNameText) {
        txtFirstName.sendKeys(firstNameText);
    }

    public void enterLastName(String lastNameText) {
        txtLastName.sendKeys(lastNameText);
    }

    public void enterEmail(String emailText) {
        txtEmail.sendKeys(emailText);
    }

    public void enterTelephoneNumber(String telephoneText) {
        txtTelephone.sendKeys(telephoneText);
    }

    public void enterPassword(String passwordText) {
        txtPassword.sendKeys(passwordText);
    }

    public void enterConfirmPassword(String passwordConfirmText) {
        txtConfirmPassword.sendKeys(passwordConfirmText);
    }

    // Register Account Heading
    public String getProperRegisterPageHeading() {
        return registerAccountHeading.getText();
    }

    // <-----------------------------------

    public void selectPrivacyPolicy() {
        chkPrivacyPolicy.click();
    }

    public boolean isPrivacyPolicySelected() {
        return chkPrivacyPolicy.isSelected();
    }

    public AccountSuccessPage clickRegisterContinueButton() {
        btnRegisterContinue.click();
        return new AccountSuccessPage();
    }

    public void selectYesNewsLetterOption() {
        rdbNewsLetterYes.click();
    }

    public void selectNoNewsLetterOption() {
        rdbNewsLetterNo.click();
    }

    // All Fields Warning Message ----------------
    public String getFirstNameWarning() {
        return firstNameWarningMessage.getText();
    }

    public String getLastNameWarning() {
        return lastNameWarningMessage.getText();
    }

    public String getEmailWarning() {
        return emailWarningMessage.getText();
    }

    public String getExistingEmailWarning() {
        return existingEmailWarningMessage.getText();
    }

    public String getTelephoneWarning() {
        return telephoneWarningMessage.getText();
    }

    public String getPasswordWarning() {
        return passwordWarningMessage.getText();
    }

    public String getConfirmPasswordWarning() {
        return confirmPasswordWarningMessage.getText();
    }

    public String getPrivacyPolicyWarning() {
        return privacyPolicyWarningMessage.getText();
    }
    // <------------------------------------------

    public boolean didWeNavigateToRegisterPage() {
        return registerBreadcrumb.isDisplayed();
    }

    public String getEmailValidationMessage() {
        return txtEmail.getDomProperty("validationMessage");
    }

    // Get PlaceHolder for All Fields ------------------------
    public String getPlaceHolderFirstNameField() {
        return txtFirstName.getDomAttribute("placeholder");
    }

    public String getPlaceHolderLastNameField() {
        return txtLastName.getDomAttribute("placeholder");
    }

    public String getPlaceHolderEmailField() {
        return txtEmail.getDomAttribute("placeholder");
    }

    public String getPlaceHolderTelephoneField() {
        return txtTelephone.getDomAttribute("placeholder");
    }

    public String getPlaceHolderPasswordField() {
        return txtPassword.getDomAttribute("placeholder");
    }

    public String getPlaceHolderConfirmPasswordField() {
        return txtConfirmPassword.getDomAttribute("placeholder");
    }

    // All Fields Label Content and Color ---------------------
    public String getFirstNameLabelContent() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        return (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", firstNameLabel);
    }

    public String getFirstNameLabelColor() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        return (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", firstNameLabel);
    }

    public String getLastNameLabelContent() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        return (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", lastNameLabel);
    }

    public String getLastNameLabelColor() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        return (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", lastNameLabel);
    }

    public String getEmailLabelContent() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        return (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", emailLabel);
    }

    public String getEmailLabelColor() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        return (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", emailLabel);
    }

    public String getTelephoneLabelContent() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        return (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", telephoneLabel);
    }

    public String getTelephoneLabelColor() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        return (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", telephoneLabel);
    }

    public String getPasswordLabelContent() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        return (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", passwordLabel);
    }

    public String getPasswordLabelColor() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        return (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", passwordLabel);
    }

    public String getConfirmPasswordLabelContent() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        return (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", confirmPasswordLabel);
    }

    public String getConfirmPasswordLabelColor() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        return (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", confirmPasswordLabel);
    }

    public String getPrivacyPolicyLabelContent() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        return (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", privacyPolicyLabel);
    }

    public String getPrivacyPolicyLabelColor() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        return (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", privacyPolicyLabel);
    }

    //Clear All Fields
    public void clearFirstNameField() {
        txtFirstName.clear();
    }

    public void clearLastNameField() {
        txtLastName.clear();
    }

    public void clearEmailField() {
        txtEmail.clear();
    }

    public void clearTelephoneField() {
        txtTelephone.clear();
    }

    public void clearPasswordField() {
        txtPassword.clear();
    }

    //Height and Width of All Fields
    public String firstNameFieldHeight() {
        return txtFirstName.getCssValue("height");
    }

    public String firstNameFieldWidth() {
        return txtFirstName.getCssValue("width");
    }

    public String lastNameFieldHeight() {
        return txtLastName.getCssValue("height");
    }

    public String lastNameFieldWidth() {
        return txtLastName.getCssValue("width");
    }

    public String emailFieldHeight() {
        return txtEmail.getCssValue("height");
    }

    public String emailFieldWidth() {
        return txtEmail.getCssValue("width");
    }

    public String telephoneFieldHeight() {
        return txtTelephone.getCssValue("height");
    }

    public String telephoneFieldWidth() {
        return txtTelephone.getCssValue("width");
    }

    public String passwordFieldHeight() {
        return txtPassword.getCssValue("height");
    }

    public String passwordFieldWidth() {
        return txtPassword.getCssValue("width");
    }

    public String confirmPasswordFieldHeight() {
        return txtConfirmPassword.getCssValue("height");
    }

    public String confirmPasswordFieldWidth() {
        return txtConfirmPassword.getCssValue("width");
    }

    //All Fields Warning is Displayed -----------------------
    public boolean firstNameWarningIsDisplayed() {
        boolean status = false;
        try {
            status = firstNameWarningMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            status = false;
        }
        return status;
    }

    public boolean lastNameWarningIsDisplayed() {
        boolean status = false;
        try {
            status = lastNameWarningMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            status = false;
        }
        return status;
    }

    public boolean emailWarningIsDisplayed() {
        boolean status = false;
        try {
            status = emailWarningMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            status = false;
        }
        return status;
    }

    public boolean telephoneWarningIsDisplayed() {
        boolean status = false;
        try {
            status = telephoneWarningMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            status = false;
        }
        return status;
    }

    public boolean passwordWarningIsDisplayed() {
        boolean status = false;
        try {
            status = passwordWarningMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            status = false;
        }
        return status;
    }

    //Password and confirm password field get type ------------
    public String getPasswordFieldType() {
        return txtPassword.getDomAttribute("type");
    }

    public String getConfirmPasswordFieldType() {
        return txtConfirmPassword.getDomAttribute("type");
    }

}
