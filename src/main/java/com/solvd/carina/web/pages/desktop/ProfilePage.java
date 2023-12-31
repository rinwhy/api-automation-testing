package com.solvd.carina.web.pages.desktop;

import com.solvd.carina.web.pages.common.ProfilePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }
}
