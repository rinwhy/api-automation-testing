package com.solvd.carina.mobile.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class PokemonDetailsPageBase extends AbstractPage {

    public PokemonDetailsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void favoriteThePokemon();

    public abstract void backToHomePage();
}
