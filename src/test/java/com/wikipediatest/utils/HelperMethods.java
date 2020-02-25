package com.wikipediatest.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertEquals;

public class HelperMethods extends BaseTest {

    public static void assertElementIsDisplayedByCssSelector(String cssSelector) {
        assertEquals("visible", driver.findElement(By.cssSelector(cssSelector)).getCssValue("visibility"));
    }

    public static void selectAndAssertSelectionForGivenLanguage(By pickerElement, By pickerLabel, String languageCode) {
        Select select = new Select(driver.findElement(pickerElement));
        select.selectByValue(languageCode.toLowerCase());
        assertEquals(languageCode.toUpperCase(), driver.findElement(pickerLabel).getText());
    }

    public static void assertDriverNavigatedToSpecificPage(String expectedUrl) {
        assertEquals(driver.getCurrentUrl(), expectedUrl);
    }


}