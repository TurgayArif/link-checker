import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestCase_URL extends BaseTest {

    @DisplayName("Test validity of anchor tags for given URL")
    @Test
    public void testURL() {
        web.homePage().navigateToHomePage();
        var urls = web.homePage().searchForAnchorTags();
        for (String url : urls) {
            System.out.println("Checking current URL " + url);
            }
        }


    @DisplayName("Test broken links for given URL")
    @Test
    public void testBrokenLinks() {
        web.homePage().navigateToHomePage();
        var links = web.homePage().findBrokenLinks();
        for (String link : links) {
            var currentResponseCode = web.homePage().getResponseCode(link);
            if (currentResponseCode == 404) {
                System.out.println("Link is broken: " + link + " with response code: " + currentResponseCode);
                Assertions.assertEquals(404, currentResponseCode, "Link is valid: " + link);
            } else {
                System.out.println("Link is valid: " + link + " with response code: " + currentResponseCode);
            }
        }
    }

}
