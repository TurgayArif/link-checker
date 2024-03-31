package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Defaults;

import java.time.Duration;
import java.util.List;


public class DefaultPage extends Defaults {
    protected WebDriver driver;

    public DefaultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    protected void click(WebElement element) {
        waitForPresenceOfWebElement(element);
        element.click();
    }

    protected void sendKeys(WebElement element, String text) {
        waitForPresenceOfWebElement(element);
        element.sendKeys(text);
    }

    protected WebElement findElementByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    protected String getText(WebElement element) {
        return element.getText();
    }

    protected void waitForPresenceOfWebElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    protected void waitForVisibilityOfElements(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    protected void waitForPresenceOfElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
