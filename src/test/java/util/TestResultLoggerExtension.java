package util;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import util.driver.DriverManager;

public class TestResultLoggerExtension implements TestWatcher {

    private Photographer photographer = new Photographer();

    @Override
    public void testSuccessful(ExtensionContext context) {
        DriverManager.quit();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        photographer.takePhoto();
        DriverManager.quit();
    }
}
