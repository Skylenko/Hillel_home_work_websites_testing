package core.hotline.page_object.home_page;

import core.common.CommonTest;
import core.hotline.page_object.search_result_page.SearchResultPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class HomePageTest extends CommonTest {

    public HomePageTest() throws IOException {
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
    public void searchBarTesting() throws IOException {

        HomePageHotline homePage = new HomePageHotline(getDriver());

        String searchCondition = "Samsung";
        SearchResultPage searchResultPage = homePage.searchByText(searchCondition);
        List<String> titles = searchResultPage.getSearchResults();

        for (String title : titles) {

            Assert.assertTrue(String.format("There is incorrect item text: Ex: [%s], act: [%s]",
                    searchCondition, title),
                    title.contains(searchCondition));
        }
    }

    @Test
    public  void searchItems(){

        HomePageHotline homePageHotline = new HomePageHotline(getDriver());

        List<String> elements = homePageHotline.getResults();

    }

    }








