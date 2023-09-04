package selenium.test.page_objects;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class WebDriverContainer {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                initDriver();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        return driver;
    }

    private static void initDriver() throws MalformedURLException {
        Browser browser = Browser.getEnumByLabel(System.getProperty("browser", Browser.CHROME.getBrowserName()));

        String platform = System.getProperty("platform", "mac");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName(browser.getBrowserName());

        switch (platform){
            case "windows" ->caps.setPlatform(Platform.WINDOWS);
            case "mac" -> caps.setPlatform(Platform.MAC);
        }

        driver = new RemoteWebDriver(new URL("http://10.65.144.139:4444/wd/hub"), caps);

       // driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;

    }
}
