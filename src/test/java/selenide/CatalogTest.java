package selenide;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CatalogTest extends TestBase {

    private static String expectedYellowDuckTitle = "Yellow Duck | Subcategory | Rubber Ducks | My Store";
    private static String expectedYellowDuckInCartTitle = "Yellow Duck";


    @Test
    public static void openCatalogPageTest() {
        HeaderMenu.goToRubberDucksPage();
        Assert.assertTrue(CatalogPage.hasLoaded());

    }

    @Test
    public static void openYellowDuckFromCatalogTest() {
        HeaderMenu.goToRubberDucksPage();
        CatalogPage.openYellowDuck();
        Assert.assertEquals(CatalogPage.getPageTitle(), expectedYellowDuckTitle);
    }

    @Test
    public static void correctAddYellowDuckToCartTest() throws InterruptedException {

        CatalogPage.openYellowDuck();
        CatalogPage.chooseSmallDuck();
        CatalogPage.addDuckToCart();
        Thread.sleep(2000);
        CatalogPage.openCart();
        Thread.sleep(2000);
        Assert.assertEquals(CatalogPage.getCartItems(), expectedYellowDuckInCartTitle);


    }
}
