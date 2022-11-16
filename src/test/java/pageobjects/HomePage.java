package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    @FindBy(id = "cb1-edit")
    private WebElement searchBox;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Step("Buscando el item {item}")
    public void searchFor(String item) {
        searchBox.sendKeys(item);
        searchBox.sendKeys(Keys.ENTER);
    }
}
