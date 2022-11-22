package pageobjects;

import org.openqa.selenium.support.PageFactory;
import util.driver.DriverManager;

public class AbstractPageObject {

    protected AbstractPageObject(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }


}
