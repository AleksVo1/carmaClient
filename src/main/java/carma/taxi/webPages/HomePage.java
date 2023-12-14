package carma.taxi.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(css = ".client-marker")
    protected WebElement locationPin;

    @FindBy(xpath = "(//*[@class='styles_AutocompleteWrapper__hpOBF'])[2]")
    protected WebElement destinationField;

    @FindBy(css = ".styles_AutocompleteWrapper__hpOBF .styles_input__LEiCc")
    protected WebElement activeDestinationField;

    By listAddresses = By.cssSelector(".styles_AutocompleteWrapper__hpOBF .styles_suggestion__Y0vSx li");

    @FindBy(css = ".button_size_l__qMlsv")
    protected WebElement applyButton;

    @FindBy(xpath = "//*[@class='button_Button__WIE4L button_background__vUKyV button_size_l__qMlsv']")
    protected WebElement calculateButton;

    @FindBy(css = ".orders_tariffs_form__o4msG .orders_confirm_block__ccb-M button")
    protected WebElement orderButton;

    @FindBy(css = ".orders_search_car_form__7QYTP .orders_main_search_block__9vV2Y .orders_search_car_text__v6QQn")
    protected WebElement searchingText;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLocationPinDisplayed(){
        waitForVisibility(locationPin);
        return locationPin.isDisplayed();
    }

    public void addCoordinatesToLocalStorage(WebDriver driver, double latitude, double longitude) {
        if (driver instanceof JavascriptExecutor) {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

            String coordinatesJSON = String.format("{\"latitude\": %s, \"longitude\": %s}", latitude, longitude);

            String script = String.format("localStorage.setItem('coords', '%s');", coordinatesJSON);

            jsExecutor.executeScript(script);
        }
    }

    public void searchAndSelectRandomAddress(String query){
        waitForVisibility(locationPin);
        destinationField.click();

        activeDestinationField.sendKeys(query);
        selectRandomElement(driver, listAddresses);
    }

    public void clickToApplyBtn(){
        waitForVisibility(applyButton);
        applyButton.click();

    }

    public void clickToCalculateBtn(){
        Actions actions = new Actions(driver);
        actions.moveToElement(calculateButton).pause(2000).click().perform();

    }

    public void clickToOrderBtn(){
        waitForVisibility(orderButton);
        orderButton.click();

    }

    public boolean isSearchingDriverDisplayed(){
        Actions actions = new Actions(driver);
        actions.moveToElement(searchingText).pause(2000).perform();
        return searchingText.isDisplayed();
    }

}
