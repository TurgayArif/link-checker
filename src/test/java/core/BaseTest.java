package core;

import org.junit.jupiter.api.*;

public class BaseTest {
    protected static Browser browser;
    protected Web web;


    @BeforeAll
    public static void setUp() {
        browser = new Browser();
        browser.downloadDriver();
    }

    @BeforeEach
    public void init() {
        browser = new Browser();
        browser.startBrowser();
        web = new Web(browser.getDriver());
    }

    @AfterEach
    public void tearDown() {
        browser.close();
    }

}
