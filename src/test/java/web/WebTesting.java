package web;

import com.solvd.web.gui.pages.common.HomePageBase;
import com.solvd.web.gui.pages.common.LoginPageBase;
import com.solvd.web.gui.pages.common.ProfilePageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.asserts.SoftAssert;


public class WebTesting implements IAbstractTest {

    @Test
    public void testProperties() {
        System.out.println(R.CONFIG.getProperties());
    }


    @Test(testName = "Login", description = "Testing the login feature from the default login screen")
    @MethodOwner(owner = "Rin")
    public void login() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page was not opened");

        HomePageBase homepage = loginPage.loginToSite();
        Assert.assertTrue(homepage.isPageOpened(), "Home page was not opened");
    }


    @Test(testName = "Post a Tweet", dependsOnMethods = "login", description = "Testing for successful posting of a tweet from the sidebar tweet button")
    @MethodOwner(owner = "Rin")
    public void postATweet() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.postATweetFromSideButton("Automation test!! ^.^");

        Assert.assertTrue(homePage.checkTweetWasPosted(), "Tweet was not posted successfully");
    }

    @Test(testName = "Delete a Tweet", dependsOnMethods = "login", description = "Testing for successful deletion of a tweet from your account")
    @MethodOwner(owner = "Rin")
    public void deleteATweet() {

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.postATweetFromSideButton("Post to be deleted");
        Assert.assertTrue(homePage.checkTweetWasPosted(), "Tweet was not posted successfully");

        ProfilePageBase profilePage = homePage.openProfile();
        profilePage.deleteTweet();
        Assert.assertTrue(profilePage.checkTweetWasDeleted(), "Tweet was not deleted successfully");
    }


}
