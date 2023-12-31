package com.solvd.carina.web.pages.desktop;

import com.solvd.carina.web.pages.common.HomePageBase;
import com.solvd.carina.web.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {


    public LoginPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(signInToTwitterText);
    }


//    public HomePageBase loginToSite() {
//        usernameInputField.click();
//        usernameInputField.type(R.TESTDATA.get("user.email"));
//        nextButton.click();
//        passwordInputField.type(R.TESTDATA.get("password"));
//        loginButton.click();
//
//        return initPage(driver, HomePageBase.class);
//    }

}
