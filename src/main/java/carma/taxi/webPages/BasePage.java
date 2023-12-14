package carma.taxi.webPages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static carma.taxi.config.ConfigProvider.BASE_URL;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void open(String path) {
        driver.get(BASE_URL + path);
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public void waitForVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void enterText(WebElement element, String text) {
        Actions actions = new Actions(driver);
        actions.click(element)
                .sendKeys(Keys.chord(Keys.CONTROL, ""), Keys.DELETE)
                .sendKeys(text)
                .perform();

    }

    public void selectRandomElement(WebDriver driver, By locator) {
        List<WebElement> options = driver.findElements(locator);

        if (!options.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(options.size());
            options.get(randomIndex).click();

            System.out.println("Selected random option: " + options.get(randomIndex).getText());
        } else {
            System.out.println("The list is empty or options not found.");
        }
    }

    public String generateRandomEmail() {
        String domain = "mailinator.com";
        String username = RandomStringUtils.randomAlphanumeric(5);
        String email = username + "@" + domain;
        return email;
    }
}


