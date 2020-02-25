package com.wikipediatest.pages;

import com.wikipediatest.resources.TestElementSelectors;
import com.wikipediatest.utils.BaseTest;
import org.openqa.selenium.By;

import static org.testng.Assert.assertEquals;

public class WikipediaArticlePage extends BaseTest {

    //Selectors
    private static By firstHeader=By.cssSelector(TestElementSelectors.WAP_FIRST_HEADER_CSS_ID);
    private static By RightNavEditTab=By.cssSelector(TestElementSelectors.WAP_RIGHT_NAV_EDIT_TAB_CSS_ID);

    //Assertions
    public static void assertFirstHeaderMatchesExpected(String expectedHeader) {
        assertEquals(driver.findElement(firstHeader).getText(), expectedHeader);
    }

    //Actions
    public static void tapRightNavEditTab() {
        driver.findElement(RightNavEditTab).click();
    }
}
