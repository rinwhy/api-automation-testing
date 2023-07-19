package com.solvd.web.gui.pages.desktop;

import com.solvd.web.gui.pages.common.ProfilePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {

    @FindBy(xpath = "//div[@data-testid='tweetText']/span[text()='Post to be deleted']")
    private ExtendedWebElement tweetPostToBeDeleted;

    @FindBy(xpath = "//article//div[@aria-label='More']")
    private ExtendedWebElement tweetsMoreOptionsButton;

    @FindBy(xpath = "//div[@role='menuitem']//span[text()='Delete']")
    private ExtendedWebElement deleteButton;

    @FindBy(xpath = "//div[@data-testid='confirmationSheetDialog']//span[text()='Delete']")
    private ExtendedWebElement deleteConfirmationButton;

    @FindBy(xpath = "//span[text()='Your Tweet was deleted']")
    private ExtendedWebElement tweetDeleteConfirmationPopUp;


    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void deleteTweet() {
        tweetPostToBeDeleted.click();
        tweetsMoreOptionsButton.click();
        deleteButton.click();
        deleteConfirmationButton.click();
    }


    @Override
    public boolean checkTweetWasDeleted() {
        return tweetDeleteConfirmationPopUp.isPresent();
    }




}
