package com.solvd.carina.mobile.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SettingsPageBase extends AbstractPage {

    public SettingsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void toggleToImperialUnits();

    public abstract void toggleToMetricUnits();

    public abstract void switchToTypeView();

    public abstract HomePageBase exitSettings();
}
