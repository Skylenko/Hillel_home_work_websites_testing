package core.bmw.searchPageBmw;

import core.common.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchPageBmw extends AbstractPage {

    @FindBy(xpath = "//form[@class='show-for-medium-up']/ul/li[3]/span")
    private WebElement kabr;

    @FindBy(xpath = "//form[@class='show-for-medium-up']/ul/li[4]/span")
    private WebElement kupe;

    @FindBy(xpath = "/html/body/div[1]/main/div/div/div[1]/div")
    private WebElement element;


    @FindBy(xpath = "//*[@id='ds2-models-js--series-wrap']/div/section[2]/article[3]/div/div[2]/ul/li/a")
    private WebElement knowMore;

    @FindBy(xpath = "//ul[@class='ds2-navigation-content-bar--button']")
    private WebElement dropdown;

    @FindBy(xpath = "//*[@id='undefined-sticky-wrapper']/div/div[2]/div/div/div/div/ul/li[4]/a")
    private WebElement dvig;

    @FindBy(xpath = "//*[@id='ui-id-1']")
    private WebElement plus;

    public SearchPageBmw(WebDriver webDriver) {
        super(webDriver);
    }

    public SearchPageBmw pageRez() {
        Actions actions = new Actions(driver);

        WebElement[] str = new WebElement[]{kabr, kupe};

        for (int i = 0; i < str.length; i++) {
            actions.moveToElement(str[i]).build().perform();
            str[i].click();
            new WebDriverWait(driver, 30).until(ExpectedConditions.attributeToBe(element, "id", "ds2-models-js--series-wrap"));

        }

        List<String> viewResults = driver.findElements(By.xpath("//*[@id='ds2-models-js--series-wrap']/div/section/article/div/div/h4"))
                .stream()
                .filter(item -> item.getText().contains("Кабриолет"))
                .map(element -> element.getText())
                .collect(Collectors.toList());

        List<String> viewResults2 = driver.findElements(By.xpath("//*[@id='ds2-models-js--series-wrap']/div/section/article/div/div/h4"))
                .stream()
                .filter(item -> item.getText().contains("Купе"))
                .map(el -> el.getText())
                .collect(Collectors.toList());

        actions.moveToElement(kupe).perform();
        kupe.click();

        return new SearchPageBmw(driver);

    }

    public SearchPageBmw pageKabr() {
        Actions actions = new Actions(driver);
        knowMore.click();


        dropdown.click();
        actions.moveToElement(dvig).build().perform();

        dvig.click();

        actions.moveToElement(plus).perform();
        plus.click();

        new WebDriverWait(driver,30).until(ExpectedConditions.attributeToBe(plus,"aria-selected", "true"));
        return new SearchPageBmw(driver);
    }

       public Map<String, String> getInfo() {
           Map<String, String> info = new HashMap<>();
           int size = driver.findElements(By.xpath("//*[@id='ui-id-2']/div/div/div/table/tbody/tr")).size();
           for (int i = 0; i < size; i++) {

               String key = driver.findElements(By.xpath("//*[@id='ui-id-2']/div/div/div/table/tbody/tr/td[1]/div")).get(i).getText();
               String value = driver.findElements(By.xpath("//*[@id='ui-id-2']/div/div/div/table/tbody/tr/td[2]/div")).get(i).getText();
               info.put(key, value);
           }
           return info;
       }
}
