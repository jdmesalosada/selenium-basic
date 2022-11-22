package util;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import util.driver.DriverManager;

public class Photographer {

    public Photographer()
    {
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takePhoto(){
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
