package selenium.test.page_objects;

import org.openqa.selenium.By;
import selenium.test.page_objects.locators.Locators;

import static selenium.test.page_objects.WebDriverContainer.getDriver;


public class LoginPage extends PageBase {
    static String title = "Online Store | My Store";
    private static By emailInput = Locators.getLocator("LoginPage.emailInput");
    private static By passwordInput = Locators.getLocator("LoginPage.passwordInput");
    private static By loginButton = Locators.getLocator("LoginPage.loginButton");
    private static By errorMessage = Locators.getLocator("LoginPage.errorMessage");

    public static void attemptLogin( String email, String password){
        getDriver().findElement(emailInput).sendKeys(email);
        getDriver().findElement(passwordInput).sendKeys(password);
        getDriver().findElement(loginButton).click();
    }

    public static String getErrorMessageText(){

        String errorMessageText = getDriver().findElement(errorMessage).getText();

        return errorMessageText;
    }

    public static boolean hasLoaded(){
        return hasLoaded(title);
    }
}
