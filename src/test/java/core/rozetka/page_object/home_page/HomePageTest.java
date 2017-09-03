package core.rozetka.page_object.home_page;

import core.common.CommonTest;
import core.rozetka.page_object.search_page.SearchPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;

public class HomePageTest extends CommonTest{

    public HomePageTest() throws IOException {
    }

    @Before()
    public void webDriverSetUp() {
        driverSetUp();
        driver.get(propertyUtils.getProperty("main.site.url.rozetka"));

    }
    @After
    public void webDriverTearDown() {
        tearDown();
    }

    @Test
    public void searchBarTesting(){

        HomePageRozetka homePageRozetka = new HomePageRozetka(getDriver());

        String searchCondition = "iphon7";
        homePageRozetka.searchText(searchCondition);
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchPage();


    }
}
