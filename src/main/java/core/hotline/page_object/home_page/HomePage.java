package core.hotline.page_object.home_page;


import core.hotline.page_object.common.AbstractPage;
import core.hotline.page_object.search_result_page.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(id = "searchbox")
    private WebElement searchBar;

    @FindBy(id = "doSearch")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@data-eventaction='Бытовая техника']")
    protected WebElement appliance;


    protected WebDriver driver;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        this.driver = webDriver;
    }

    public SearchResultPage searchByText(String text) {

        searchBar.clear();
        searchBar.sendKeys(text);
        searchButton.click();

        return new SearchResultPage(driver);


    }




}
