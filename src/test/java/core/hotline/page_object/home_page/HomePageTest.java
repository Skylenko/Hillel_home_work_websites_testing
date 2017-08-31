package core.hotline.page_object.home_page;

import core.hotline.page_object.common.CommonTest;
import core.hotline.page_object.search_result_page.SearchResultPage;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class HomePageTest extends CommonTest {

    public HomePageTest() throws IOException {
    }

    @Test
    public void searchBarTesting() throws IOException {

        HomePage homePage = new HomePage(getDriver());

        String searchCondition = "Samsung";
        SearchResultPage searchResultPage = homePage.searchByText(searchCondition);
        List<String> titles = searchResultPage.getSearchResults();

        for (String title : titles) {

            Assert.assertTrue(String.format("There is incorrect item text: Ex: [%s], act: [%s]",
                    searchCondition, title),
                    title.contains(searchCondition));
        }

    }
}






