package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Photographer;
import util.driver.DriverManager;

public class HomePage extends AbstractPageObject {

    @FindBy(id = "cb1-edit")
    private WebElement searchBox;

    private Photographer photographer;

    public HomePage() {
        photographer = new Photographer();
    }

    public void searchFor(String item) {
        photographer.takePhoto();
        searchBox.sendKeys(item);
        searchBox.sendKeys(Keys.ENTER);
    }
}
