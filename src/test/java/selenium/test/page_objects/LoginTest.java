package selenium.test.page_objects;

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
    public static void openHomePageTest() {
        Assert.assertTrue(LoginPage.hasLoaded());

    }

    @Test
    public static void correctCreditsLoginTest() {
        LoginPage.attemptLogin(correctEmail, correctPassword);
        Assert.assertEquals(LoginPage.getErrorMessageText(), expectedCorrectLoginResultText);
    }

    @Test
    public static void incorrectCreditsLoginTest() {
        LoginPage.attemptLogin(incorrectEmail, incorrectPassword);
        Assert.assertEquals(LoginPage.getErrorMessageText(), expectedIncorrectLoginResultText);
    }

    @Test
    public static void emptyPasswordLoginTest() throws InterruptedException {
        LoginPage.attemptLogin(correctEmail, "");
        Assert.assertEquals(LoginPage.getErrorMessageText(), expectedEmptyPasswordLoginResultText);
    }



}
