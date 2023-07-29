package com.solvd.carina.mobile.android;

import com.solvd.carina.mobile.common.BuildATeamPageBase;
import com.solvd.carina.mobile.common.HomePageBase;
import com.solvd.carina.mobile.common.PokemonDetailsPageBase;
import com.solvd.carina.mobile.common.SettingsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(id = "com.goldex:id/left_action")
    private ExtendedWebElement menuButton;

    @ExtendedFindBy(accessibilityId = "Pokémon Filter")
    private ExtendedWebElement pokemonFilterButton;

    @FindBy(id = "com.goldex:id/design_navigation_view")
    private ExtendedWebElement sideMenuView;

    @FindBy(id = "com.goldex:id/settings")
    private ExtendedWebElement settingsButtonInMenu;

    @FindBy(id = "com.goldex:id/search_bar_text")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement searchResultPokemon;

    @FindBy(id = "com.goldex:id/height_weight")
    private ExtendedWebElement pokemonHeightAndWeight;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.goldex:id/typeView']")
    private ExtendedWebElement typeViewLayout;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.goldex:id/cardBackground']")
    private ExtendedWebElement cardViewLayout;

    @FindBy(xpath = "//*[@resource-id='com.goldex:id/mainBackground']//*[@resource-id='com.goldex:id/favorite']")
    private ExtendedWebElement favoriteStarOnMainCard;

    @ExtendedFindBy(accessibilityId = "Team Builder")
    private ExtendedWebElement teamBuilderButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    @Override
    public void searchForPokemon(String searchQuery) {
        searchBar.click();
        searchBar.type(searchQuery);
        driver.navigate().back();
        Assert.assertTrue(searchResultPokemon.format(searchQuery).isPresent());
    }

    @Override
    public void searchAndClickPokemon(String searchQuery) {
        searchBar.click();
        searchBar.type(searchQuery);
        driver.navigate().back();
        goToDetailedPageOfPokemon(searchQuery);
    }

    @Override
    public void verifyImperialUnits() {
        searchAndClickPokemon("Lugia");
        String text = pokemonHeightAndWeight.getText();
        Assert.assertTrue(text.contains("lbs"));
    }


    @Override
    public void verifyStarIsPresentOnMainCard() {
        Assert.assertTrue(favoriteStarOnMainCard.isElementPresent());
    }

    @Override
    public void verifyTypeViewLayout() {
        Assert.assertTrue(typeViewLayout.isElementPresent());
    }



    @Override
    public void openSideMenu() {
        if(!sideMenuView.isElementPresent()) {
            menuButton.click();
            Assert.assertTrue(sideMenuView.isElementPresent());
        }
    }

    @Override
    public void closeSideMenu() {
        if(sideMenuView.isElementPresent()) {
            pokemonFilterButton.click();
            Assert.assertTrue(sideMenuView.isElementNotPresent(5));
        }
    }


    @Override
    public SettingsPageBase goToSettings() {
        menuButton.click();
        settingsButtonInMenu.click();
        return initPage(getDriver(), SettingsPageBase.class);
    }

    @Override
    public PokemonDetailsPageBase goToDetailedPageOfPokemon(String pokemon) {
        Assert.assertTrue(searchResultPokemon.format(pokemon).isPresent());
        searchResultPokemon.format(pokemon).click();
        return initPage(getDriver(), PokemonDetailsPageBase.class);
    }

    @Override
    public BuildATeamPageBase goToBuildATeamPage() {
        teamBuilderButton.click();
        return initPage(getDriver(), BuildATeamPageBase.class);
    }


    @Override
    public boolean isPageOpened() {
        return menuButton.isElementPresent();
    }
}
