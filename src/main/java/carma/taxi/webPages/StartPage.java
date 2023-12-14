package carma.taxi.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage{

    @FindBy(xpath = "//*[@href='/auth']")
    protected WebElement loginBtn;

    @FindBy(xpath = "//*[@href='/registration']")
    protected WebElement registerBtn;

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public void clickToLoginBtn(){
        waitForVisibility(loginBtn);
        loginBtn.click();
    }

    public void clickToRegisterBtn(){
        waitForVisibility(registerBtn);
        registerBtn.click();
    }
}
