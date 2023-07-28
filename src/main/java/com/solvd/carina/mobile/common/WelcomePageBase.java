package com.solvd.carina.mobile.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WelcomePageBase extends AbstractPage {


    public WelcomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HomePageBase continueToHomeScreen();
}
