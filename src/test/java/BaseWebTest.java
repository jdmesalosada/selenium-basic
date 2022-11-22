import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.TestResultLoggerExtension;
import util.driver.DriverFactory;
import util.driver.DriverManager;

import java.time.Duration;

@ExtendWith(TestResultLoggerExtension.class)
public abstract class BaseWebTest {

    private static final String DEFAULT_BROWSER = "chrome";

    @BeforeEach
    public void setup() {
        WebDriver driver = DriverFactory.valueOf(DEFAULT_BROWSER.toUpperCase()).createDriver();
        DriverManager.setDriver(driver);

        DriverManager.getDriver().get("https://www.mercadolibre.com.co/");
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
    }
}
