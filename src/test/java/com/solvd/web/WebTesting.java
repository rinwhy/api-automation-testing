package com.solvd.web;

import com.solvd.web.gui.pages.common.ExplorePageBase;
import com.solvd.web.gui.pages.common.HomePageBase;
import com.solvd.web.gui.pages.common.LoginPageBase;
import com.solvd.web.gui.pages.common.ProfilePageBase;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

import java.time.LocalDateTime;


public class WebTesting implements IAbstractTest {


    @BeforeMethod(onlyForGroups = {"LoginRequired"})
    public void beforeMethod() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.open();
        HomePageBase homePage = loginPage.loginToSite();
        homePage.assertPageOpened();
    }


    @Test(testName = "Login", description = "Testing the login feature from the default login screen")
    @MethodOwner(owner = "Rin")
    public void login() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.open();
        loginPage.assertPageOpened();

        HomePageBase homePage = loginPage.loginToSite();
        homePage.assertPageOpened();
    }


    @Test(testName = "Post a Tweet", groups = {"LoginRequired"},  description = "Testing for successful posting of a tweet from the sidebar tweet button")
    @MethodOwner(owner = "Rin")
    public void postATweet() {
        String tweetString = "Automation test!! ^.^ \n" + LocalDateTime.now();

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.assertPageOpened();
        homePage.postATweetFromSideButton(tweetString);

        Assert.assertTrue(homePage.checkTweetWasPosted(), "Tweet was not posted successfully");
    }

    @Test(testName = "Delete a Tweet", groups = {"LoginRequired"}, description = "Testing for successful deletion of a tweet from your account")
    @MethodOwner(owner = "Rin")
    public void deleteATweet() {
        String tweetString = "A new Tweet to be deleted";

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.assertPageOpened();
        homePage.postATweetFromSideButton(tweetString);
        Assert.assertTrue(homePage.checkTweetWasPosted(), "Tweet was not posted successfully");

        ProfilePageBase profilePage = homePage.openProfilePage();
        profilePage.deleteTweet(tweetString);
        Assert.assertTrue(profilePage.checkTweetWasDeleted(), "Tweet was not deleted successfully");
    }

    @Test(testName = "Edit User BIO", groups = {"LoginRequired"},  description = "Testing for successful editing of the users Bio from edit profile menu")
    @MethodOwner(owner = "Rin")
    public void editUserProfileBio() {
        String bioString = "New bio as of \n" + LocalDateTime.now();

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.assertPageOpened();

        ProfilePageBase profilePage =  homePage.openProfilePage();
        profilePage.editProfileBio(bioString);
        Assert.assertTrue(profilePage.checkBioWasUpdated(bioString), "Bio was not updated");
    }


    @Test(testName = "Search for Twitter user", groups = {"LoginRequired"},  description = "Testing search bar functionality, by searching a users twitter handle ")
    @MethodOwner(owner = "Rin")
    public void searchTwitterUser() {
        String userHandle = "@" + R.TESTDATA.get("user.email");

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.assertPageOpened();
        ExplorePageBase explorePage = homePage.openExplorePage();
        explorePage.searchForTwitterUser(userHandle);
        Assert.assertTrue(explorePage.checkResultsForSearchingUser(userHandle), "Could not search for User Handle");
    }

}
