package core.hotline.page_object.search_result_page;

import core.hotline.page_object.home_page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 14.08.2017.
 */
public class SearchResultPage extends HomePage {

    @FindAll({@FindBy(xpath = "//a[@data-eventlabel='Product name']")})
    private List<WebElement> results;
    private List<WebElement> resultsOfItemsNumber;

    public SearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<String> getSearchResults(){
        List<String> resultsTitles = new ArrayList<String>();
        for (WebElement element: results){
            String text = element.getText();
            resultsTitles.add(text);

        }
        return resultsTitles;



    }
    public List<String> getItemName() {

        List<String> resultsOfItemsNumbers = new ArrayList<String>();

        for (int i = 0; i <= 2; i++) {
            String text = getSearchResults().get(i).toString();
            resultsOfItemsNumbers.add(text);
        }

        return resultsOfItemsNumbers;
    }
}
