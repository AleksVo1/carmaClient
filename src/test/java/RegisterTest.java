import carma.taxi.webPages.HomePage;
import carma.taxi.webPages.RegisterPage;
import carma.taxi.webPages.StartPage;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class RegisterTest extends BasePageTest{
    @Test
    public void testRegister() {
        StartPage startPage = new StartPage(driver);

        open("");
        log.info("Start page is opened.");

        HomePage homePage = new HomePage(driver);
        homePage.addCoordinatesToLocalStorage(driver, 48.152165590996105, 17.129749593985505);

        startPage.clickToRegisterBtn();
        log.info("Clicked on the Register button");

        RegisterPage registerPage = new RegisterPage(driver);

        Assert.assertTrue(registerPage.isRegisterTextDisplayed(), "Register title is not displayed");

        registerPage.registerFlow("Qwerty123");
        log.info("User has successfully entered data.");

        Assert.assertTrue(registerPage.isCodeTextDisplayed(), "4-digit code title is not displayed.");
    }
}
