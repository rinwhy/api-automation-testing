package com.solvd.carina.web.pages.mobile;

import com.solvd.carina.web.pages.common.ProfilePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

}
