package core.hotline.page_object.home_page;

import core.hotline.page_object.appliances_page.AppliancesPage;
import core.hotline.page_object.check_number_of_item.CheckNumberOfItems;
import core.hotline.page_object.check_prices_resuls_page.CheckPricesResultPage;
import core.hotline.page_object.common.utils.PropertyUtils;
import core.hotline.page_object.home_page.HomePage;
import core.hotline.page_object.search_result_page.SearchResultPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HomePageTest {

    protected WebDriver driver;
    private PropertyUtils propertyUtils = null;

    public HomePageTest() {
        try {
            this.propertyUtils = new PropertyUtils();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void driverSetUp() {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(propertyUtils.getProperty("main.site.ulr"));
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
}






