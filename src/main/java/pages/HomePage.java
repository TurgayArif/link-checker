package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Defaults;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends DefaultPage {

    protected List<WebElement> anchors;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void navigateToHomePage() {
        navigateTo(Defaults.BASE_URL);
    }

    public List<String> searchForAnchorTags() {
        anchors = driver.findElements(By.tagName("a"));
        List<String> href = new ArrayList<>();
        for (WebElement anchor : anchors) {
            if (anchor.getAttribute("href") == null) {
                continue;
            }
            href.add(anchor.getAttribute("href"));
        }
        return href;
    }

    public boolean isURLValid(String url) {
        var anchors = searchForAnchorTags();
        for (String anchor : anchors) {
            driver.get(anchor);
            var pageSource = driver.getPageSource();
            if (pageSource.contains("404") || pageSource.contains("Not Found")) {
                return false;
            }

        }
        return true;
    }

    public int getResponseCode(String url) {
        try {
            HttpURLConnection.setFollowRedirects(false);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
            httpURLConnection.setRequestMethod("HEAD");
            return httpURLConnection.getResponseCode();
        } catch (Exception e) {
            return -1;
        }
    }

    public List<String> findBrokenLinks() {
        List<String> brokenLinks = new ArrayList<>();
        for (String link : searchForAnchorTags()) {
            if (!isURLValid(link)) {
                brokenLinks.add(link);
            }
        }
        return brokenLinks;
    }


}
