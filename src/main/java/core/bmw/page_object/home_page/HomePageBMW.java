package core.bmw.page_object.home_page;

import core.common.AbstractPage;
import core.hotline.page_object.search_result_page.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class HomePageBMW extends AbstractPage {

    public HomePageBMW(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[@class='ds2-navigation-main--level-1-item ds2-navigation-main--link ds2-icon ds2-icon--all-models-white  ds2-tracking-js--event']")
    private WebElement autoBMW;





    public SearchResultPage searchPageBmw() {

        Actions actions = new Actions(driver);

        actions.moveToElement(autoBMW).perform();
        autoBMW.click();


        return new SearchResultPage(driver);
    }
}

