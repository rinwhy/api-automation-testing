package com.solvd.carina.web.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.support.FindBy;

public abstract class HomePageBase extends AbstractPage {

    @FindBy(xpath = "//a[@href='/home']//span[text()='For you']")
    protected ExtendedWebElement forYouTab;

    @FindBy(xpath = "//div[@data-testid='tweetButton']")
    protected ExtendedWebElement tweetUploadButton;

    @FindBy(xpath = "//a[@data-testid='AppTabBar_Explore_Link']")
    protected ExtendedWebElement exploreButton;

    @FindBy(xpath = "//span[text()='Your Tweet was sent.']")
    protected ExtendedWebElement tweetUploadConfirmationPopUp;

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract void postATweet(String message);
    public abstract ProfilePageBase openProfilePage();

    public boolean checkTweetWasPosted() {
        return tweetUploadConfirmationPopUp.isPresent();
    }

    public ExplorePageBase openExplorePage() {
        exploreButton.click();
        return initPage(driver, ExplorePageBase.class);
    }
}
