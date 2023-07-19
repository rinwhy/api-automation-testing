package com.solvd.web.gui.pages.desktop;

import java.lang.invoke.MethodHandles;
import java.util.List;

import com.solvd.web.gui.pages.common.HomePageBase;
import com.solvd.web.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(xpath = "//span[text()='Sign in to Twitter']")
    private ExtendedWebElement signInToTwitterText;

    @FindBy(xpath = "//input[@name='text']")
    private ExtendedWebElement usernameInputField;

    @FindBy(xpath = "//div[@role='button']//span[text()='Next']")
    private ExtendedWebElement nextButton;

    @FindBy(xpath = "//input[@name='password']")
    private ExtendedWebElement passwordInputField;

    @FindBy(xpath = "//div[@data-testid='LoginForm_Login_Button']")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(signInToTwitterText);
    }


    public HomePageBase loginToSite() {
        usernameInputField.click();
        usernameInputField.type(R.TESTDATA.get("user.email"));
        nextButton.click();
        passwordInputField.type(R.TESTDATA.get("password"));
        loginButton.click();

        return initPage(driver, HomePageBase.class);
    }

}
