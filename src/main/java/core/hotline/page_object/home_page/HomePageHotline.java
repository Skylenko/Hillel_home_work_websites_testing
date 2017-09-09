package core.hotline.page_object.home_page;


import core.common.AbstractPage;
import core.hotline.page_object.search_result_page.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class HomePageHotline extends AbstractPage {

    @FindBy(id = "searchbox")
    private WebElement searchBar;

    @FindBy(id = "doSearch")
    private WebElement searchButton;

    @FindBy (xpath = "//*[@id='lv-1-898']/a/b")
    private WebElement autoMoto;

    @FindBy(xpath = "(//div[@class='m-sub-box'])[1]//a[@data-eventaction='Авто и Мото' and contains(@class, 'top g_statistic')]")
    private List<WebElement> findItems;

    protected WebDriver driver;

    public HomePageHotline(WebDriver webDriver) {
        super(webDriver);
        this.driver = webDriver;
    }

    public SearchResultPage searchByText(String text) {

        searchBar.clear();
        searchBar.sendKeys(text);
        searchButton.click();

        return new SearchResultPage(driver);


    }

    public List<String> getResults() {

        Actions actions = new Actions(driver);

        actions.moveToElement(autoMoto).perform();

        List<WebElement> viewResults = driver.findElements(By.xpath("//*[@id='lv-1-898']/div/ul/li/a"));
        return viewResults.stream()
                .filter(item -> !item.getText().contains("Гид покупателя"))
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

}
