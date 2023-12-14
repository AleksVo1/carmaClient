import carma.taxi.webPages.HomePage;
import carma.taxi.webPages.LoginPage;
import carma.taxi.webPages.StartPage;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class E2E extends BasePageTest{

    @Test
    public void testE2E(){
        StartPage startPage = new StartPage(driver);

        open("/");
        log.info("Start page is opened.");

        startPage.clickToLoginBtn();
        log.info("Clicked on the Login button");

        LoginPage loginPage = new LoginPage(driver);
        log.info("Login page is opened.");

        Assert.assertTrue(loginPage.isAuthorizationTextDisplayed(), "Authorization text is not displayed.");

        loginPage.clickToOpenFlagDropDown();
        log.info("Clicked on the flag drop down.");

        Assert.assertTrue(loginPage.isTurkeyDisplayed(), "Turkey flag is not displayed.");

        loginPage.loginFlow("956726533", "111111");
        log.info("User is logged in successfully.");

        HomePage homePage = new HomePage(driver);

        homePage.addCoordinatesToLocalStorage(driver, 48.152165590996105, 17.129749593985505);
        log.info("Coordinates added to local storage");

        Assert.assertTrue(homePage.isLocationPinDisplayed(), "Location pin is not displayed.");

        homePage.searchAndSelectRandomAddress("bazov");
        log.info("The address is selected.");

        homePage.clickToApplyBtn();
        log.info("Clicked on the Apply button.");

        homePage.clickToCalculateBtn();
        log.info("Clicked on the Calculate button.");

        homePage.clickToOrderBtn();
        log.info("Clicked on the Order button.");

        Assert.assertTrue(homePage.isSearchingDriverDisplayed(), "Searching driver is not displayed.");
        log.info("Search driver page is displayed.");

    }
}
