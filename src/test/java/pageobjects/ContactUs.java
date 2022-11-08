package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactUs {

    private WebDriver driver;
    private Wait wait;

    @FindBy(id = "id_contact")
    private WebElement subjectHeadingLocator;

    @FindBy(id = "email")
    private WebElement emailLocator;

    @FindBy(css = "input#id_order")
    private WebElement orderReferenceLocator;

    @FindBy(xpath = "//textarea[@id='message']")
    private WebElement messageLocator;

    @FindBy(id = "submitMessage")
    private WebElement submitMessageLocator;

    @FindBy(xpath = "//p[contains(@class, 'alert')]")
    private WebElement actualMessageLocator;

    @FindBy(id = "algo")
    private WebElement elementDoesNotExist;

    public ContactUs(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        PageFactory.initElements(driver, this);
    }

    public void writeOnAlgo(String subject) {
        wait.until(ExpectedConditions.visibilityOf(elementDoesNotExist));
        elementDoesNotExist.sendKeys(subject);
    }

    public void writeSubjectHeading(String subject) {
        Select selectSubjectHeading = new Select(subjectHeadingLocator);
        selectSubjectHeading.selectByVisibleText(subject);
    }

    public void writeEmail(String emailText) {
        emailLocator.sendKeys(emailText);
    }

    public void writeOrderReference(String orderReferenceText) {
        orderReferenceLocator.sendKeys(orderReferenceText);
    }

    public void writeMessage(String messageText) {
        messageLocator.sendKeys(messageText);
    }

    public void submit() {
        submitMessageLocator.click();
    }

    public void validateTheMessageIs(String expectedText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class, 'alert')]")));
        assertTrue(actualMessageLocator.getText()
                .contains(expectedText));
    }

}
