package com.solvd.carina.mobile.android;

import com.solvd.carina.mobile.common.HomePageBase;
import com.solvd.carina.mobile.common.SettingsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SettingsPageBase.class)
public class SettingsPage extends SettingsPageBase {

    @FindBy(id = "android:id/switch_widget")
    private ExtendedWebElement unitsToggleSwitch;

    @ExtendedFindBy(accessibilityId = "Navigate up")
    private ExtendedWebElement backArrowInSettings;

    @ExtendedFindBy(text = "Change the Pokédex list view")
    private ExtendedWebElement changeListViewMenuItem;

    @ExtendedFindBy(text = "Type View")
    private ExtendedWebElement typeViewSelection;

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void toggleToImperialUnits() {
        unitsToggleSwitch.check();
    }

    @Override
    public void toggleToMetricUnits() {
        unitsToggleSwitch.uncheck();
    }

    @Override
    public void switchToTypeView(){
        changeListViewMenuItem.click();
        typeViewSelection.check();
    }

    @Override
    public HomePageBase exitSettings() {
        backArrowInSettings.click();
        return initPage(getDriver(), HomePageBase.class);
    }




}
