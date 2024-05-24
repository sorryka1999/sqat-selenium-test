import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class PersonalPage extends PageBase {

    private static final By OLD_PASSWORD_INPUT = By.xpath("//input[@name='control_psw']");
    private static final String PASSWORD = "FOR-selenium-test-123";
    private static final By NICKNAME_INPUT = By.xpath("//input[@name='nnick']");
    private static final String NICKNAME = "IL4TCQ";
    private static final By LOGIN_INPUT = By.xpath("//input[@name='nlogin']");
    private static final String LOGIN = "il4tcq";
    private static final By NEW_PASSWORD_INPUT = By.xpath("//input[@name='npsw']");
    private static final By NEW_PASSWORD_CONFIRM_INPUT = By.xpath("//input[@name='npsw2']");
    private static final By SURNAME_INPUT = By.xpath("//input[@name='nfname']");
    private static final String SURNAME = "Khurramov";
    private static final By NAME_INPUT = By.xpath("//input[@name='nsname']");
    private static final String NAME = "Sardor";
    private static final By MIDDLE_NAME_INPUT = By.xpath("//input[@name='nlname']");
    private static final String MIDDLE_NAME = "ELTE";
    private static final By EMAIL_INPUT = By.xpath("//input[@name='nemail']");
    private static final String EMAIL = "il4tcq@inf.elte.hu";
    private static final By SHOW_SOLUTIONS_CHECKBOX = By.xpath("//input[@name='nshowsol']");
    private static final By CHANGE_INPUT = By.xpath("//input[@onclick='return checkEmpty()']");

    public PersonalPage(WebDriver driver) {
        super(driver);
    }

    public void changePersonal() {
        WebElement oldPsw = waitAndReturnElement(OLD_PASSWORD_INPUT);
        oldPsw.clear();
        oldPsw.sendKeys(PASSWORD);

        WebElement nickname = waitAndReturnElement(NICKNAME_INPUT);
        nickname.clear();
        nickname.sendKeys(NICKNAME);

        WebElement login = waitAndReturnElement(LOGIN_INPUT);
        login.clear();
        login.sendKeys(LOGIN);

        WebElement newPsw = waitAndReturnElement(NEW_PASSWORD_INPUT);
        newPsw.clear();
        newPsw.sendKeys(PASSWORD);

        WebElement newPswConf = waitAndReturnElement(NEW_PASSWORD_CONFIRM_INPUT);
        newPswConf.clear();
        newPswConf.sendKeys(PASSWORD);

        WebElement surname = waitAndReturnElement(SURNAME_INPUT);
        surname.clear();
        surname.sendKeys(SURNAME);

        WebElement name = waitAndReturnElement(NAME_INPUT);
        name.clear();
        name.sendKeys(NAME);

        WebElement midName = waitAndReturnElement(MIDDLE_NAME_INPUT);
        midName.clear();
        midName.sendKeys(MIDDLE_NAME);

        WebElement email = waitAndReturnElement(EMAIL_INPUT);
        email.clear();
        email.sendKeys(EMAIL);

        WebElement showSolution = waitAndReturnElement(SHOW_SOLUTIONS_CHECKBOX);
        showSolution.click();

        waitAndReturnElement(CHANGE_INPUT).click();
    }
}
