package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    protected static String url = "https://litecart.stqa.ru/en/";
    @BeforeMethod
    public static void setup() {
        Configuration.baseUrl = url;
        Configuration.pageLoadTimeout = 5000;
        open(url);
        WebDriver driver = WebDriverRunner.getWebDriver();
    }

}
