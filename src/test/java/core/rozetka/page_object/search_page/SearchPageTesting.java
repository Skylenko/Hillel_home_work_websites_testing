package core.rozetka.page_object.search_page;

import core.common.CommonTest;
import core.rozetka.page_object.home_page.HomePageRozetka;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class SearchPageTesting extends CommonTest {

    public SearchPageTesting() throws IOException {
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
    public void searchBarTesting() {

        HomePageRozetka homePageRozetka = new HomePageRozetka(getDriver());
        String searchCondition = "iphon7";
        homePageRozetka.searchText(searchCondition);
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchPage();
        Pair<Map<String, String>, Map<String, String>> rez = searchPage.getSearchInfoFirst();

        Map<String, String> first = rez.getLeft();
        Map<String, String> second = rez.getRight();

        String textMatrix = first.get("Тип матрицы");
        String textCam = first.get("Количество мегапикселей фронтальной камеры");
        String textProc = first.get("Название");

        String textMatrix2 = second.get("Тип матрицы");
        String textCam2 = second.get("Количество мегапикселей фронтальной камеры");
        String textProc2 = second.get("Название");

        Assert.assertEquals(textMatrix, textMatrix2);
        Assert.assertEquals(textCam, textCam2);
        Assert.assertEquals(textProc, textProc2);

    }
}

