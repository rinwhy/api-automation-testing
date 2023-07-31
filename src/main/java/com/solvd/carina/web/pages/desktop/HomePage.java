package com.solvd.carina.web.pages.desktop;

import com.solvd.carina.web.pages.common.HomePageBase;
import com.solvd.carina.web.pages.common.ProfilePageBase;
import com.solvd.carina.web.pages.common.ExplorePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {


    @FindBy(xpath = "//a[@href='/compose/tweet']")
    private ExtendedWebElement composeTweetButton;

    @FindBy(xpath = "//div[@role='textbox']")
    private ExtendedWebElement tweetInputField;

    @FindBy(xpath = "//a[@data-testid='AppTabBar_Profile_Link']")
    private ExtendedWebElement profileButton;




    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(forYouTab);
    }

    @Override
    public void postATweet(String message) {
        composeTweetButton.click();
        tweetInputField.click();
        tweetInputField.type(message);
        tweetUploadButton.click();
    }


    @Override
    public ProfilePageBase openProfilePage() {
        profileButton.click();
        return initPage(driver, ProfilePageBase.class);
    }


}
