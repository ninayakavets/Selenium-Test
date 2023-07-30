package selenium.test.page_objects;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static selenium.test.page_objects.WebDriverContainer.getDriver;
import static selenium.test.page_objects.WebDriverContainer.quitDriver;

public class TestBase {

    private static String url = "https://litecart.stqa.ru/en/";


    @BeforeMethod
    public static void setup() {
        getDriver().get(url);
    }

    @AfterMethod
    public static void teardown() {
        quitDriver();
    }
}
