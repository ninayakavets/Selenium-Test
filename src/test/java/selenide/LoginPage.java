package selenide;

import org.openqa.selenium.By;
import selenide.locators.Locators;

import static com.codeborne.selenide.Selenide.$;


public class LoginPage extends PageBase {
    static String title = "Online Store | My Store";
    private static By emailInput = Locators.getLocator("LoginPage.emailInput");
    private static By passwordInput = Locators.getLocator("LoginPage.passwordInput");
    private static By loginButton = Locators.getLocator("LoginPage.loginButton");
    private static By errorMessage = Locators.getLocator("LoginPage.errorMessage");

    public static void attemptLogin( String email, String password){
        $(emailInput).sendKeys(email);
        $(passwordInput).sendKeys(password);
        $(loginButton).click();
    }

    public static String getErrorMessageText(){

        String errorMessageText = $(errorMessage).getText();

        return errorMessageText;
    }

    public static boolean hasLoaded(){
        return hasLoaded(title);
    }
}
