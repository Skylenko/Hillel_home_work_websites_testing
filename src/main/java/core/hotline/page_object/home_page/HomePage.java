package core.hotline.page_object.home_page;

import core.hotline.page_object.check_number_of_item.CheckNumberOfItems;
import core.hotline.page_object.check_prices_resuls_page.CheckPricesResultPage;
import core.hotline.page_object.common.AbstractPage;
import core.hotline.page_object.search_result_page.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

    @FindBy(id = "searchbox")
    private WebElement searchBar;

    @FindBy(id = "doSearch")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@title='Сравнить цены Samsung Galaxy S8 64GB Black (SM-G950FZKD)']")
    private WebElement checkPrices;

    @FindBy(xpath = "//*[@id='mm-0']/div[7]/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/a/strong")
    private WebElement diapazon;

    @FindBy(xpath = "//*[@id='mm-0']/div[7]/div[2]/div[2]/div[2]/div[3]/div/div/div[2]/div[1]/b/a")
    private WebElement firstLink;

    @FindBy(xpath = "//*[@id='mm-0']/div[7]/div[2]/div[2]/div[2]/div[4]/div/div/div[2]/div[1]/b/a")
    private WebElement secondLink;

    @FindBy(xpath = "//*[@id='catalogue']/div[6]/div[3]/div/div/div[2]/div[1]/b/a")
    private WebElement thirdLink;

    @FindBy(xpath = "//*[@id='mm-0']/div[7]/div[2]/div/div/strong/a")
    private WebElement backStep;

    @FindBy(xpath = "//*[@id='mm-0']/div[3]/div/div[6]/span")
    private WebElement viewItems;

    private WebDriver driver;

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

    public CheckPricesResultPage checkPrices() {
        checkPrices.click();
        diapazon.getText();

        return new CheckPricesResultPage(driver);
    }

    public CheckNumberOfItems checkNumberOfItems() {

        firstLink.click();
        backStep.click();

        //при запуске этого сценария после первых кликов все падает, не могу решить эту проблему, но с одним кликом запускается нормально

       /* WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//*[@id='mm-0']/div[7]/div[2]/div[2]/div[2]/div[4]/div/div/div[2]/div[1]/b/a")), "Samsung Galaxy A5 2017 Black (SM-A520FZKD)"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id='mm-0']/div[7]/div[2]/div[2]/div[2]/div[4]/div/div/div[2]/div[1]/b/a")));

        secondLink.click();
        backStep.click();
        thirdLink.click();
        backStep.click();
        viewItems.click();*/

        return new CheckNumberOfItems(driver);
    }
}
