package core.hotline.page_object.search_result_page;

import com.google.common.collect.Lists;
import core.hotline.page_object.check_number_of_item.CheckNumberOfItems;
import core.hotline.page_object.home_page.HomePageHotline;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 14.08.2017.
 */
public class SearchResultPage extends HomePageHotline {


    @FindAll({@FindBy(xpath = "//a[@data-eventlabel='Product name']")})
    private List<WebElement> results;

    @FindBy(xpath = "//a[@title='Цены на Samsung Galaxy S8 64GB Black (SM-G950FZKD)']")
    private WebElement firstLink;

    @FindBy(xpath = "//a[@title='Сравнить цены Samsung Galaxy A5 2017 Black (SM-A520FZKD)']")
    private WebElement secondLink;

    @FindBy(xpath = "//a[@title='Сравнить цены Samsung G935FD Galaxy S7 Edge 32GB Black (SM-G935FZKU)']")
    private WebElement thirdLink;

    @FindBy(xpath = "//span[@data-statistic-key='stat217']")
    private WebElement viewItems;

    @FindBy(xpath = "//a[@href='/mobile/mobilnye-telefony-i-smartfony/294356/']")
    private WebElement backStep;

    private List<WebElement> resultsOfItemsNumber;

    public SearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CheckNumberOfItems checkNumberOfItems() {
        Actions actions = new Actions(driver);
        JavascriptExecutor jsx = (JavascriptExecutor) driver;

        actions.moveToElement(firstLink).click().perform();
        backStep.click();

        jsx.executeScript("window.scrollBy(0,600)", secondLink);
        secondLink.click();
        backStep.click();

        jsx.executeScript("window.scrollBy(0,600)", thirdLink);
        thirdLink.click();
        backStep.click();


        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(viewItems));
        actions.moveToElement(viewItems).click().perform();

        return new CheckNumberOfItems(driver);
    }

    public List<String> getSearchResults() {
        List<String> resultsTitles = new ArrayList<String>();
        for (WebElement element : results) {
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
        List<String> reverseResultsOfItemsNumbers = Lists.reverse(resultsOfItemsNumbers);
        return reverseResultsOfItemsNumbers;
    }
}
