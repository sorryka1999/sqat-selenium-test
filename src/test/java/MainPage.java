import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class MainPage extends PageBase {

    private static final By LOGIN_INPUT = By.xpath("//input[@name='login']");
    private static final String LOGIN = "il4tcq";
    private static final By PASSWORD_INPUT = By.xpath("//input[@name='psw']");
    private static final By ENTER_INPUT = By.xpath("//input[@value='Enter']");
    private static final By LOGOUT_LINK = By.xpath("//a[@href='/logout.php']");
    private static final String PASSWORD = "FOR-selenium-test-123";
    private static final By PERSONAL_PAGE_LINK = By.xpath("//a[@href='/personal.php']");
    private static final By REGISTRATION_LINK = By.xpath("//a[@href='/register.php']");

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.sql-ex.ru/?Lang=1");
    }

    public void login() {
        waitAndReturnElement(LOGIN_INPUT).sendKeys(LOGIN);
        waitAndReturnElement(PASSWORD_INPUT).sendKeys(PASSWORD);

        WebElement enterInput = waitAndReturnElement(ENTER_INPUT);
        enterInput.submit();
    }

    public void logout() {
        WebElement logoutLink = waitAndReturnElement(LOGOUT_LINK);
        logoutLink.click();
    }

    public PersonalPage goToPersonalPage() {
        WebElement personalPageLink = waitAndReturnElement(PERSONAL_PAGE_LINK);
        personalPageLink.click();
        return new PersonalPage(driver);
    }

    public WebElement getRegistrationLink() {
        return waitAndReturnElement(REGISTRATION_LINK);
    }
}
