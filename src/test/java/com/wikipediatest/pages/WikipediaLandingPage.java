package com.wikipediatest.pages;

import com.wikipediatest.resources.TestElementSelectors;
import com.wikipediatest.utils.BaseTest;
import com.wikipediatest.utils.HelperMethods;
import org.openqa.selenium.By;
import com.wikipediatest.resources.TestData;

public class WikipediaLandingPage extends BaseTest {

    //Selectors
    private static By selectLanguagePicker=By.cssSelector(TestElementSelectors.WLP_SELECT_LANGUAGE_CSS_ID);
    private static By selectedLanguagePickerLabel=By.cssSelector(TestElementSelectors.WLP_SELECTED_LANGUAGE_LABEL_CSS_ID);
    private static By searchInputField=By.cssSelector(TestElementSelectors.WLP_SEARCH_INPUT_FIELD_CSS_ID);
    private static By searchMagIcon = By.cssSelector(TestElementSelectors.WLP_SEARCH_MAG_ICON_CSS_CLASS);

    //Assertions
    public static void assertWikipediaLogoIsDisplayed() {
        HelperMethods.assertElementIsDisplayedByCssSelector(TestElementSelectors.WLP_WORLD_LOGO_CSS_CLASS);

    }

    public static void assertLanguageChoice(String languageOfChoice) {
        HelperMethods.selectAndAssertSelectionForGivenLanguage(selectLanguagePicker, selectedLanguagePickerLabel, languageOfChoice);
    }


    //Actions
    public static void performASearchWithGivenString(String givenString) {
        driver.findElement(searchInputField).sendKeys(TestData.WLP_TEST_STRING_COURAGE);
        driver.findElement(searchMagIcon).click();
    }
}