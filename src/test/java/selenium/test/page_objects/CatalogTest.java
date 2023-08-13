package selenium.test.page_objects;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CatalogTest extends TestBase {

    private static String expectedYellowDuckTitle = "Yellow Duck | Subcategory | Rubber Ducks | My Store";
    private static String expectedYellowDuckInCartTitle = "Yellow Duck";


    @Test
    @Feature(value = "Catalog page")
    @Story(value = "Catalog loading")
    @Description(value = "Test checks correct loading of CatalogPage")
    public static void openCatalogPageTest() {
        HeaderMenu.goToRubberDucksPage();
        Assert.assertTrue(CatalogPage.hasLoaded());

    }

    @Test
    @Feature(value = "Catalog page")
    @Story(value = "Open items from catalog")
    @Description(value = "Test checks correct opening of item Yellow Duck from catalog")
    public static void openYellowDuckFromCatalogTest() {
        HeaderMenu.goToRubberDucksPage();
        CatalogPage.openYellowDuck();
        Assert.assertEquals(CatalogPage.getPageTitle(), expectedYellowDuckTitle);
    }

    @Test
    @Feature(value = "Catalog page")
    @Story(value = "Buy items")
    @Description(value = "Test checks adding yellow duck to the cart")
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
