package com.solvd.carina.web.pages.desktop;

import com.solvd.carina.web.pages.common.ProfilePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {

    @FindBy(xpath = "//div[@data-testid='tweetText']/span[text()='%s']")
    private ExtendedWebElement tweetPostToBeDeleted;

    @FindBy(xpath = "//article//div[@aria-label='More']")
    private ExtendedWebElement tweetsMoreOptionsButton;

    @FindBy(xpath = "//div[@role='menuitem']//span[text()='Delete']")
    private ExtendedWebElement deleteButton;

    @FindBy(xpath = "//div[@data-testid='confirmationSheetDialog']//span[text()='Delete']")
    private ExtendedWebElement deleteConfirmationButton;

    @FindBy(xpath = "//span[text()='Your Tweet was deleted']")
    private ExtendedWebElement tweetDeleteConfirmationPopUp;

    @FindBy(xpath = "//a[@data-testid='editProfileButton']")
    private ExtendedWebElement editProfileButton;

    @FindBy(xpath = "//textarea[@name='description']")
    private ExtendedWebElement bioInputField;

    @FindBy(xpath = "//div[@data-testid='Profile_Save_Button']")
    private ExtendedWebElement profileSaveButton;

    @FindBy(xpath = "//span[text()='%s']" )
    private ExtendedWebElement profileBioText;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void deleteTweet(String message) {
        tweetPostToBeDeleted.format(message).click();
        tweetsMoreOptionsButton.click();
        deleteButton.click();
        deleteConfirmationButton.click();
    }


    @Override
    public boolean checkTweetWasDeleted() {
        return tweetDeleteConfirmationPopUp.isPresent();
    }

    @Override
    public void editProfileBio(String message) {
        editProfileButton.click();
        bioInputField.doubleClick();
        bioInputField.sendKeys(Keys.DELETE);
        bioInputField.type(message);
        profileSaveButton.click();
    }


    @Override
    public boolean checkBioWasUpdated(String message) {
        return profileBioText.format(message).isPresent();
    }




}
