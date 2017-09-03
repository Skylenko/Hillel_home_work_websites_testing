package core.rozetka.page_object.search_page;

import core.rozetka.page_object.home_page.HomePageRozetka;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends HomePageRozetka {

    @FindBy(xpath = "//*[@id='block_with_search']/div/div[2]/div/div/div/div[2]/div[5]/ul/li[2]/span/a")
    private WebElement firstItem;

    @FindBy(xpath = "//*[@id='block_with_search']/div/div[3]/div/div/div/div[2]/div[5]/ul/li[2]/span/a/img")
    private WebElement secondItem;

    @FindBy(xpath = "//a[@class='sprite-side novisited hub-i-link hub-i-comparison-link-count']")
    private  WebElement compare;

    @FindBy(xpath = "//a[@class='btn-link btn-link-gray']")
    private WebElement compareButton;

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SearchPage searchPage(){

        Actions actions = new Actions(driver);

        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(firstItem));
        firstItem.click();

        actions.moveToElement(secondItem).click().perform();

        compare.click();
        compareButton.click();
        return new SearchPage(driver);

    }
}
