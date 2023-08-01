package com.solvd.carina.web.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class ExplorePageBase extends AbstractPage {

    @FindBy(xpath = "//input[@data-testid='SearchBox_Search_Input']")
    protected ExtendedWebElement searchBar;

    @FindBy(xpath = "//a[@role='tab']//span[text()='People']")
    protected ExtendedWebElement peopleTab;

    @FindBy(xpath = "//div[@aria-label='Timeline: Search timeline']//span[text()='%s']")
    protected ExtendedWebElement confirmationSearchUserHandle;


    public ExplorePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void searchForTwitterUser(String searchQuery);

    public boolean checkResultsForSearchingUser(String userHandle) {
        return confirmationSearchUserHandle.format(userHandle).isPresent();
    }
}
