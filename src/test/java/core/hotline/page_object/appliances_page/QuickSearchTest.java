package core.hotline.page_object.appliances_page;

import core.common.CommonTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class QuickSearchTest extends CommonTest {

    public QuickSearchTest() throws IOException {
    }

    @Before()
    public void webDriverSetUp() {
        driverSetUp();
        driver.get(propertyUtils.getProperty("main.site.ulr"));

    }
    @After
    public void webDriverTearDown() {
        tearDown();
    }

    @Test
    public void quickSearchTesting(){

        AppliancesPage appliancesPage = new AppliancesPage(driver);
        appliancesPage.quickSearch();

        String actualTitles = appliancesPage.titleOfFoundPage();
        String selectedTitles = appliancesPage.getText();

        assertEquals(actualTitles, selectedTitles);

        appliancesPage.writeToFile();
    }
}
