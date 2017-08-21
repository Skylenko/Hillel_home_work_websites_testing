package core.hotline.page_object.home_page;

import core.hotline.page_object.appliances_page.AppliancesPage;
import core.hotline.page_object.check_number_of_item.CheckNumberOfItems;
import core.hotline.page_object.check_prices_resuls_page.CheckPricesResultPage;
import core.hotline.page_object.common.AbstractPage;
import core.hotline.page_object.search_result_page.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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

    @FindBy(xpath = "//*[@id='catalogue']/div[6]/div[2]/div/div/div[3]/div[2]/div[2]/a")
    private WebElement secondLink;

    @FindBy(xpath = "//*[@id='catalogue']/div[6]/div[3]/div/div/div[3]/div[2]/div[2]/a")
    private WebElement thirdLink;

    @FindBy(xpath = "//*[@id='mm-0']/div[7]/div[2]/div/div/strong/a")
    private WebElement backStep;

    @FindBy(xpath = "//*[@id='mm-0']/div[3]/div/div[6]/span")
    private WebElement viewItems;

    @FindBy(xpath = "//a[@data-eventaction='Бытовая техника']")
    private WebElement appliance;

    @FindBy(xpath = "//*[@id='byStepSelection']/div[2]/div/div[1]/span/div[1]/div")
    private WebElement chooseCategory;

    @FindBy(xpath = "//*[@id='byStepSelection']/div[2]/div/div[1]/span/div[2]/ul/li[77]")
    private WebElement kettle;

    @FindBy(xpath = "//*[@id='byStepSelection']/div[2]/div/div[2]/span/div[1]/div")
    private WebElement chooseManufacturer;

    @FindBy(xpath = "//li[text()='Zanussi']")
    private WebElement zanussi;


    @FindBy(xpath = "//*[@id='byStepSelection']/div[2]/div/div[3]/span/div[1]/div")
    private WebElement chooseModel;

    @FindBy(xpath = "//li[text()='ZWA1260']")
    private WebElement model;

    @FindBy(xpath = "//a[@class='but-box cell but-blue fl js-view-result g_statistic']")
    private WebElement buttonShow;

    @FindBy(xpath = "//*[@id='mm-0']/div[7]/div[4]/div[2]/div[2]/div[1]/span[1]/span")
    private WebElement showmore;

    private WebDriver driver;

    private String text = "";


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

        actions.moveToElement(viewItems).click().perform();

        return new CheckNumberOfItems(driver);
    }

    public AppliancesPage quickSearch() {


        appliance.click();

        chooseCategory.click();
        new Select(driver.findElement(By.xpath("//*[@id='byStepSelection']/div[2]/div/div[1]/select")));
        String kettletext = kettle.getText();
        text += kettletext.substring(0, kettletext.length() - 1);
        kettle.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.attributeToBe(By.xpath("//*[@id='byStepSelection']/div[2]/div/div[2]/select"), "disabled", ""));

        chooseManufacturer.click();
        new Select(driver.findElement(By.xpath("//*[@id='byStepSelection']/div[2]/div/div[2]/select")));
        text += zanussi.getText();
        zanussi.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.attributeToBe(By.xpath("//*[@id='byStepSelection']/div[2]/div/div[3]/select"), "disabled", ""));

        chooseModel.click();
        new Select(driver.findElement(By.xpath("//*[@id='byStepSelection']/div[2]/div/div[3]/select")));
        text += model.getText();
        model.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(buttonShow));
        buttonShow.click();

        showmore.click();

        return new AppliancesPage(driver);
    }

    public String getText() {

        return text;
    }
}
