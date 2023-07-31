package com.solvd.carina.mobile;

import com.solvd.carina.mobile.common.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;


@MethodOwner(owner = "Rin")
public class AndroidAppTesting implements IAbstractTest, IMobileUtils {

    @BeforeMethod
    public void beforeMethod() {
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened());

        HomePageBase homePage = welcomePage.continueToHomeScreen();
        Assert.assertTrue(homePage.isPageOpened());
    }


    @Test(testName = "Search a Pokemon", description = "Search for a pokemon from the main menu")
    public void searchBarTest() {
        String pokemonToSearch = "Lugia";
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.searchForPokemon(pokemonToSearch);
    }

    @Test(testName = "Change to Imperial Units", description = "Go into the settings and change the units of measurements")
    public void changeToImperialUnitsTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        SettingsPageBase settingsPage = homePage.goToSettings();
        Assert.assertTrue(settingsPage.isPageOpened());
        settingsPage.toggleToImperialUnits();

        homePage = settingsPage.exitSettings();
        homePage.closeSideMenu();

        homePage.verifyImperialUnits();
    }

    @Test(testName = "Change to Type view", description = "Go into setting and change the layout that the pokemons will be shown")
    public void changetoTypeViewLayoutTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        SettingsPageBase settingsPage = homePage.goToSettings();
        Assert.assertTrue(settingsPage.isPageOpened());
        settingsPage.switchToTypeView();

        homePage = settingsPage.exitSettings();
        homePage.closeSideMenu();

        homePage.verifyTypeViewLayout();
    }

    @Test(testName = "Favorite a Pokemon", description = "Favorites the pokemon specified")
    public void favoriteAPokemonTest() {
        String pokemon = "Lugia";
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.searchForPokemon(pokemon);

        PokemonDetailsPageBase pkmDetailPage = homePage.goToDetailedPageOfPokemon(pokemon);
        Assert.assertTrue(pkmDetailPage.isPageOpened());

        pkmDetailPage.favoriteThePokemon();
        pkmDetailPage.backToHomePage();

        homePage.verifyStarIsPresentOnMainCard();
    }

    @Test(testName = "Auto build team", description = "Auto builds a pokemon team and saves it")
    public void autoBuildATeam(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        BuildATeamPageBase buildTeamPage = homePage.goToBuildATeamPage();
        Assert.assertTrue(buildTeamPage.isPageOpened());

        buildTeamPage.autoBuildATeam();
    }


}
