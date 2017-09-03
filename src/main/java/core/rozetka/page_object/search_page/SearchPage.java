package core.rozetka.page_object.search_page;

import core.rozetka.page_object.home_page.HomePageRozetka;
import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchPage extends HomePageRozetka {

    @FindBy(id = "image_item11241577")
    private WebElement divTwo;

    @FindBy(xpath = "//*[@id='block_with_search']/div/div[2]/div/div/div/div[2]/div[4]")
    private WebElement divOne;

    @FindBy(xpath = "//*[@id='block_with_search']/div/div[2]/div/div/div/div[2]/div[5]/ul/li[2]/label/span")
    private WebElement firstItem;


    @FindBy(xpath = "//*[@id='block_with_search']/div/div[3]/div/div/div/div[2]/div[5]/ul/li[2]/label/span")
    private WebElement secondItem;

    @FindBy(xpath = "//*[@id='block_with_search']/div/div[3]/div/div/div/div[2]/div[5]/ul/li[2]/span/a")
    private WebElement compare;

    @FindBy(xpath = "//span[@class='hub-i-count']")
    private WebElement counter;

    @FindAll({@FindBy(xpath = "//div[@class='comparison-t-row']")})
    private List<WebElement> keys;

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SearchPage searchPage() {

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
            actions.moveToElement(compare).perform();
        compare.click();

        return new SearchPage(driver);

    }

    public Pair<Map<String, String>, Map<String, String>> getSearchInfoFirst() {

        Map<String, String> iphone1 = new HashMap<>();
        Map<String, String> iphone2 = new HashMap<>();

        int size = driver.findElements(By.xpath("//div[@class='comparison-t-cell-first']")).size();
        for (int i = 0; i < size; i++) {
            String key = driver.findElements(By.xpath("//div[@class='comparison-t-cell-first']")).get(i).getText();
            String value1 = driver.findElements(By.xpath("//div[@class='comparison-t-cell'][1]")).get(i).getText();
            String value2 = driver.findElements(By.xpath("//div[@class='comparison-t-cell'][2]")).get(i).getText();
            iphone1.put(key, value1);
            iphone2.put(key, value2);
        }

        return Pair.of(iphone1, iphone2);

    }
}
