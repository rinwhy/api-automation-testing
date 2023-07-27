package com.solvd.web.gui.mobile.android;

import com.solvd.web.gui.mobile.common.WelcomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase {

    @FindBy(xpath= "//android.widget.ImageView")
    private ExtendedWebElement logo;



    protected WelcomePage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isPageOpened() {
        return logo.isElementPresent();
    }
}
