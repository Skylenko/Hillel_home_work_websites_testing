package core.hotline.page_object.check_number_of_item;

import core.hotline.page_object.common.CommonTest;
import core.hotline.page_object.home_page.HomePage;
import core.hotline.page_object.search_result_page.SearchResultPage;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CheckNumberOfItemsTesting extends CommonTest {


    public CheckNumberOfItemsTesting() throws IOException {
    }

    @Test
    public void checkNumberOfItemsTesting() {

        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = homePage.searchByText("Samsung");
        List<String> items = searchResultPage.getItemName();
        CheckNumberOfItems checkNumberOfItems = searchResultPage.checkNumberOfItems();
        List<String> viewItems = checkNumberOfItems.getViewResults();
        assertEquals(items, viewItems);

    }

}
