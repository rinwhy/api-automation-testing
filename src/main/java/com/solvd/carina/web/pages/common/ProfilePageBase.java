package com.solvd.carina.web.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProfilePageBase extends AbstractPage {

    public ProfilePageBase(WebDriver driver) {
        super(driver);
    }


    public abstract void deleteTweet(String message);

    public abstract boolean checkTweetWasDeleted();

    public abstract void editProfileBio(String message);

    public abstract boolean checkBioWasUpdated(String message);
}
