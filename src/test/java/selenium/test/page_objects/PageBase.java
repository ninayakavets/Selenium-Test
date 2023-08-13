package selenium.test.page_objects;

import static selenium.test.page_objects.WebDriverContainer.getDriver;

public class PageBase {

    protected static boolean hasLoaded(String title) {
        return getDriver().getTitle().equals(title);
    }
}
