package carma.taxi.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(css = ".CountrySelectorWrapper .input-class__btn")
    protected WebElement flagDropDown;

    @FindBy(xpath = "//*[@class='Input_input__Vnl8Q']")
    protected WebElement phoneField;

    @FindBy(css = ".css-jobib5")
    protected WebElement iAgree;

    @FindBy(css = ".button_fullWidth__qnL3w")
    protected WebElement continueBtn;

    @FindBy(css = ".Input_input__Vnl8Q")
    protected WebElement passwordField;

    @FindBy(css = ".button_fullWidth__qnL3w")
    protected WebElement continueBtn2;

    @FindBy(css = ".PageHeader_title__qKudp")
    protected WebElement authorizationText;

    @FindBy(xpath = "//*[text()='Turkey']")
    protected WebElement turkeyFlag;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickToOpenFlagDropDown(){
        waitForVisibility(flagDropDown);
        flagDropDown.click();
    }

    public void clickToPhoneField(){
        waitForVisibility(phoneField);
        phoneField.click();
    }

    public void switchOnTerms(){
        waitForVisibility(iAgree);
        iAgree.click();
    }

    public void clickToContinueBtn(){
        waitForVisibility(continueBtn);
        continueBtn.click();
    }

    public void clickToPasswordField(){
        waitForVisibility(passwordField);
        passwordField.click();
    }

    public void clickToContinueBtn2(){
        waitForVisibility(continueBtn2);
        continueBtn2.click();
    }

    public void loginFlow(String phone, String password){
        waitForVisibility(phoneField);
        phoneField.click();
        enterText(phoneField, phone);

        waitForVisibility(iAgree);
        iAgree.click();

        waitForVisibility(continueBtn);
        continueBtn.click();

        waitForVisibility(passwordField);
        passwordField.click();
        enterText(passwordField, password);

        waitForVisibility(continueBtn2);
        continueBtn2.click();
    }

    public boolean isAuthorizationTextDisplayed(){
        waitForVisibility(authorizationText);
        return authorizationText.isDisplayed();
    }

    public boolean isTurkeyDisplayed(){
        waitForVisibility(turkeyFlag);
        return turkeyFlag.isDisplayed();
    }
}
