package selenium.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class PageTest {

    @Test
    public static void homePageTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

        String searchText = "Online Store | My Store";

        driver.get("https://litecart.stqa.ru/en/");

        String title = driver.getTitle();
        Assert.assertEquals(title, searchText);

        Thread.sleep(2000);

        driver.quit();
    }

    @Test
    public static void rubberDucksPageTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

        String searchText = "Rubber Ducks | My Store";

        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksPage = driver.findElement(By.cssSelector(".category-1>a"));
        rubberDucksPage.click();

        String title = driver.getTitle();
        Assert.assertEquals(title, searchText);

        Thread.sleep(2000);

        driver.quit();
    }

    @Test
    public static void subcategoryPageTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

        String searchText = "Subcategory | My Store";

        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksPage = driver.findElement(By.cssSelector(".category-1>a"));
        WebElement subcategoryPage = driver.findElement(By.cssSelector(".category-2>a"));

        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksPage).perform();
        subcategoryPage.click();

        String title = driver.getTitle();
        Assert.assertEquals(title, searchText);

        Thread.sleep(2000);

        driver.quit();
    }

}
