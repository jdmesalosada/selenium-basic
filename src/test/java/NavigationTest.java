import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.*;


import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class NavigationTest extends BaseWebTest {


   /* @Test
    public void navigateToGoogle() throws InterruptedException {

        driver.get("https://www.facebook.com");

        driver.findElement(By.cssSelector("button[data-cookiebanner=\"accept_button\"]")).click();
        driver.findElement(By.cssSelector("input#email")).sendKeys("algo");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("password");
        driver.findElement(By.cssSelector("button[name='login']")).click();

        Thread.sleep(3000);
    }

    @Test
    public void navigateToColombia() {

        driver.get("https://www.mercadolibre.com");

        driver.findElement(By.xpath("//nav/ul/li/a[contains(.,'Colombia')]"))
                .click();

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "www.mercadolibre.com.co";

        assertTrue(currentUrl.contains(expectedUrl),
                "se esperaba que la url contenga " + expectedUrl + " pero se obtuvo " + currentUrl);

    }

    @Test
    public void workWithSelects() throws InterruptedException {

        driver.get("http://automationpractice.com/index.php?controller=contact");

        WebElement select = driver.findElement(By.id("id_contact"));
        Select selectWeb = new Select(select);
        selectWeb.selectByIndex(1);
        Thread.sleep(2000);
        selectWeb.selectByIndex(2);
        Thread.sleep(2000);
        selectWeb.selectByIndex(0);

        Thread.sleep(2000);

        selectWeb.selectByVisibleText("Webmaster");
        Thread.sleep(2000);

        selectWeb.selectByValue("2");
        Thread.sleep(2000);

    }

    @Test
    public void navigateToLocalDocument() throws InterruptedException {

        String path = this.getClass().getResource("/createElement.html").getPath();
        driver.get("file://" + path);

        WebElement createBtn = driver.findElement(By.id("createBtn"));
        createBtn.click();

        Thread.sleep(3000);

    }

    @Test
    public void implicitWaitExample() {

        driver.get("http://www.google.com");
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

        Instant start = Instant.now();

        try {
            driver.findElement(By.id("algo"));
        } catch (Exception exc) {
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            System.out.println("*******");
            System.out.println("time 1: " + timeElapsed.getSeconds() + " seconds");
            System.out.println("*******");
        }

        start = Instant.now();

        try {
            driver.findElement(By.id("algo2"));
        } catch (Exception exc) {
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            System.out.println("*******");
            System.out.println("time 2: " + timeElapsed.getSeconds() + " seconds");
            System.out.println("*******");
        }
    }

    @Test
    public void defaultImplicitWait() {

        driver.get("http://www.google.com");

        Instant start = Instant.now();

        try {
            driver.findElement(By.id("algo"));
        } catch (Exception exc) {
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            System.out.println("*******");
            System.out.println("time 1: " + timeElapsed.getSeconds() + " seconds");
            System.out.println("*******");
        }
    }

    @Test
    public void explicitWaitExample() {

        driver.get("http://www.google.com");
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);

        Instant start = Instant.now();
        try {
            driver.findElement(By.id("algo"));
        } catch (Exception exc) {
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            System.out.println("*******");
            System.out.println("time 1: " + timeElapsed.getSeconds() + " seconds");
            System.out.println("*******");
        }

        Instant start2 = Instant.now();
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10L) );

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("algo2")));

        } catch (Exception exc) {
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start2, end);
            System.out.println("*******");
            System.out.println("time 2: " + timeElapsed.getSeconds() + " seconds");
            System.out.println("*******");
        }
    }

    @Test
    public void explicitWaitExample4() {

        driver.get("http://www.google.com");
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

        Instant start = Instant.now();
        try {
            driver.findElement(By.id("algo"));
        } catch (Exception exc) {
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            System.out.println("*******");
            System.out.println("time 1: " + timeElapsed.getSeconds() + " seconds");
            System.out.println("*******");
        }

        Instant start2 = Instant.now();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L) );

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("algo2")));

        } catch (Exception exc) {
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start2, end);
            System.out.println("*******");
            System.out.println("time 2: " + timeElapsed.getSeconds() + " seconds");
            System.out.println("*******");
        }
    }

    @Test
    public void explicitWaitExample5() {

        driver.get("http://www.google.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("algo2")));

    }

    @Test
    public void fluentWaitExample() {
        driver.get("http://www.google.com");

        FluentWait fluentWait = new FluentWait(driver);

        fluentWait.withTimeout(Duration.ofSeconds(10L));
        fluentWait.pollingEvery(Duration.ofSeconds(2L));

        Instant start2 = Instant.now();

        try {
            fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.id("algo")));
        } catch (Exception ex) {
            System.out.println("***exception**: " + ex.getMessage());
        }

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start2, end);
        System.out.println("*******");
        System.out.println("time: " + timeElapsed.getSeconds() + " seconds");
        System.out.println("*******");
    }

    @Test
    public void sendContactUs() {

        driver.navigate().to("http://automationpractice.com/index.php?controller=contact");

        ContactUs contactUs = new ContactUs(driver);
        contactUs.writeSubjectHeading("Webmaster");
        contactUs.writeEmail("pepito@gmail.com");
        contactUs.writeOrderReference("83405843");
        contactUs.writeMessage("hello world");
        contactUs.submit();
        contactUs.validateTheMessageIs("Your message has been successfully sent to our team.");
    }*/

    @Test
    public void getElementsTest() {

        HomePage homePage = new HomePage(driver);
        homePage.searchFor("guitarra electrica");

        ResultsPage resultsPage = new ResultsPage(driver);
        ResultModel expectedResultModel = resultsPage.clickOnRandomItem();

        DetailsPage detailsPage = new DetailsPage(driver);
        ResultModel actualResultModel =  detailsPage.getDetailInformation();

        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedResultModel.getPrice(),
                        actualResultModel.getPrice(), "prices don't match."),
                () -> Assertions.assertEquals(expectedResultModel.getName(),
                        actualResultModel.getName(), "product names don't match.")
        );
    }
}
