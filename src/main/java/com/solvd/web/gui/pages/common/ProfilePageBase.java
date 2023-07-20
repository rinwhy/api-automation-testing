package com.solvd.web.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindAll;

public abstract class ProfilePageBase extends AbstractPage {

    public ProfilePageBase(WebDriver driver) {
        super(driver);
    }


    public abstract void deleteTweet(String message);

    public abstract boolean checkTweetWasDeleted();

    public abstract void editProfileBio(String message);

    public abstract boolean checkBioWasUpdated(String message);
}
