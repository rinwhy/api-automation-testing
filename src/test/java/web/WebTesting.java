package web;

import com.solvd.web.gui.pages.common.ExplorePageBase;
import com.solvd.web.gui.pages.common.HomePageBase;
import com.solvd.web.gui.pages.common.LoginPageBase;
import com.solvd.web.gui.pages.common.ProfilePageBase;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;


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

        HomePageBase homePage = loginPage.loginToSite();
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened");
    }


    @Test(testName = "Post a Tweet", dependsOnMethods = "login", description = "Testing for successful posting of a tweet from the sidebar tweet button")
    @MethodOwner(owner = "Rin")
    public void postATweet() {
        String tweetString = "Automation test!! ^.^";

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened");
        homePage.postATweetFromSideButton(tweetString);

        Assert.assertTrue(homePage.checkTweetWasPosted(), "Tweet was not posted successfully");
    }

    @Test(testName = "Delete a Tweet", dependsOnMethods = "login", description = "Testing for successful deletion of a tweet from your account")
    @MethodOwner(owner = "Rin")
    public void deleteATweet() {
        String tweetString = "A new Tweet to be deleted";

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened");
        homePage.postATweetFromSideButton(tweetString);
        Assert.assertTrue(homePage.checkTweetWasPosted(), "Tweet was not posted successfully");

        ProfilePageBase profilePage = homePage.openProfilePage();
        profilePage.deleteTweet(tweetString);
        Assert.assertTrue(profilePage.checkTweetWasDeleted(), "Tweet was not deleted successfully");
    }

    @Test(testName = "Edit User BIO", dependsOnMethods = "login", description = "Testing for successful editing of the users Bio from edit profile menu")
    @MethodOwner(owner = "Rin")
    public void editUserProfileBio() {
        String bioString = "Checking it again";

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened");

        ProfilePageBase profilePage =  homePage.openProfilePage();
        profilePage.editProfileBio(bioString);
        Assert.assertTrue(profilePage.checkBioWasUpdated(bioString), "Bio was not updated");
    }


    @Test(testName = "Search for Twitter user", dependsOnMethods = "login", description = "Testing search bar functionality, by searching a users twitter handle ")
    @MethodOwner(owner = "Rin")
    public void searchTwitterUser() {
        String userHandle = "@" + R.TESTDATA.get("user.email");

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened");

        ExplorePageBase explorePage = homePage.openExplorePage();
        explorePage.searchForTwitterUser(userHandle);

        Assert.assertTrue(explorePage.checkResultsForSearchingUser(userHandle), "Could not search for User Handle");

    }


}
