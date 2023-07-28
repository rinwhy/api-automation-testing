package com.solvd.carina.mobile.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void searchForPokemon(String name);

    public abstract void searchAndClickPokemon(String searchQuery);

    public abstract void verifyImperialUnits();

    public abstract void verifyTypeViewLayout();

    public abstract void openSideMenu();

    public abstract void closeSideMenu();

    public abstract SettingsPageBase goToSettings();
}
