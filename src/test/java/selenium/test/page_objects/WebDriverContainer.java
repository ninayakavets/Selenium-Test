package selenium.test.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;


public class WebDriverContainer {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    private static void initDriver() {
        Browser browser = Browser.getEnumByLabel(System.getProperty("browser", Browser.CHROME.getBrowserName()));

        driver = switch (browser) {
            case CHROME -> new ChromeDriver();
            case SAFARI -> new SafariDriver();
        };

        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;

    }
}
