package ru.netology.qa.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class AppElements {
    @AndroidFindBy(id = "userInput")
    private MobileElement inputField;

    @AndroidFindBy(id = "buttonChange")
    private MobileElement buttonChange;

    @AndroidFindBy(id = "textToBeChanged")
    private MobileElement textToBeChanged;

    @AndroidFindBy(id = "buttonActivity")
    private MobileElement buttonActivity;

    @AndroidFindBy(id = "text")
    private MobileElement textInAnotherActivity;

    public MobileElement getInputField() {
        return inputField;
    }

    public MobileElement getButtonChange() {
        return buttonChange;
    }

    public MobileElement getTextToBeChanged() {
        return textToBeChanged;
    }

    public MobileElement getButtonActivity() {
        return buttonActivity;
    }

    public MobileElement getTextInAnotherActivity() {
        return textInAnotherActivity;
    }

    private AppiumDriver driver;

    public AppElements(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }
}
