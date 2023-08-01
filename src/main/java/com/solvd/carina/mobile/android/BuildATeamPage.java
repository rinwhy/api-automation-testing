package com.solvd.carina.mobile.android;

import com.solvd.carina.mobile.common.BuildATeamPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BuildATeamPageBase.class)
public class BuildATeamPage extends BuildATeamPageBase {

    @FindBy(xpath = "//android.widget.Button[@text='Create team']")
    private ExtendedWebElement createATeamButton;

    @FindBy (xpath = "//android.widget.TextView[@text='Create team']")
    private ExtendedWebElement createATeamHeaderText;

    @ExtendedFindBy (accessibilityId = "More options")
    private ExtendedWebElement moreOptionsButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Random Empty Slots']")
    private ExtendedWebElement randomEmptySlotsButton;

    @FindBy(id = "com.goldex:id/save")
    private ExtendedWebElement saveButton;

    @FindBy(id = "com.goldex:id/team_name")
    private ExtendedWebElement createdTeamName;

    @Override
    public void autoBuildATeam() {
        createATeamButton.click();
        Assert.assertTrue(createATeamHeaderText.isElementPresent());

        moreOptionsButton.click();
        randomEmptySlotsButton.click();
        saveButton.click();
        driver.navigate().back();
        driver.navigate().back();

        Assert.assertTrue(createdTeamName.isElementPresent());
    }



    public BuildATeamPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isPageOpened() {
        return createATeamButton.isElementPresent();
    }
}
