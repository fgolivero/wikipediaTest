package com.wikipediatest.tests;

import com.wikipediatest.pages.WikipediaEditArticlePage;
import com.wikipediatest.utils.BaseTest;
import com.wikipediatest.pages.WikipediaArticlePage;
import com.wikipediatest.pages.WikipediaLandingPage;
import com.wikipediatest.resources.TestData;
import com.wikipediatest.utils.HelperMethods;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WikipediaLandingTests extends BaseTest {

    @BeforeMethod
    public void init() {
        BaseTest.launchTestWithSpecificDriver(TestData.SUPPORTED_BROWSERS[1]);
        driver.get(TestData.WIKIPEDIA_HOMEPAGE);
    }

    @AfterMethod
    public void tearDown() {
            driver.manage().deleteAllCookies();
            driver.quit();
        }

     @Test
    public void testWikipediaLogoIsDisplayed() {
        WikipediaLandingPage.assertWikipediaLogoIsDisplayed();
        }

     @Test
    public void testLanguageChange() {
         WikipediaLandingPage.assertLanguageChoice(TestData.ENGLISH_LANG_2_LETTER_CODE);
     }

     @Test
     public void testPerformASearch() {
        WikipediaLandingPage.performASearchWithGivenString(TestData.WLP_TEST_STRING_COURAGE);
        HelperMethods.assertDriverNavigatedToSpecificPage(TestData.WLP_TEST_COURAGE_HTTP_LINK);
        WikipediaArticlePage.assertFirstHeaderMatchesExpected(TestData.WLP_TEST_STRING_COURAGE);
     }

     @Test
    public void testEditTabAndPopUpUX() {
        WikipediaLandingPage.performASearchWithGivenString(TestData.WLP_TEST_STRING_COURAGE);
        WikipediaArticlePage.tapRightNavEditTab();
        WikipediaEditArticlePage.tapStartEditingPopUpButton();
     }
}

