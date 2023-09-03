package selenium.test.page_objects;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {
    private static String correctEmail = "nina.yakovets@gmail.com";
    private static String correctPassword = "RubberDucks@123";
    private static String expectedCorrectLoginResultText = "You are now logged in as Nina Yakavets.";
    private static String incorrectEmail = "nina.yakovets@gmail";
    private static String incorrectPassword = "RubberDucks";
    private static String expectedIncorrectLoginResultText = "Wrong password or the account is disabled, or does not exist";
    private static String expectedEmptyPasswordLoginResultText = "You must provide both email address and password.";


    @Test
    @Feature(value = "Login page")
    @Story(value = "Login")
    @Description(value = "Test checks correct loading of homePage")
    public static void openHomePageTest()throws InterruptedException  {
        Assert.assertTrue(LoginPage.hasLoaded());

    }

    @Test
    @Feature(value = "Login page")
    @Story(value = "Login")
    @Description(value = "Test checks login with correct credentials")
    public static void correctCreditsLoginTest() throws InterruptedException {
        LoginPage.attemptLogin(correctEmail, correctPassword);
        Assert.assertEquals(expectedCorrectLoginResultText, LoginPage.getErrorMessageText());
    }

    @Test
    @Feature(value = "Login page")
    @Story(value = "Login errors")
    @Description(value = "Test checks login with incorrect credentials")
    public static void incorrectCreditsLoginTest() {
        LoginPage.attemptLogin(incorrectEmail, incorrectPassword);
        Assert.assertEquals(LoginPage.getErrorMessageText(), expectedIncorrectLoginResultText);
    }

    @Test
    @Feature(value = "Login page")
    @Story(value = "Login errors")
    @Description(value = "Test checks login with empty password filed")
    public static void emptyPasswordLoginTest() throws InterruptedException {
        LoginPage.attemptLogin(correctEmail, "");
        Assert.assertEquals(LoginPage.getErrorMessageText(), expectedEmptyPasswordLoginResultText);
    }


}
