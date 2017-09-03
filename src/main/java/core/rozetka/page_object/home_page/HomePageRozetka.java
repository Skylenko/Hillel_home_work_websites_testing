package core.rozetka.page_object.home_page;

import core.common.AbstractPage;
import core.rozetka.page_object.search_page.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageRozetka extends AbstractPage {

    @FindBy(xpath = "//*[@id='rz-search']/form/div[1]/div[2]/input")
    private WebElement searchField;

    @FindBy(xpath = "//span[@class='rz-search-button-go-link']")
    private WebElement buttonSearch;

    protected WebDriver driver;


    public HomePageRozetka(WebDriver webDriver) {
        super(webDriver);
        this.driver = webDriver;
    }

    public SearchPage searchText(String text) {

        searchField.clear();
        searchField.sendKeys(text);
        buttonSearch.click();
        return new SearchPage(driver);

    }
}
