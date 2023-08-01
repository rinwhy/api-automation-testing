package com.solvd.carina.web.pages.mobile;

import com.solvd.carina.web.pages.common.ExplorePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ExplorePageBase.class)
public class ExplorePage extends ExplorePageBase {

    @FindBy(xpath = "//a[@href='/explore']")
    private ExtendedWebElement exploreButton;

    public ExplorePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void searchForTwitterUser(String searchQuery) {
        exploreButton.click();
        searchBar.click();
        searchBar.type(searchQuery);
        searchBar.sendKeys(Keys.ENTER);
    }

}
