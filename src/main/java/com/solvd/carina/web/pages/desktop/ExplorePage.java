package com.solvd.carina.web.pages.desktop;

import com.solvd.carina.web.pages.common.ExplorePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ExplorePageBase.class)
public class ExplorePage extends ExplorePageBase {

    public ExplorePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void searchForTwitterUser(String searchQuery) {
        searchBar.click();
        searchBar.type(searchQuery);
        searchBar.sendKeys(Keys.ENTER);
        peopleTab.click();
    }
}
