package com.solvd.android;

import com.solvd.web.gui.mobile.common.WelcomePageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;

public class AndroidTesting implements IAbstractTest, IMobileUtils  {

    @Test(testName = "Login", description = "Testing the login feature from the default login screen")
    @MethodOwner(owner = "Rin")
    public void login() {
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened());
    }
}
