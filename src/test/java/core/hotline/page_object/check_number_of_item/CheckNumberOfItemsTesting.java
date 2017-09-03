package core.hotline.page_object.check_number_of_item;

import core.common.CommonTest;
import core.hotline.page_object.home_page.HomePageHotline;
import core.hotline.page_object.search_result_page.SearchResultPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CheckNumberOfItemsTesting extends CommonTest {


    public CheckNumberOfItemsTesting() throws IOException {
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
    public void checkNumberOfItemsTesting() {

        HomePageHotline homePage = new HomePageHotline(driver);
        SearchResultPage searchResultPage = homePage.searchByText("Samsung");
        List<String> items = searchResultPage.getItemName();
        CheckNumberOfItems checkNumberOfItems = searchResultPage.checkNumberOfItems();
        List<String> viewItems = checkNumberOfItems.getViewResults();
        assertEquals(items, viewItems);

    }

}
