package com.solvd.carina.mobile.android;

import com.solvd.carina.mobile.common.PokemonDetailsPageBase;
import com.solvd.carina.mobile.common.WelcomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PokemonDetailsPageBase.class)
public class PokemonDetailsPage extends PokemonDetailsPageBase {


    @FindBy(id = "com.goldex:id/favorite")
    private ExtendedWebElement favoriteStar;

    @FindBy(id = "com.goldex:id/pokemon_name_card")
    private ExtendedWebElement nameCard;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.goldex:id/type_text']")
    private List<ExtendedWebElement> pokemonElementTypes;

    @FindBy(id = "com.goldex:id/descriptionText")
    private ExtendedWebElement description;

    @FindBy(id = "com.goldex:id/height_weight")
    private ExtendedWebElement pokemonHeightAndWeight;

    public PokemonDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void favoriteThePokemon() {
        favoriteStar.click();
    }

    @Override
    public void backToHomePage() {
        driver.navigate().back();
    }

    @Override
    public boolean isPageOpened() {
        return description.isElementPresent();
    }
}
