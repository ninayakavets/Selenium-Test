package selenium.test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class MyTest {

    @Test
    public static void firstSeleniumTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> elements = driver.findElement(By.id("content")).findElements(By.tagName("a"));
        elements.get(9).click();
        driver.quit();
    }

    @Test
    public static void ducksSearchTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

        String searchText = "Purple";

        driver.get("https://litecart.stqa.ru/en/");

        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));

        searchField.sendKeys(searchText);
        searchField.sendKeys(Keys.ENTER);

        WebElement detailsTab = driver.findElement(By.cssSelector(".tabs a[href$='tab-details']"));
        detailsTab.click();

        WebElement bodyColorLabel = driver.findElement(By.xpath("//*[@id='tab-details']//*[text()='Body:']/following-sibling::td"));
        Assert.assertEquals(bodyColorLabel.getText(), searchText);

        Thread.sleep(2000);

        driver.quit();

    }


}
