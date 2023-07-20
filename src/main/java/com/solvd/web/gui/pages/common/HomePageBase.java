package com.solvd.web.gui.pages.common;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }


    public abstract void postATweetFromSideButton(String message);
    public abstract boolean checkTweetWasPosted();

    public abstract ProfilePageBase openProfilePage();

    public abstract ExplorePageBase openExplorePage();
}
