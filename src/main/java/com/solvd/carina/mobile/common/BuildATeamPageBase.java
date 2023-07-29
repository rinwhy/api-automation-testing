package com.solvd.carina.mobile.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class BuildATeamPageBase extends AbstractPage {
    public BuildATeamPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void autoBuildATeam();
}
