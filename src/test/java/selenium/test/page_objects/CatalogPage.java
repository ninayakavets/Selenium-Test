package selenium.test.page_objects;

import org.openqa.selenium.By;
import selenium.test.page_objects.locators.Locators;

import static selenium.test.page_objects.WebDriverContainer.getDriver;

public class CatalogPage extends PageBase {
    static String title = "Rubber Ducks | My Store";
    private static By sortByNameButton = Locators.getLocator("CatalogPage.sortByNameButton");
    private static By yellowDuck = Locators.getLocator("CatalogPage.yellowDuck");
    private static By smallDuck = Locators.getLocator("CatalogPage.smallDuck");
    private static By addToCart = Locators.getLocator("CatalogPage.addToCart");
    private static By openCart = Locators.getLocator("CatalogPage.openCart");
    private static By itemInCart = Locators.getLocator("CatalogPage.itemInCart");


    public static boolean hasLoaded() {
        return hasLoaded(title);
    }

    public static String getPageTitle() {
        String pageTitle = getDriver().getTitle();
        return pageTitle;
    }

    public static void openYellowDuck() {
        getDriver().findElement(yellowDuck).click();
    }

    public static void chooseSmallDuck() {
        getDriver().findElement(smallDuck).click();
    }

    public static void addDuckToCart() {
        getDriver().findElement(addToCart).click();
    }

    public static void openCart() {
        getDriver().findElement(openCart).click();
    }

    public static String getCartItems() {
        String cartItem = getDriver().findElement(itemInCart).getText();
        return cartItem;
    }

}
