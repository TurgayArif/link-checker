package core;

import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class Web {
    private WebDriver driver;
    private HomePage homePage;

    public Web(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }

}
