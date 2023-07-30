package com.solvd.carina.web.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class ProfilePageBase extends AbstractPage {

    @FindBy(xpath = "//div[@data-testid='tweetText']/span[text()='%s']")
    protected ExtendedWebElement tweetPostToBeDeleted;

    @FindBy(xpath = "//article//div[@aria-label='More']")
    protected ExtendedWebElement tweetsMoreOptionsButton;

    @FindBy(xpath = "//div[@role='menuitem']//span[text()='Delete']")
    protected ExtendedWebElement deleteButton;

    @FindBy(xpath = "//div[@data-testid='confirmationSheetDialog']//span[text()='Delete']")
    protected ExtendedWebElement deleteConfirmationButton;

    @FindBy(xpath = "//span[text()='Your Tweet was deleted']")
    protected ExtendedWebElement tweetDeleteConfirmationPopUp;

    @FindBy(xpath = "//a[@data-testid='editProfileButton']")
    protected ExtendedWebElement editProfileButton;

    @FindBy(xpath = "//textarea[@name='description']")
    protected ExtendedWebElement bioInputField;

    @FindBy(xpath = "//div[@data-testid='Profile_Save_Button']")
    protected ExtendedWebElement profileSaveButton;

    @FindBy(xpath = "//div[@data-testid='UserDescription']//span[text()='test']")
    private ExtendedWebElement profileBioText;

    public ProfilePageBase(WebDriver driver) {
        super(driver);
    }

    public void deleteTweet(String message) {
        tweetPostToBeDeleted.format(message).click();
        tweetsMoreOptionsButton.click();
        deleteButton.click();
        deleteConfirmationButton.click();
    }

    public boolean checkTweetWasDeleted() {
        return tweetDeleteConfirmationPopUp.isPresent();
    }


    public void editProfileBio(String message) {
        editProfileButton.click();
        bioInputField.doubleClick();
        bioInputField.sendKeys(Keys.DELETE);
        bioInputField.type(message);
        profileSaveButton.click();
    }

    public boolean checkBioWasUpdated(String message) {
        return profileBioText.format(message).isPresent();
    }

}
