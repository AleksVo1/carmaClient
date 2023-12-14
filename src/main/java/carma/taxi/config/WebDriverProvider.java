package carma.taxi.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class WebDriverProvider {
    public static WebDriver getDriver(){
        String driverName = ConfigProvider.getDriverName();

        switch (driverName){
            case "chrome":
                return WebDriverManager.chromedriver().create();
            case "firefox":
                return WebDriverManager.firefoxdriver().create();
            case "safari":
                return WebDriverManager.safaridriver().create();
            default:
                throw new  IllegalArgumentException("Unknown webDriver");
        }
    }
}
