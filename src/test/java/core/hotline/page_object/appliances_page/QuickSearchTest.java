package core.hotline.page_object.appliances_page;

import core.hotline.page_object.home_page.HomePageTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuickSearchTest extends HomePageTest {

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
