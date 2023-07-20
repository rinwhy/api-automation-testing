package com.solvd.web.gui.pages.desktop;

import com.solvd.web.gui.pages.common.ExplorePageBase;
import com.solvd.web.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ExplorePageBase.class)
public class ExplorePage extends ExplorePageBase {


    @FindBy(xpath = "//input[@data-testid='SearchBox_Search_Input']")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//a[@role='tab']//span[text()='People']")
    private ExtendedWebElement peopleTab;

    @FindBy(xpath = "//div[@aria-label='Timeline: Search timeline']//span[text()='%s']")
    private ExtendedWebElement confirmationSearchUserHandle;


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

    @Override
    public boolean checkResultsForSearchingUser(String userHandle) {
        return confirmationSearchUserHandle.format(userHandle).isPresent();
    }


}
