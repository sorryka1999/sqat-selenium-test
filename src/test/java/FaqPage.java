import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class FaqPage extends PageBase {

    private static final By H2 = By.xpath("//h2");

    public FaqPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://sql-ex.ru/faq.php?Lang=1");
    }

    public String getTextOfHeadingSize2() {
        return waitAndReturnElement(H2).getText();
    }
}
