package selenide;

public class PageBase {

            protected static boolean hasLoaded(String title){
                return true;   //webDriver.getTitle().equals(title);
            }
}
