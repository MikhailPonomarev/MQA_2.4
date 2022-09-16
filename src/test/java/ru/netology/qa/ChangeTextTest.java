package ru.netology.qa;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.netology.qa.screens.AppElements;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ChangeTextTest {

    private AndroidDriver driver;
    AppElements elements;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Some name");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        desiredCapabilities.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        elements = new AppElements(this.driver);
    }

    @Test
    public void checkEmptyInput() {
        elements.getInputField().sendKeys("  ");
        elements.getButtonChange().click();
        MobileElement textToBeChanged = elements.getTextToBeChanged();;
        Assertions.assertEquals("Hello UiAutomator!", textToBeChanged.getText());
    }

    @Test
    public void checkTextInAnotherActivity() {
        String textToSet = "Test text";
        elements.getInputField().sendKeys(textToSet);
        elements.getButtonActivity().click();
        MobileElement textInAnotherActivity = elements.getTextInAnotherActivity();
        Assertions.assertEquals(textToSet,textInAnotherActivity.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}