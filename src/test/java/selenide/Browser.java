package selenide;

public enum Browser {

    CHROME("chrome"),
    SAFARI("safari");

    String browserName;

    Browser (String browserName){
        this.browserName = browserName;
    }

    public String getBrowserName() { return browserName; }
    public static Browser getEnumByLabel(String label) {
        for(Browser browser : values()) {
            if (browser.getBrowserName().equals(label)) {
                return browser;
            } }
        return null;
    }


}
