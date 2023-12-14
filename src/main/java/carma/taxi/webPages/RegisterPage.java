package carma.taxi.webPages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
    @FindBy(css = ".PageHeader_title__qKudp")
    protected WebElement registerTitle;

    @FindBy(xpath = "(//*[@class='Input_input__Vnl8Q'])[1]")
    protected WebElement phoneNumber;

    @FindBy(xpath = "(//*[@class='Input_input__Vnl8Q'])[2]")
    protected WebElement password;

    @FindBy(xpath = "(//*[@class='Input_input__Vnl8Q'])[3]")
    protected WebElement firstName;

    @FindBy(xpath = "(//*[@class='Input_input__Vnl8Q'])[4]")
    protected WebElement lastName;

    @FindBy(xpath = "(//*[@class='Input_input__Vnl8Q'])[5]")
    protected WebElement email;

    @FindBy(css = ".css-1nr2wod .MuiSwitch-input")
    protected WebElement iAgree;

    @FindBy(css = ".button_fullWidth__qnL3w")
    protected WebElement continueBtn;

    @FindBy(css = ".PageHeader_title__qKudp")
    protected WebElement codeText;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void registerFlow(String password1){
        Faker faker = new Faker();

        String emailGenerator = generateRandomEmail();

        waitForVisibility(phoneNumber);
        phoneNumber.click();
        String phoneNumberF = faker.phoneNumber().phoneNumber();
        phoneNumber.sendKeys(phoneNumberF);

        password.click();
        password.sendKeys(password1);

        firstName.click();
        String firstNameF = faker.name().firstName();
        firstName.sendKeys(firstNameF);

        lastName.click();
        String lstNameF = faker.name().lastName();
        firstName.sendKeys(lstNameF);

        email.click();
        email.sendKeys(emailGenerator);

        iAgree.click();

        waitForVisibility(continueBtn);
        continueBtn.click();
    }

    public boolean isRegisterTextDisplayed(){
        waitForVisibility(registerTitle);
        return registerTitle.isDisplayed();
    }

    public boolean isCodeTextDisplayed(){
        waitForVisibility(codeText);
        return codeText.isDisplayed();
    }
}
