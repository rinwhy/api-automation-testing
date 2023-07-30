package com.solvd.carina.web.pages.mobile;

import com.solvd.carina.web.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
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

    @Override
    public void open() {
        super.open();
    }

}
