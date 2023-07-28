package com.solvd.carina.mobile.android;

import com.solvd.carina.mobile.common.HomePageBase;
import com.solvd.carina.mobile.common.WelcomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase {

    //terms and service screen
    @FindBy(id = "com.goldex:id/header_img")
    private ExtendedWebElement goldexHeaderImg;



    public WelcomePage(WebDriver driver) {
        super(driver);

    }


    @Override
    public HomePageBase continueToHomeScreen() {
        driver.navigate().back();
        return initPage(getDriver(), HomePageBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return goldexHeaderImg.isElementPresent();
    }
}
