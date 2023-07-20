package com.solvd.web.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ExplorePageBase extends AbstractPage {
    public ExplorePageBase(WebDriver driver) {
        super(driver);
    }


    public abstract void searchForTwitterUser(String searchQuery);

    public abstract boolean checkResultsForSearchingUser(String userHandle);
}
