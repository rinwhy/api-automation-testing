package com.solvd.web.gui.pages.desktop;

import com.solvd.web.gui.pages.common.HomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;



@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//h2/span[text()='Home']")
    private ExtendedWebElement homeTextHeading;

    @FindBy(xpath = "//a[@href='/compose/tweet']")
    private ExtendedWebElement tweetButtonOnSideBar;

    @FindBy(xpath = "//div[@role='textbox']")
    private ExtendedWebElement tweetInputField;

    @FindBy(xpath = "//div[@data-testid='tweetButton']")
    private ExtendedWebElement tweetUploadButton;

    @FindBy(xpath = "//span[text()='Your Tweet was sent.']")
    private ExtendedWebElement tweetUploadConfirmationPopUp;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(homeTextHeading);
    }

    @Override
    public void postATweetFromSideButton(String message) {
        tweetButtonOnSideBar.click();
        tweetInputField.click();
        tweetInputField.type(message);
        tweetUploadButton.click();
    }

    @Override
    public boolean checkTweetWasPosted() {
        return tweetUploadConfirmationPopUp.isPresent();
    }

}
