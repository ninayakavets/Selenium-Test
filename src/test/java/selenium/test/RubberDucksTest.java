package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.IMethodSelector;

import java.time.Duration;

public class RubberDucksTest {

    @Test
    public static void correctCreditsLoginTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        String correctEmail = "nina.yakovets@gmail.com";
        String correctPassword = "RubberDucks@123";
        String expectedLoginResultText = "You are now logged in as Nina Yakavets.";

        driver.get("https://litecart.stqa.ru/en/");
        WebElement email = driver.findElement(By.cssSelector("[name='email']"));
        email.sendKeys(correctEmail);

        WebElement password = driver.findElement(By.cssSelector("[name='password']"));
        password.sendKeys(correctPassword);

        WebElement loginButton = driver.findElement(By.cssSelector("[name = 'login']"));
        loginButton.click();

        WebElement loginResult = driver.findElement(By.cssSelector(".notice"));
        String loginResultText = loginResult.getText();

        Assert.assertEquals(loginResultText, expectedLoginResultText);

        Thread.sleep(2000);

        driver.quit();
    }
    @Test
    public static void incorrectCreditsLoginTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        String incorrectEmail = "nina.yakovets@gmail";
        String incorrectPassword = "RubberDucks";
        String expectedLoginResultText = "Wrong password or the account is disabled, or does not exist";

        driver.get("https://litecart.stqa.ru/en/");
        WebElement email = driver.findElement(By.cssSelector("[name='email']"));
        email.sendKeys(incorrectEmail);

        WebElement password = driver.findElement(By.cssSelector("[name='password']"));
        password.sendKeys(incorrectPassword);

        WebElement loginButton = driver.findElement(By.cssSelector("[name = 'login']"));
        loginButton.click();

        WebElement loginResult = driver.findElement(By.cssSelector(".notice"));
        String loginResultText = loginResult.getText();

        Assert.assertEquals(loginResultText, expectedLoginResultText);

        Thread.sleep(2000);

        driver.quit();
    }

    @Test
    public static void emptyPasswordLoginTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        String correctEmail = "nina.yakovets@gmail.com";
        String expectedLoginResultText = "You must provide both email address and password.";

        driver.get("https://litecart.stqa.ru/en/");

        WebElement email = driver.findElement(By.cssSelector("[name='email']"));
        email.sendKeys(correctEmail);

        WebElement loginButton = driver.findElement(By.cssSelector("[name = 'login']"));
        loginButton.click();

        WebElement loginResult = driver.findElement(By.cssSelector(".notice"));
        String loginResultText = loginResult.getText();

        Assert.assertEquals(loginResultText, expectedLoginResultText);

        Thread.sleep(2000);

        driver.quit();
    }

    @Test
    public static void openYellowDuckFromCatalogTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        String expectedTitle = "Yellow Duck | Subcategory | Rubber Ducks | My Store";

        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksPage = driver.findElement(By.cssSelector(".category-1>a"));
        rubberDucksPage.click();

        WebElement yellowDuck = driver.findElement(By.cssSelector("a.link[title='Yellow Duck']"));
        yellowDuck.click();

        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

        Thread.sleep(2000);

        driver.quit();
    }

    @Test
    public static void correctAddYellowDuckToCartTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        String expectedCartItem = "Yellow Duck";

        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksPage = driver.findElement(By.cssSelector(".category-1>a"));
        rubberDucksPage.click();

        WebElement yellowDuck = driver.findElement(By.cssSelector("a.link[title='Yellow Duck']"));
        yellowDuck.click();

        WebElement smallYellowDuck = driver.findElement(By.cssSelector("select>option[value='Small']"));
        smallYellowDuck.click();

        WebElement addToCart = driver.findElement(By.cssSelector(".quantity button[name='add_cart_product'] "));
        addToCart.click();
        Thread.sleep(2000);

        WebElement cart =  driver.findElement(By.cssSelector("#cart > a.content"));
        cart.click();


        String cartItem = driver.findElement(By.cssSelector("#order_confirmation-wrapper > table > tbody > tr:nth-child(2) > td.item")).getText();

        Assert.assertEquals(cartItem, expectedCartItem);


        Thread.sleep(2000);

        driver.quit();
    }

}
