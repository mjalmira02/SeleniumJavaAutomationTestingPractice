package testCases;

import base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utilities.CommonUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class RegisterPageTest extends TestBase {

    HomePage homePage;
    RegisterPage registerPage;
    AccountSuccessPage accountSuccessPage;
    AccountPage accountPage;
    NewsletterPage newsletterPage;
    LoginPage loginPage;
    EditInformationPage editInformationPage;

    ContactUsPage contactUsPage;
    WishListPage wishListPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void setup() {
        launchBrowser();
        homePage = new HomePage();
        registerPage = new RegisterPage();

        homePage.clickOnMyAccount();
        homePage.selectRegisterOption();
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }

    @Test(priority = 1)
	public void TC_RF_001_verifyRegisterWithMandatoryFields() {
        registerPage.enterFirstName(prop.getProperty("firstName"));
        registerPage.enterLastName(prop.getProperty("lastName"));
        registerPage.enterEmail(CommonUtilities.generateNewEmail());
        registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
        registerPage.enterPassword(prop.getProperty("validPassword"));
        registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
        registerPage.selectPrivacyPolicy();
        accountSuccessPage = registerPage.clickRegisterContinueButton();

        //Verify if the User is sucessfully Register
        Assert.assertTrue(accountSuccessPage.isLogoutOptionIsDisplayed());

        String expHeading = "Your Account Has Been Created!";

        Assert.assertEquals(accountSuccessPage.getPageHeading(), expHeading);

        String expProperDetailsOne = "Congratulations! Your new account has been successfully created!";
        String expProperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
        String expProperDetailsThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
        String expProperDetailsFour = "contact us";

        String actProperDetails = accountSuccessPage.getPageContent();

        //Verify the content of the Pages
        Assert.assertTrue(actProperDetails.contains(expProperDetailsOne));
        Assert.assertTrue(actProperDetails.contains(expProperDetailsTwo));
        Assert.assertTrue(actProperDetails.contains(expProperDetailsThree));
        Assert.assertTrue(actProperDetails.contains(expProperDetailsFour));

        accountPage = accountSuccessPage.clickAccountSuccessContinueButton();

        //Verify is in the Account Page
        Assert.assertTrue(accountPage.isEditYourAccountInformationIsDisplayed());
    }

    @Test(priority = 2)
    public void TC_RF_003_verifyRegisterAccountWithAllFields() {
        registerPage.enterFirstName(prop.getProperty("firstName"));
        registerPage.enterLastName(prop.getProperty("lastName"));
        registerPage.enterEmail(CommonUtilities.generateNewEmail());
        registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
        registerPage.enterPassword(prop.getProperty("validPassword"));
        registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
        registerPage.selectYesNewsLetterOption();
        registerPage.selectPrivacyPolicy();
        accountSuccessPage = registerPage.clickRegisterContinueButton();

        //Verify if the User is sucessfully Register
        Assert.assertTrue(accountSuccessPage.isLogoutOptionIsDisplayed());
        Assert.assertTrue(accountSuccessPage.didWeNavigateToAccountSuccessPage());

        String expHeading = "Your Account Has Been Created!";
        String expProperDetailsOne = "Congratulations! Your new account has been successfully created!";
        String expProperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
        String expProperDetailsThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
        String expProperDetailsFour = "contact us";

        String actProperDetails = accountSuccessPage.getPageContent();

        //Verify the content of the Pages
        Assert.assertTrue(actProperDetails.contains(expHeading));
        Assert.assertTrue(actProperDetails.contains(expProperDetailsOne));
        Assert.assertTrue(actProperDetails.contains(expProperDetailsTwo));
        Assert.assertTrue(actProperDetails.contains(expProperDetailsThree));
        Assert.assertTrue(actProperDetails.contains(expProperDetailsFour));

        accountPage = accountSuccessPage.clickAccountSuccessContinueButton();

        //Verify is in the Account Page
        Assert.assertTrue(accountPage.isEditYourAccountInformationIsDisplayed());
    }

    @Test(priority = 3)
    public void TC_RF_004_verifyRegisterAccountWithoutFillFields() {
        registerPage.clickRegisterContinueButton();

        //Verify the warning message in all fields
        String expFirstNameWarning = "First Name must be between 1 and 32 characters!";
        String expLastNameWarning = "Last Name must be between 1 and 32 characters!";
        String expEmailWarning = "E-Mail Address does not appear to be valid!";
        String expTelephoneWarning = "Telephone must be between 3 and 32 characters!";
        String expPasswordWarning = "Password must be between 4 and 20 characters!";
        String expPrivacyWarning = "Warning: You must agree to the Privacy Policy!";
        Assert.assertEquals(registerPage.getFirstNameWarning(), expFirstNameWarning);
        Assert.assertEquals(registerPage.getLastNameWarning() , expLastNameWarning);
        Assert.assertEquals(registerPage.getEmailWarning() , expEmailWarning);
        Assert.assertEquals(registerPage.getTelephoneWarning() , expTelephoneWarning);
        Assert.assertEquals(registerPage.getPasswordWarning() , expPasswordWarning);
        Assert.assertEquals(registerPage.getPrivacyPolicyWarning() , expPrivacyWarning);
    }

    @Test(priority = 4)
    public void TC_RF_005_verifyRegisterAccountBySubcribingYesToNewsLetter() {
        registerPage.enterFirstName(prop.getProperty("firstName"));
        registerPage.enterLastName(prop.getProperty("lastName"));
        registerPage.enterEmail(CommonUtilities.generateNewEmail());
        registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
        registerPage.enterPassword(prop.getProperty("validPassword"));
        registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
        registerPage.selectYesNewsLetterOption();
        registerPage.selectPrivacyPolicy();
        accountSuccessPage = registerPage.clickRegisterContinueButton();

        accountPage = accountSuccessPage.clickAccountSuccessContinueButton();

        newsletterPage = accountPage.clickSubscribeUnscribeToNewsLetterLink();

        //Verify is the user is in the Newsletter page
        Assert.assertTrue(newsletterPage.didWeNavigateToNewsletterPage());
        //Verify if the subscribe is selected YES
        Assert.assertTrue(newsletterPage.isYesNewsletterOptionSelected());
    }

    @Test(priority = 5)
    public void TC_RF_006_verifyRegisterAccountBySubcribingNoToNewsLetter() {
        registerPage.enterFirstName(prop.getProperty("firstName"));
        registerPage.enterLastName(prop.getProperty("lastName"));
        registerPage.enterEmail(CommonUtilities.generateNewEmail());
        registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
        registerPage.enterPassword(prop.getProperty("validPassword"));
        registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
        registerPage.selectNoNewsLetterOption();
        registerPage.selectPrivacyPolicy();
        accountSuccessPage = registerPage.clickRegisterContinueButton();

        accountPage = accountSuccessPage.clickAccountSuccessContinueButton();

        newsletterPage = accountPage.clickSubscribeUnscribeToNewsLetterLink();

        //Verify is the user is in the Newsletter page
        Assert.assertTrue(newsletterPage.didWeNavigateToNewsletterPage());
        //Verify if the subscribe is selected NO
        Assert.assertTrue(newsletterPage.isNoNewsletterOptionSelected());
    }

    @Test(priority = 6)
    public void TC_RF_007_verifyNavigationToRegisterAccountPageUsingMultipleWay() {
        //Verify if the user is in the Register Page
        Assert.assertTrue(registerPage.didWeNavigateToRegisterPage());

        registerPage.clickOnMyAccount();
        loginPage = registerPage.selectLoginOption();
        registerPage = loginPage.clickNewCustomerContinueButton();
        //Verify if the user is in the Register Page
        Assert.assertTrue(registerPage.didWeNavigateToRegisterPage());

        registerPage.clickOnMyAccount();
        loginPage = registerPage.selectLoginOption();
        registerPage = loginPage.clickRegisterListGroupButton();

        //Verify if the user is in the Register Page
        Assert.assertTrue(registerPage.didWeNavigateToRegisterPage());
    }

    @Test(priority = 7)
    public void TC_RF_008_verifyRegisterAccountByProvidingMismatchPasswords() {
        registerPage.enterFirstName(prop.getProperty("firstName"));
        registerPage.enterLastName(prop.getProperty("lastName"));
        registerPage.enterEmail(CommonUtilities.generateNewEmail());
        registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
        registerPage.enterPassword(prop.getProperty("validPassword"));
        registerPage.enterConfirmPassword(prop.getProperty("mismatchingConfirmPassword"));
        registerPage.selectYesNewsLetterOption();
        registerPage.selectPrivacyPolicy();
        registerPage.clickRegisterContinueButton();

        //Verify if the warning message of mismatch password is Display
        String expConfirmPasswordWarning = "Password confirmation does not match password!";
        Assert.assertEquals(registerPage.getConfirmPasswordWarning(), expConfirmPasswordWarning);
    }

    @Test(priority = 8)
    public void TC_RF_009_verifyRegisterAccountUsingExistingEmail() {
        registerPage.enterFirstName(prop.getProperty("firstName"));
        registerPage.enterLastName(prop.getProperty("lastName"));
        registerPage.enterEmail(prop.getProperty("existingEmail"));
        registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
        registerPage.enterPassword(prop.getProperty("validPassword"));
        registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
        registerPage.selectYesNewsLetterOption();
        registerPage.selectPrivacyPolicy();
        registerPage.clickRegisterContinueButton();

        //Verify if the warning message of existing email is Display
        String expWarningMessage = "Warning: E-Mail Address is already registered!";
        Assert.assertEquals(registerPage.getExistingEmailWarning(), expWarningMessage);
    }

    @Test(priority = 9)
    public void TC_RF_010_verifyRegisterAccountUsingInvalidEmail() throws InterruptedException {
        String browserName = prop.getProperty("browserName");

        registerPage.enterFirstName(prop.getProperty("firstName"));
        registerPage.enterLastName(prop.getProperty("lastName"));
        registerPage.enterEmail(prop.getProperty("invalidEmailOne"));
        registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
        registerPage.enterPassword(prop.getProperty("validPassword"));
        registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
        registerPage.selectYesNewsLetterOption();
        registerPage.selectPrivacyPolicy();
        registerPage.clickRegisterContinueButton();

        Thread.sleep(2000);
        //Verify if the warning message is equal to expected warning message
        if (browserName.equals("chrome") || browserName.equals("edge")) {
            //System.out.println(driver.findElement(By.id("input-email")).getDomProperty("validationMessage"));
            Assert.assertEquals(registerPage.getEmailValidationMessage(),
                    "Please include an '@' in the email address. 'amotoori' is missing an '@'.");
        } else if (browserName.equals("firefox")) {
            //System.out.println(driver.findElement(By.id("input-email")).getDomProperty("validationMessage"));
            Assert.assertEquals(registerPage.getEmailValidationMessage(),
                    "Please enter an email address.");
        }

//        File srcScreenshot1 = driver.findElement(By.xpath("//form[@class='form-horizontal']")).getScreenshotAs(OutputType.FILE);
//        FileHandler.copy(srcScreenshot1, new File(System.getProperty("user.dir")+"\\Screenshots\\sc1Actual.png"));
//
//        Assert.assertFalse(CommonUtilities.compareTwoScreenshots(System.getProperty("user.dir")+"\\Screenshots\\sc1Actual.png", System.getProperty("user.dir")+"\\Screenshots\\sc1Expected.png"));

        registerPage.clearEmailField();
        registerPage.enterEmail(prop.getProperty("invalidEmailTwo"));
        registerPage.clickRegisterContinueButton();

        Thread.sleep(2000);
        //Verify if the warning message is equal to expected warning message
        if (browserName.equals("chrome") || browserName.equals("edge")) {
            Assert.assertEquals(registerPage.getEmailValidationMessage(),
                    "Please enter a part following '@'. 'amotoori@' is incomplete.");
        } else if (browserName.equals("firefox")) {
            Assert.assertEquals(registerPage.getEmailValidationMessage(),
                    "Please enter an email address.");
        }

        registerPage.clearEmailField();
        registerPage.enterEmail(prop.getProperty("invalidEmailThree"));
        registerPage.clickRegisterContinueButton();

        Thread.sleep(2000);
        //Verify if the warning message is equal to expected warning message
        String expWarningOne = "E-Mail Address does not appear to be valid!";
        Assert.assertEquals(registerPage.getEmailWarning(), expWarningOne);

        registerPage.clearEmailField();
        registerPage.enterEmail(prop.getProperty("invalidEmailFour"));
        registerPage.clickRegisterContinueButton();

        Thread.sleep(2000);
        //Verify if the warning message is equal to expected warning message
        if (browserName.equals("chrome") || browserName.equals("edge")) {
            Assert.assertEquals(registerPage.getEmailValidationMessage(),
                    "'.' is used at a wrong position in 'gmail.'.");
        } else if (browserName.equals("firefox")) {
            Assert.assertEquals(registerPage.getEmailValidationMessage(),
                    "Please enter an email address.");
        }
    }

    @Test(priority = 10)
    public void TC_RF_011_verifyRegisterAccountByProvidingInvalidTelephoneNumber() {
        registerPage.enterFirstName(prop.getProperty("firstName"));
        registerPage.enterLastName(prop.getProperty("lastName"));
        registerPage.enterEmail(CommonUtilities.generateNewEmail());
        registerPage.enterTelephoneNumber(prop.getProperty("invalidTelephoneNumber"));
        registerPage.enterPassword(prop.getProperty("validPassword"));
        registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
        registerPage.selectYesNewsLetterOption();
        registerPage.selectPrivacyPolicy();
        registerPage.clickRegisterContinueButton();

        //Verify if the warning is equal to expected warning message
        String expWarningMessage = "Telephone Number does not appear to be valid";
        boolean state = false;

        try {
            String actWarningMessage = registerPage.getTelephoneWarning();
            if (actWarningMessage.equals(expWarningMessage)) {
                state = true;
            }
        } catch (NoSuchElementException e) {
            state = false;
        }
        Assert.assertTrue(state);
    }

    @Test(priority = 11)
    public void TC_RF_12_verifyRegisterAccountUsingKeyboardKeys() {
        Actions actions = new Actions(driver);

        for(int i=1; i<=23; i++) {
            actions.sendKeys(Keys.TAB).perform();
        }

        actions.sendKeys(prop.getProperty("firstName")).pause(Duration.ofSeconds(1))
                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(prop.getProperty("lastName"))
                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(CommonUtilities.generateNewEmail())
                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(prop.getProperty("telephoneNumber"))
                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(prop.getProperty("validPassword"))
                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(prop.getProperty("validPassword"))
                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.LEFT)
                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).build().perform();

        accountSuccessPage = new AccountSuccessPage();
        //Verify if the user is in the account success page
        Assert.assertTrue(accountSuccessPage.isLogoutOptionIsDisplayed());
        Assert.assertTrue(accountSuccessPage.didWeNavigateToAccountSuccessPage());
    }

    @Test(priority = 12)
    public void TC_RF_013_verifyPlaceHoldersOfTextFieldsInRegisterAccountPage() {
        //Verify if the placeholder of first name field is equal to expected placeholder
        String expFirstNamePlaceHolderText = "First Name";
        Assert.assertEquals(registerPage.getPlaceHolderFirstNameField() , expFirstNamePlaceHolderText);
        //Verify if the placeholder of last name field is equal to expected placeholder
        String expLastNamePlaceHolderText = "Last Name";
        Assert.assertEquals(registerPage.getPlaceHolderLastNameField() , expLastNamePlaceHolderText);
        //Verify if the placeholder of email field is equal to expected placeholder
        String expEmailPlaceHolderText = "E-Mail";
        Assert.assertEquals(registerPage.getPlaceHolderEmailField() , expEmailPlaceHolderText);
        //Verify if the placeholder of telephone field is equal to expected placeholder
        String expTelephonePlaceHolderText = "Telephone";
        Assert.assertEquals(registerPage.getPlaceHolderTelephoneField() , expTelephonePlaceHolderText);
        //Verify if the placeholder of password field is equal to expected placeholder
        String expPasswordPlaceHolderText = "Password";
        Assert.assertEquals(registerPage.getPlaceHolderPasswordField() , expPasswordPlaceHolderText);
        //Verify if the placeholder of confirm password field is equal to expected placeholder
        String expConfirmPasswordPlaceHolderText = "Password Confirm";
        Assert.assertEquals(registerPage.getPlaceHolderConfirmPasswordField() , expConfirmPasswordPlaceHolderText);
    }

    @Test(priority = 13)
    public void TC_RF_014_verifyMandatoryFieldsSymbolAndColorInRegisterAccountPage() {
        String expContent = "\"* \"";
        String expColor = "rgb(255, 0, 0)";
        //Verify if the first name label is equal to expected content and color
        Assert.assertEquals(registerPage.getFirstNameLabelContent(), expContent);
        Assert.assertEquals(registerPage.getFirstNameLabelColor(), expColor);
        //Verify if the last name label is equal to expected content and color
        Assert.assertEquals(registerPage.getLastNameLabelContent(), expContent);
        Assert.assertEquals(registerPage.getLastNameLabelColor(), expColor);
        //Verify if the email label is equal to expected content and color
        Assert.assertEquals(registerPage.getEmailLabelContent(), expContent);
        Assert.assertEquals(registerPage.getEmailLabelColor(), expColor);
        //Verify if the telephone label is equal to expected content and color
        Assert.assertEquals(registerPage.getTelephoneLabelContent(), expContent);
        Assert.assertEquals(registerPage.getTelephoneLabelColor(), expColor);
        //Verify if the password label is equal to expected content and color
        Assert.assertEquals(registerPage.getPasswordLabelContent(), expContent);
        Assert.assertEquals(registerPage.getPasswordLabelColor(), expColor);
        //Verify if the confirm password label is equal to expected content and color
        Assert.assertEquals(registerPage.getConfirmPasswordLabelContent(), expContent);
        Assert.assertEquals(registerPage.getConfirmPasswordLabelColor(), expColor);
        //Verify if the privacy policy label is equal to expected content and color
        Assert.assertEquals(registerPage.getPrivacyPolicyLabelContent(), expContent);
        Assert.assertEquals(registerPage.getPrivacyPolicyLabelColor(), expColor);
    }

    @Test(priority = 14)
    public void TC_RF_016_verifyRegisterAccountWithOnlySpaces() {
        registerPage.enterFirstName(" ");
        registerPage.enterLastName(" ");
        registerPage.enterEmail(" ");
        registerPage.enterTelephoneNumber(" ");
        registerPage.enterPassword(" ");
        registerPage.enterConfirmPassword(" ");
        registerPage.selectYesNewsLetterOption();
        registerPage.selectPrivacyPolicy();
        registerPage.clickRegisterContinueButton();

        String expFirstNameWarning = "First Name must be between 1 and 32 characters!";
        String expLastNameWarning = "Last Name must be between 1 and 32 characters!";
        String expEmailWarning = "E-Mail Address does not appear to be valid!";
        String expTelephoneWarning = "Telephone must be between 3 and 32 characters!";
        String expPasswordWarning = "Password must be between 4 and 20 characters!";
        //Verify if all warning message of fields is equal to expected warning message
        Assert.assertEquals(registerPage.getFirstNameWarning(), expFirstNameWarning);
        Assert.assertEquals(registerPage.getLastNameWarning() , expLastNameWarning);
        Assert.assertEquals(registerPage.getEmailWarning() , expEmailWarning);
        Assert.assertEquals(registerPage.getTelephoneWarning() , expTelephoneWarning);
        Assert.assertEquals(registerPage.getPasswordWarning() , expPasswordWarning);
    }

    @Test(priority = 15, dataProvider = "passwordSupplier")
    public void TC_RF_017_verifyRegisterAccountAndCheckingPasswordComplexityStandards(String passwordText) {
        registerPage.enterFirstName(prop.getProperty("firstName"));
        registerPage.enterLastName(prop.getProperty("lastName"));
        registerPage.enterEmail(CommonUtilities.generateNewEmail());
        registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
        registerPage.selectYesNewsLetterOption();
        registerPage.selectPrivacyPolicy();
        registerPage.enterPassword(passwordText);
        registerPage.enterConfirmPassword(passwordText);
        registerPage.clickRegisterContinueButton();

        String warningMessage = "Password entered is not matching the Complexity Standards";
        boolean state = false;

        try {
            String actWarningMessage = registerPage.getPasswordWarning();
            if (actWarningMessage.equals(warningMessage)) {
                state = true;
            }
        } catch (NoSuchElementException e) {
            state = false;
        }

        Assert.assertFalse(state);
        Assert.assertFalse(registerPage.didWeNavigateToRegisterPage());
    }

    @DataProvider(name = "passwordSupplier")
    public Object[][] supplyPasswords() {
        Object[][] data = {{"12345"}, {"abcdefghi"}, {"abcd1234"}, {"abcd123@"}, {"ABCD456#"}};
        return data;
    }

    @Test(priority = 16)
    public void TC_RF_18_verifyRegisterAccountFieldsHeightWidthAlignment() throws IOException {

        String browserName = prop.getProperty("browserName");

        String expHeight = "34px";
        String expWidth = "701.25px";

        //First Name
        String actFirstNameHeight = registerPage.firstNameFieldHeight();
        String actFirstNameWidth = registerPage.firstNameFieldWidth();
        //Verify first name field height and width
        Assert.assertEquals(actFirstNameHeight, expHeight);
        Assert.assertEquals(actFirstNameWidth, expWidth);

        //Verify first name field if the user leave empty the field
        registerPage.enterFirstName("");
        registerPage.clickRegisterContinueButton();
        String expFirstNameWarning = "First Name must be between 1 and 32 characters!";
        Assert.assertEquals(registerPage.getFirstNameWarning() , expFirstNameWarning);

        //Verify first name field if the user enter one character only
        registerPage = new RegisterPage();
        registerPage.clearFirstNameField();
        registerPage.enterFirstName("a");
        registerPage.clickRegisterContinueButton();
        Assert.assertFalse(registerPage.firstNameWarningIsDisplayed());

        //Verify first name field if the user enter two character only
        registerPage = new RegisterPage();
        registerPage.clearFirstNameField();
        registerPage.enterFirstName("ab");
        registerPage.clickRegisterContinueButton();
        Assert.assertFalse(registerPage.firstNameWarningIsDisplayed());

        //Verify first name field if the user enter 16 character only
        registerPage = new RegisterPage();
        registerPage.clearFirstNameField();
        registerPage.enterFirstName("abcdefghijklmnop");
        registerPage.clickRegisterContinueButton();
        Assert.assertFalse(registerPage.firstNameWarningIsDisplayed());

        //Verify first name field if the user enter 32 character only
        registerPage = new RegisterPage();
        registerPage.clearFirstNameField();
        registerPage.enterFirstName("abcdefghijklmnopabcdefghijklmnop");
        registerPage.clickRegisterContinueButton();
        Assert.assertFalse(registerPage.firstNameWarningIsDisplayed());

        //Verify first name field if the user enter more than 32 character only
        registerPage = new RegisterPage();
        registerPage.clearFirstNameField();
        registerPage.enterFirstName("abcdefghijklmnopabcdefghijklmnopqrs");
        registerPage.clickRegisterContinueButton();
        Assert.assertEquals(registerPage.getFirstNameWarning() , expFirstNameWarning);

        // <---------------------------------------------------------------->

        //Last Name
        String actLastNameHeight = registerPage.lastNameFieldHeight();
        String actLastNameWidth = registerPage.lastNameFieldWidth();
        //Verify last name field height and width
        Assert.assertEquals(actLastNameHeight, expHeight);
        Assert.assertEquals(actLastNameWidth, expWidth);

        //Verify last name field if the user leave empty the field
        registerPage = new RegisterPage();
        registerPage.clearLastNameField();
        registerPage.enterLastName("");
        registerPage.clickRegisterContinueButton();
        String expLastNameWarning = "Last Name must be between 1 and 32 characters!";
        Assert.assertEquals(registerPage.getLastNameWarning() , expLastNameWarning);

        //Verify last name field if the user enter one character only
        registerPage = new RegisterPage();
        registerPage.clearLastNameField();
        registerPage.enterLastName("a");
        registerPage.clickRegisterContinueButton();
        Assert.assertFalse(registerPage.lastNameWarningIsDisplayed());

        //Verify last name field if the user enter two character only
        registerPage = new RegisterPage();
        registerPage.clearLastNameField();
        registerPage.enterLastName("ab");
        registerPage.clickRegisterContinueButton();
        Assert.assertFalse(registerPage.lastNameWarningIsDisplayed());

        //Verify last name field if the user enter 16 character only
        registerPage = new RegisterPage();
        registerPage.clearLastNameField();
        registerPage.enterLastName("abcdefghijklmnop");
        registerPage.clickRegisterContinueButton();
        Assert.assertFalse(registerPage.lastNameWarningIsDisplayed());

        //Verify last name field if the user enter 32 character only
        registerPage = new RegisterPage();
        registerPage.clearLastNameField();
        registerPage.enterLastName("abcdefghijklmnopabcdefghijklmnop");
        registerPage.clickRegisterContinueButton();
        Assert.assertFalse(registerPage.lastNameWarningIsDisplayed());

        //Verify last name field if the user enter more than 32 character only
        registerPage = new RegisterPage();
        registerPage.clearLastNameField();
        registerPage.enterLastName("abcdefghijklmnopabcdefghijklmnopqrs");
        registerPage.clickRegisterContinueButton();
        Assert.assertEquals(registerPage.getLastNameWarning() , expLastNameWarning);

        // <---------------------------------------------------------------->

        //Email
        String actEmailHeight = registerPage.emailFieldHeight();
        String actEmailWidth = registerPage.emailFieldWidth();
        //Verify email field height and width
        Assert.assertEquals(actEmailHeight, expHeight);
        Assert.assertEquals(actEmailWidth, expWidth);

        //Verify email field should not have limit
        registerPage = new RegisterPage();
        registerPage.clearEmailField();
        registerPage.enterEmail("abcdefghijklmnopabcdefghijklmnopqabcdefghijklmnopabcdefghijklmno@gmail.com");
        registerPage.clickRegisterContinueButton();
        Assert.assertFalse(registerPage.emailWarningIsDisplayed());

        // <---------------------------------------------------------------->

        //Telephone
        String actTelephoneHeight = registerPage.telephoneFieldHeight();
        String actTelephoneWidth = registerPage.telephoneFieldWidth();
        //Verify telephone field height and width
        Assert.assertEquals(actTelephoneHeight, expHeight);
        Assert.assertEquals(actTelephoneWidth, expWidth);

        //Verify password field if the user leave empty the field
        registerPage = new RegisterPage();
        registerPage.clearTelephoneField();
        registerPage.enterTelephoneNumber("");
        registerPage.clickRegisterContinueButton();
        String expTelephoneWarning = "Telephone must be between 3 and 32 characters!";
        Assert.assertEquals(registerPage.getTelephoneWarning() , expTelephoneWarning);

        //Verify telephone field if the user enter one character only
        registerPage = new RegisterPage();
        registerPage.clearTelephoneField();
        registerPage.enterTelephoneNumber("a");
        registerPage.clickRegisterContinueButton();
        Assert.assertEquals(registerPage.getTelephoneWarning() , expTelephoneWarning);

        //Verify telephone field if the user enter two character only
        registerPage = new RegisterPage();
        registerPage.clearTelephoneField();
        registerPage.enterTelephoneNumber("ab");
        registerPage.clickRegisterContinueButton();
        Assert.assertEquals(registerPage.getTelephoneWarning() , expTelephoneWarning);

        //Verify telephone field if the user enter three character only
        registerPage = new RegisterPage();
        registerPage.clearTelephoneField();
        registerPage.enterTelephoneNumber("abc");
        registerPage.clickRegisterContinueButton();
        Assert.assertFalse(registerPage.telephoneWarningIsDisplayed());

        //Verify telephone field if the user enter four character only
        registerPage = new RegisterPage();
        registerPage.clearTelephoneField();
        registerPage.enterTelephoneNumber("abcd");
        registerPage.clickRegisterContinueButton();
        Assert.assertFalse(registerPage.telephoneWarningIsDisplayed());

        //Verify telephone field if the user enter 16 character only
        registerPage = new RegisterPage();
        registerPage.clearTelephoneField();
        registerPage.enterTelephoneNumber("abcdefghijklmnop");
        registerPage.clickRegisterContinueButton();
        Assert.assertFalse(registerPage.telephoneWarningIsDisplayed());

        //Verify telephone field if the user enter 32 character only
        registerPage = new RegisterPage();
        registerPage.clearTelephoneField();
        registerPage.enterTelephoneNumber("abcdefghijklmnopabcdefghijklmnop");
        registerPage.clickRegisterContinueButton();
        Assert.assertFalse(registerPage.telephoneWarningIsDisplayed());

        //Verify telephone field if the user enter more than 32 character only
        registerPage = new RegisterPage();
        registerPage.clearTelephoneField();
        registerPage.enterTelephoneNumber("abcdefghijklmnopabcdefghijklmnopqrs");
        registerPage.clickRegisterContinueButton();
        Assert.assertEquals(registerPage.getTelephoneWarning() , expTelephoneWarning);

        // <---------------------------------------------------------------->

        //Password
        String actPasswordHeight = registerPage.passwordFieldHeight();
        String actPasswordWidth = registerPage.passwordFieldWidth();
        //Verify password field height and width
        Assert.assertEquals(actPasswordHeight, expHeight);
        Assert.assertEquals(actPasswordWidth, expWidth);

        //Verify password field if the user leave empty the field
        registerPage = new RegisterPage();
        registerPage.clearPasswordField();
        registerPage.enterPassword("");
        registerPage.clickRegisterContinueButton();
        String expPasswordWarning = "Password must be between 4 and 20 characters!";
        Assert.assertEquals(registerPage.getPasswordWarning() , expPasswordWarning);

        //Verify password field if the user enter one character only
        registerPage = new RegisterPage();
        registerPage.clearPasswordField();
        registerPage.enterPassword("a");
        registerPage.clickRegisterContinueButton();
        Assert.assertEquals(registerPage.getPasswordWarning() , expPasswordWarning);

        //Verify password field if the user enter two character only
        registerPage = new RegisterPage();
        registerPage.clearPasswordField();
        registerPage.enterPassword("ab");
        registerPage.clickRegisterContinueButton();
        Assert.assertEquals(registerPage.getPasswordWarning() , expPasswordWarning);

        //Verify password field if the user enter three character only
        registerPage = new RegisterPage();
        registerPage.clearPasswordField();
        registerPage.enterPassword("abc");
        registerPage.clickRegisterContinueButton();
        Assert.assertEquals(registerPage.getPasswordWarning() , expPasswordWarning);

        //Verify password field if the user enter four character only
        registerPage = new RegisterPage();
        registerPage.clearPasswordField();
        registerPage.enterPassword("abcd");
        registerPage.clickRegisterContinueButton();
        Assert.assertFalse(registerPage.passwordWarningIsDisplayed());

        //Verify password field if the user enter five character only
        registerPage = new RegisterPage();
        registerPage.clearPasswordField();
        registerPage.enterPassword("abcde");
        registerPage.clickRegisterContinueButton();
        Assert.assertFalse(registerPage.passwordWarningIsDisplayed());

        //Verify password field if the user enter 10 character only
        registerPage = new RegisterPage();
        registerPage.clearPasswordField();
        registerPage.enterPassword("abcdefghij");
        registerPage.clickRegisterContinueButton();
        Assert.assertFalse(registerPage.passwordWarningIsDisplayed());

        //Verify password field if the user enter 19 character only
        registerPage = new RegisterPage();
        registerPage.clearPasswordField();
        registerPage.enterPassword("abcdefghijabcdefghi");
        registerPage.clickRegisterContinueButton();
        Assert.assertFalse(registerPage.passwordWarningIsDisplayed());

        //Verify password field if the user enter 20 character only
        registerPage = new RegisterPage();
        registerPage.clearPasswordField();
        registerPage.enterPassword("abcdefghijabcdefghij");
        registerPage.clickRegisterContinueButton();
        Assert.assertFalse(registerPage.passwordWarningIsDisplayed());

        //Verify password field if the user enter more than 21 character only
        registerPage = new RegisterPage();
        registerPage.clearPasswordField();
        registerPage.enterPassword("abcdefghijabcdefghijk");
        registerPage.clickRegisterContinueButton();
        Assert.assertEquals(registerPage.getPasswordWarning(), expPasswordWarning);

        // <---------------------------------------------------------------->

        //Confirm Password
        String actConfirmPasswordHeight = registerPage.confirmPasswordFieldHeight();
        String actConfirmPasswordWidth = registerPage.confirmPasswordFieldWidth();
        //Verify confirm password field height and width
        Assert.assertEquals(actConfirmPasswordHeight, expHeight);
        Assert.assertEquals(actConfirmPasswordWidth, expWidth);

        // <---------------------------------------------------------------->
        navigateToRegisterPage(prop.getProperty("registerPageURL"));
        driver = CommonUtilities.takeScreenshot(driver, "\\Screenshots\\registerPageActualAlignment.png");

        if (browserName.equals("chrome")) {
            Assert.assertFalse(CommonUtilities.compareTwoScreenshots(
                    System.getProperty("user.dir") + "\\Screenshots\\registerPageActualAlignment.png",
                    System.getProperty("user.dir") + "\\Screenshots\\registerPageChromeExpectedAlignment.png"));
        } else if (browserName.equals("firefox")) {
            Assert.assertFalse(CommonUtilities.compareTwoScreenshots(
                    System.getProperty("user.dir") + "\\Screenshots\\registerPageActualAlignment.png",
                    System.getProperty("user.dir") + "\\Screenshots\\registerPageFireFoxExpectedAlignment.png"));
        } else if (browserName.equals("edge")) {
            Assert.assertFalse(CommonUtilities.compareTwoScreenshots(
                    System.getProperty("user.dir") + "\\Screenshots\\registerPageActualAlignment.png",
                    System.getProperty("user.dir") + "\\Screenshots\\registerPageEdgeExpectedAlignment.png"));
        }
    }

    @Test(priority = 17)
    public void TC_RF_19_verifyLeadingAndTrailSpacesWhileRegisteringAccount() {
        String enteredFirstName = "     Maria Leonora     ";
        String enteredLastName = "     Theresa     ";
        String enteredEmail = "     "+CommonUtilities.generateNewEmail()+"     ";
        String enteredTelephone = "     09123456789     ";

        registerPage.enterFirstName(enteredFirstName);
        registerPage.enterLastName(enteredLastName);
        registerPage.enterEmail(enteredEmail);
        registerPage.enterTelephoneNumber(enteredTelephone);
        registerPage.enterPassword(prop.getProperty("validPassword"));
        registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
        registerPage.selectYesNewsLetterOption();
        registerPage.selectPrivacyPolicy();
        accountSuccessPage = registerPage.clickRegisterContinueButton();
        accountPage = accountSuccessPage.clickAccountSuccessContinueButton();
        editInformationPage = accountPage.clickEditYourAccountInformation();

        //Verify if the Enter Text is trim or no space in the edit information page
        Assert.assertEquals(editInformationPage.getFirstNameFieldValue() , enteredFirstName.trim());
        Assert.assertEquals(editInformationPage.getLastNameFieldValue(), enteredLastName.trim());
        Assert.assertEquals(editInformationPage.getEmailFieldValue() , enteredEmail.trim());
        Assert.assertEquals(editInformationPage.getTelephoneFieldValue() , enteredTelephone.trim());
    }

    @Test(priority = 18)
    public void TC_RF_020_verifyPrivacyPolicyFieldOnRegisterAccountPage() {
        Assert.assertFalse(registerPage.isPrivacyPolicySelected());
    }

    @Test(priority = 19)
    public void TC_RF_021_verifyRegisterAccountWithoutPrivacyPolicySelection() {
        registerPage.enterFirstName(prop.getProperty("firstName"));
        registerPage.enterLastName(prop.getProperty("lastName"));
        registerPage.enterEmail(CommonUtilities.generateNewEmail());
        registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
        registerPage.enterPassword(prop.getProperty("validPassword"));
        registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
        registerPage.selectYesNewsLetterOption();
        registerPage.clickRegisterContinueButton();

        String expPolicyWarning = "Warning: You must agree to the Privacy Policy!";
        Assert.assertEquals(registerPage.getPrivacyPolicyWarning() , expPolicyWarning);
    }

    @Test(priority = 20)
    public void TC_RF_022_verifyVisibilityTogglelineOfPasswordsFieldsOnRegisterAccountPage() {
        registerPage.enterPassword(prop.getProperty("validPassword"));
        registerPage.enterConfirmPassword(prop.getProperty("validPassword"));

        Assert.assertEquals(registerPage.getPasswordFieldType() , "password");
        Assert.assertEquals(registerPage.getConfirmPasswordFieldType() , "password");
    }

    @Test(priority = 21)
    public void TC_RF_023_verifyWorkingOfEveryLinkOnRegisterAccountPage() {
        // <-------------- Navigation bar -------------->

        //Verify the 123456789 navigation bar
        contactUsPage = registerPage.clickOnPhoneIcon();
        Assert.assertTrue(contactUsPage.didWeNavigateToContactUsPage());
        navigateBack();

        //Verify the Wish List(0) navigation bar
        registerPage = new RegisterPage();
        wishListPage = registerPage.clickOnWishList();
        Assert.assertTrue(wishListPage.didWeNavigateToLoginPage());
        navigateBack();

        //Verify the Shopping Cart navigation bar
        registerPage = new RegisterPage();
        shoppingCartPage = registerPage.clickOnShoppingCart();
        Assert.assertTrue(shoppingCartPage.didWeNavigateToShoppingCartPage());
        navigateBack();

        //Verify Checkout navigation bar
        registerPage = new RegisterPage();
        checkoutPage = registerPage.clickOnCheckout();
        driver.findElement(By.xpath("//span[text()='Checkout']")).click();
        Assert.assertTrue(checkoutPage.didWeNavigateToShoppingCartPage());
        navigateBack();

        // <-------------- Menu Option -------------->

        //Verify the Qafox.com logo page
        registerPage = new RegisterPage();
        registerPage.clickLogoOption();
        Assert.assertEquals(driver.getCurrentUrl() , prop.getProperty("homePageURL"));
        navigateBack();

        //Verify the search button
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Search']")).isDisplayed());
        driver.navigate().back();

        // <-------------- Bread Crumbs -------------->

        //Verify Register page in bread crumb
        driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());

        //Verify Account page in bread crumb
        driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Account']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify Icon home page in bread crumb
        driver.findElement(By.xpath("//ul[@class='breadcrumb']//i[@class='fa fa-home']")).click();
        Assert.assertEquals(driver.getCurrentUrl() ,"https://tutorialsninja.com/demo/index.php?route=common/home");
        driver.navigate().back();

        // <-------------- Page Link -------------->

        //Verify login page link
        driver.findElement(By.xpath("//a[text()='login page']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify Policy Privacy link
        driver.findElement(By.xpath("//a[@class='agree']//b[text()='Privacy Policy']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement xOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='×']")));
        Assert.assertTrue(xOption.isDisplayed());
        xOption.click();

        //Verify the register page with warning messages
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());
        driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).click();

        // <-------------- List Group Item -------------->

        //Verify login page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Login']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify register page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Register']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());
        driver.navigate().back();

        //Verify forgotten password page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Forgotten Password']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Forgotten Password']")).isDisplayed());

        //Verify my account page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='My Account']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify address book page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Address Book']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify wish list page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Wish List']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify order history page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Order History']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify download page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Downloads']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify Recurring payments page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Recurring payments']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify Reward Points page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Reward Points']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify Returns page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Returns']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify Transactions page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Transactions']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify Newsletter page in the list
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Newsletter']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        // <-------------- Footer Option -------------->

        //Verify About Us page in the footer
        driver.findElement(By.linkText("About Us")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='About Us']")).isDisplayed());
        driver.navigate().back();

        //Verify Delivery Information page in the footer
        driver.findElement(By.linkText("Delivery Information")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Delivery Information']")).isDisplayed());
        driver.navigate().back();

        //Verify Privacy Policy page in the footer
        driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[text()='Privacy Policy']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Privacy Policy']")).isDisplayed());
        driver.navigate().back();

        //Verify Terms & Conditions page in the footer
        driver.findElement(By.linkText("Terms & Conditions")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Terms & Conditions']")).isDisplayed());
        driver.navigate().back();

        //Verify Contact Us page in the footer
        driver.findElement(By.linkText("Contact Us")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Contact Us']")).isDisplayed());
        driver.navigate().back();

        //Verify Returns page in the footer
        driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[text()='Returns']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Product Returns']")).isDisplayed());
        driver.navigate().back();

        //Verify Site Map page in the footer
        driver.findElement(By.linkText("Site Map")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Site Map']")).isDisplayed());
        driver.navigate().back();

        //Verify Brands page in the footer
        driver.findElement(By.linkText("Brands")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Brand']")).isDisplayed());
        driver.navigate().back();

        //Verify Gift Certificates page in the footer
        driver.findElement(By.linkText("Gift Certificates")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Gift Certificate']")).isDisplayed());
        driver.navigate().back();

        //Verify Affiliate page in the footer
        driver.findElement(By.linkText("Affiliate")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify Specials page in the footer
        driver.findElement(By.linkText("Specials")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Special Offers']")).isDisplayed());
        driver.navigate().back();

        //Verify My Account page in the footer
        driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[text()='My Account']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify Order History page in the footer
        driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[text()='Order History']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify Wish List page in the footer
        driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[text()='Wish List']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify Newsletter page in the footer
        driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[text()='Newsletter']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
        driver.navigate().back();

        //Verify OpenCart link in the footer
        driver.findElement(By.linkText("OpenCart")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='navbar-brand']//img[@title='OpenCart - Open Source Shopping Cart Solution']")).isDisplayed());
        driver.navigate().back();
    }

    @Test(priority = 22)
    public void TC_RF_024_verifyRegisterAccountWithoutEnteringPasswordIntoConfirmPasswordField() {
        registerPage.enterFirstName(prop.getProperty("firstName"));
        registerPage.enterLastName(prop.getProperty("lastName"));
        registerPage.enterEmail(CommonUtilities.generateNewEmail());
        registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
        registerPage.enterPassword(prop.getProperty("validPassword"));
        registerPage.selectYesNewsLetterOption();
        registerPage.selectPrivacyPolicy();
        registerPage.clickRegisterContinueButton();

        //Verify the warning message of Confirm Password if display
        String expConfirmPasswordWarning = "Password confirmation does not match password!";
        Assert.assertEquals(registerPage.getConfirmPasswordWarning() , expConfirmPasswordWarning);
    }

    @Test(priority = 23)
    public void TC_RF_025_verifyBreadcrumbURLHeadingTitleOfRegisterAccountPage() {
        //Verify the breadcrumb is display in the Register Account page
        Assert.assertTrue(registerPage.didWeNavigateToRegisterPage());

        //Verify the Proper Heading of Register Account is display in the Register Account page
        String expHeading = "Register Account";
        Assert.assertEquals(registerPage.getProperRegisterPageHeading(), expHeading);

        //Verify the URL of Register Account Page
        String expURL = "https://tutorialsninja.com/demo/index.php?route=account/register";
        Assert.assertEquals(driver.getCurrentUrl() , expURL);

        //Verify the Title Page of Register Account Page
        String expTitlePage = "Register Account";
        Assert.assertEquals(driver.getTitle() , expTitlePage);
    }

}
