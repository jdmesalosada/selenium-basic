package pageobjects;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailsPage {

    @FindBy(css = "div[class*='ui-pdp-price--size-large'] span[class='andes-visually-hidden']")
    private WebElement priceInDetails;

    @FindBy(css = "h1[class='ui-pdp-title']")
    private WebElement nameInDetail;

    public DetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public ResultModel getDetailInformation(){

        ResultModel resultModel = new ResultModel();
        resultModel.setName(nameInDetail.getText());
        resultModel.setPrice(priceInDetails.getText());
        return resultModel;

    }
}
