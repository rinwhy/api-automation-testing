package com.solvd.carina.web.pages.mobile;

import com.solvd.carina.web.pages.common.HomePageBase;
import com.solvd.carina.web.pages.common.ProfilePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//a[@href='/compose/tweet']")
    private ExtendedWebElement composeTweetButton;

    @FindBy(xpath = "//textarea[@aria-label='Tweet text']")
    private ExtendedWebElement tweetInputField;

    @FindBy(xpath = "//div[@aria-label='Profile menu rin_QA']")
    private ExtendedWebElement profileIcon;

    @FindBy(xpath = "//a[@href='/QA_2408']//span[text()='Profile']")
    private ExtendedWebElement profileLink;

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
        profileIcon.click();
        profileLink.click();
        return initPage(getDriver(), ProfilePageBase.class);
    }


}
