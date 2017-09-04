package core.olx;

import core.common.CommonTest;
import core.hotline.page_object.home_page.HomePageHotline;
import core.olx.page_objects.home_page.HomePageOlx;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class HomePageOlxTesting extends CommonTest {

    public HomePageOlxTesting() throws IOException {
    }

    @Before()
    public void webDriverSetUp() {
        driverSetUp();
        driver.get(propertyUtils.getProperty("main.site.url.olx"));

    }
    @After
    public void webDriverTearDown() {
        tearDown();
    }

    @Test

    public  void searchItems(){

        HomePageOlx homePageOlx = new HomePageOlx(getDriver());

        List<String> elements = homePageOlx.getResults();

    }
}
