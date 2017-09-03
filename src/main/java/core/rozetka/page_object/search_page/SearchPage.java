package core.rozetka.page_object.search_page;

import core.rozetka.page_object.home_page.HomePageRozetka;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends HomePageRozetka {

    @FindBy(id ="image_item11241577")
    private  WebElement divTwo;

    @FindBy(xpath = "//*[@id='block_with_search']/div/div[2]/div/div/div/div[2]/div[4]")
    private WebElement divOne;

    @FindBy(xpath = "//*[@id='block_with_search']/div/div[2]/div/div/div/div[2]/div[5]/ul/li[2]/label/span")
    private WebElement firstItem;


    @FindBy(xpath = "//*[@id='block_with_search']/div/div[3]/div/div/div/div[2]/div[5]/ul/li[2]/label/span")
    private WebElement secondItem;

    @FindBy(xpath = "//*[@id='block_with_search']/div/div[3]/div/div/div/div[2]/div[5]/ul/li[2]/span/a")
    private  WebElement compare;

    @FindBy(xpath = "//a[@class='btn-link btn-link-gray']")
    private WebElement compareButton;

    @FindBy(xpath = "//span[@class='hub-i-count']")
    private WebElement counter;

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SearchPage searchPage(){

        Actions actions = new Actions(driver);

        actions.moveToElement(divOne).build().perform();
        actions.moveToElement(firstItem).perform();
        firstItem.click();

        String count = counter.getText();
        if ("1".equals(count))

        actions.moveToElement(divTwo).build().perform();
        actions.moveToElement(secondItem).perform();
        secondItem.click();

        String count2 = counter.getText();
        if ("2".equals(count2))

        compare.click();

        compareButton.click();
        return new SearchPage(driver);

    }
}
