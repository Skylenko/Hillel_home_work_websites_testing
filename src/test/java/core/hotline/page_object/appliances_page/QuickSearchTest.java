package core.hotline.page_object.appliances_page;

import core.hotline.page_object.home_page.HomePage;
import core.hotline.page_object.home_page.HomePageTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuickSearchTest extends HomePageTest {

    @Test
    public void quickSearchTesting(){

        HomePage homePage = new HomePage(driver);
        AppliancesPage appliancesPage = homePage.quickSearch();
        String actualTitles = appliancesPage.titleOfFoundPage();
        String selectedTitles = homePage.getText();

        assertEquals(actualTitles, selectedTitles);// здесь не получается сверить стринги, потому что в итоговой странице пишет "электрочайник",
        //а при выборе категории пишет "электрочайники", поэтому я у ожидаемого результата у первой стринги отрезаю последний элемент и тест срабатывает

        appliancesPage.writeToFile();
    }
}
