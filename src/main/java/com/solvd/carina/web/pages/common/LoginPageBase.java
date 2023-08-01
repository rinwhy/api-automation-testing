package com.solvd.carina.web.pages.common;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.support.FindBy;

public abstract class LoginPageBase extends AbstractPage {


    @FindBy(xpath = "//span[text()='Sign in to Twitter']")
    protected ExtendedWebElement signInToTwitterText;

    @FindBy(xpath = "//input[@name='text']")
    protected ExtendedWebElement usernameInputField;

    @FindBy(xpath = "//div[@role='button']//span[text()='Next']")
    protected ExtendedWebElement nextButton;

    @FindBy(xpath = "//input[@name='password']")
    protected ExtendedWebElement passwordInputField;

    @FindBy(xpath = "//div[@data-testid='LoginForm_Login_Button']")
    protected ExtendedWebElement loginButton;

    public LoginPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public HomePageBase loginToSite() {
        usernameInputField.click();
        usernameInputField.type(R.TESTDATA.get("user.email"));
        nextButton.click();
        passwordInputField.type(R.TESTDATA.get("password"));
        loginButton.click();

        return initPage(driver, HomePageBase.class);
    }


    @Override
    public void open() {
        super.open();
    }
}
