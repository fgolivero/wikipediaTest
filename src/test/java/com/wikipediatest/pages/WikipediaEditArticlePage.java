package com.wikipediatest.pages;

import com.wikipediatest.resources.TestElementSelectors;
import com.wikipediatest.utils.BaseTest;
import org.openqa.selenium.By;

public class WikipediaEditArticlePage extends BaseTest {

    //Selectors
    private static By startEditingPopUpButton=By.cssSelector(TestElementSelectors.WAP_START_EDITING_BUTTON_POPUP_CSS_CLASS);

    //Assertions

    //Actions
    public static void tapStartEditingPopUpButton() {
        driver.findElement(startEditingPopUpButton).click();
    }
}

