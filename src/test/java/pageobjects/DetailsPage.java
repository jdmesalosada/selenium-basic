package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Photographer;
import util.driver.DriverManager;

public class DetailsPage extends AbstractPageObject{

    @FindBy(css = "div[class*='ui-pdp-price--size-large'] span[class='andes-visually-hidden']")
    private WebElement priceInDetails;

    @FindBy(css = "h1[class='ui-pdp-title']")
    private WebElement nameInDetail;

    Photographer photographer;

    public DetailsPage() {
        photographer = new Photographer();
    }

    @Step("obteniendo la informacion del detalle")
    public ResultModel getDetailInformation(){
        photographer.takePhoto();
        ResultModel resultModel = new ResultModel();
        resultModel.setName(nameInDetail.getText());
        resultModel.setPrice(priceInDetails.getText());
        return resultModel;

    }
}
