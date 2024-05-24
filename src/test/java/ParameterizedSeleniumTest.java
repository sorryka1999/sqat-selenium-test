import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

@RunWith(JUnitParamsRunner.class)
public class ParameterizedSeleniumTest {
    public WebDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();
    }

    private static final By TD = By.xpath("//td");

    @Test
    @FileParameters("src/test/resources/pages.csv")
    public void parameterizedTest(String url, String title) {
        driver.get(url);
        Assert.assertEquals(title, driver.getTitle());
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
