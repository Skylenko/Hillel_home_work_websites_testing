package core.hotline.page_object.check_prices_resuls_page;

import core.common.CommonTest;
import core.hotline.page_object.home_page.HomePageHotline;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CheckPricesPageTesting extends CommonTest {

    public CheckPricesPageTesting() throws IOException {
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
    public void checkPricesTesting() {

        HomePageHotline homePage = new HomePageHotline(driver);
        String searchCondition = "Samsung";
        homePage.searchByText(searchCondition);
        CheckPricesResultPage checkPricesResultPage = new CheckPricesResultPage(driver);
        checkPricesResultPage.checkPrices();
        List<Integer> prices = checkPricesResultPage.getSearchPrices();

        int max = Collections.max(prices);
        int min = Collections.min(prices);

        String priceRange = checkPricesResultPage.getPriceRange();

        int endIndex = priceRange.indexOf("–");

        String minPrice = priceRange.substring(0, endIndex).replaceAll(" ", "");
        int minPriceInt = Integer.parseInt(minPrice);

        String maxPrice = priceRange.substring(endIndex + 1, priceRange.length()).replaceAll(" ", "");
        int maxPriceInt = Integer.parseInt(maxPrice);

        assertEquals(max, maxPriceInt);
        assertEquals(min, minPriceInt);
    }
}
