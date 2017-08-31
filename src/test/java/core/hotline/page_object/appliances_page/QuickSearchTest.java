package core.hotline.page_object.appliances_page;

import core.hotline.page_object.common.CommonTest;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class QuickSearchTest extends CommonTest {

    public QuickSearchTest() throws IOException {
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
