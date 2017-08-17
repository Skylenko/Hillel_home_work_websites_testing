package home_page;

import core.hotline.page_object.check_number_of_item.CheckNumberOfItems;
import core.hotline.page_object.check_prices_resuls_page.CheckPricesResultPage;
import core.hotline.page_object.home_page.HomePage;
import core.hotline.page_object.search_result_page.SearchResultPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class HomePageTest {

    private WebDriver driver;

    @Before
    public void driverSetUp() {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://hotline.ua");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();

    }


    @Test
    public void searchBarTesting() {

        HomePage homePage = new HomePage(driver);
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
    public void checkPricesTesting() {

        HomePage homePage = new HomePage(driver);
        String searchCondition = "Samsung";
        homePage.searchByText(searchCondition);
        CheckPricesResultPage checkPricesResultPage = homePage.checkPrices();
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

    @Test
    public void checkNumberOfItemsTesting() {

        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = homePage.searchByText("Samsung");
        List<String> items = searchResultPage.getItemName();
        CheckNumberOfItems checkNumberOfItems = homePage.checkNumberOfItems();
        List<String> viewItems = checkNumberOfItems.getViewResults();
        Assert.assertEquals(items, viewItems);


    }

}






