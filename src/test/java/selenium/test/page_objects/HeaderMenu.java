package selenium.test.page_objects;

import org.openqa.selenium.By;

import static selenium.test.page_objects.WebDriverContainer.getDriver;

public class HeaderMenu {

    private static By rubberDucksMenuItem = By.cssSelector("#site-menu > ul > li.category-1 > a");

    public static void goToRubberDucksPage() {
        getDriver().findElement(rubberDucksMenuItem).click();
    }
}
