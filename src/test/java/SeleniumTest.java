import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumTest {
    public WebDriver driver;
    private static final String SQL_EXERCISES = "SQL exercises";
    private static final String USERNAME = "IL4TCQ";
    private static final String PERSONAL_CHANGE_SUCCESS_GREETING = "Your registration data has been successfully changed.";
    private static final String FAQ_PAGE_HEADING = "FAQ";
    private static final String FAQ_QUESTION_1 = "1. Can a correct query be considered wrong, and vice versa?";
    private static final String FAQ_QUESTION_2 = "2. Why does the correct result set for some exercises that require getting ships by their classes contain the ship Bismarck, which is not present in the Ships table?";
    private static final String FAQ_QUESTION_3 = "3. Why are some of the exercises based on the poorly structured Ships database?";
    private static final String CSS_COLOR = "color";

    @Before
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();
    }

    @Test
    public void testLoginLogout() {
        MainPage mainPage = new MainPage(driver);
        String title = mainPage.getTitle();
        Assert.assertEquals(SQL_EXERCISES, title);

        mainPage.login();
        Assert.assertTrue(mainPage.getBodyText().contains(USERNAME));

        mainPage.logout();
        Assert.assertFalse(mainPage.getBodyText().contains(USERNAME));
    }

    @Test
    public void testChangePersonal() {
        MainPage mainPage = new MainPage(driver);
        mainPage.login();

        PersonalPage personalPage = mainPage.goToPersonalPage();

        personalPage.changePersonal();
        Assert.assertTrue(personalPage.getBodyText().contains(PERSONAL_CHANGE_SUCCESS_GREETING));
    }

    @Test
    public void testStaticPage() {
        FaqPage faqPage = new FaqPage(driver);
        Assert.assertEquals(FAQ_PAGE_HEADING, faqPage.getTextOfHeadingSize2());

        String faqPageBodyText = faqPage.getBodyText();
        Assert.assertTrue(faqPageBodyText.contains(FAQ_QUESTION_1));
        Assert.assertTrue(faqPageBodyText.contains(FAQ_QUESTION_2));
        Assert.assertTrue(faqPageBodyText.contains(FAQ_QUESTION_3));
    }

    @Test
    public void testHover() {
        MainPage mainPage = new MainPage(driver);
        Actions actions = new Actions(driver);

        WebElement registrationLink = mainPage.getRegistrationLink();
        String initialColor = registrationLink.getCssValue(CSS_COLOR);

        actions.moveToElement(registrationLink)
                .perform();

        String hoverColor = registrationLink.getCssValue(CSS_COLOR);
        Assert.assertNotEquals(initialColor, hoverColor);
    }

    @Test
    public void testWindowSize() {
        WebDriver.Options manage = driver.manage();
        Dimension initialSize = manage.window().getSize();

        manage.window().setSize(
                new Dimension(initialSize.width / 2, initialSize.height / 2)
        );
        Dimension newSize = manage.window().getSize();

        Assert.assertNotEquals(initialSize.width, newSize.width);
        Assert.assertNotEquals(initialSize.height, newSize.height);
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
