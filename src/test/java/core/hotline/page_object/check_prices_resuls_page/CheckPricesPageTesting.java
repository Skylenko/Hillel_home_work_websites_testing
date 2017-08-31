package core.hotline.page_object.check_prices_resuls_page;

import core.hotline.page_object.common.CommonTest;
import core.hotline.page_object.home_page.HomePage;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CheckPricesPageTesting extends CommonTest {

    public CheckPricesPageTesting() throws IOException {
    }

    @Test
    public void checkPricesTesting() {

        HomePage homePage = new HomePage(driver);
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
