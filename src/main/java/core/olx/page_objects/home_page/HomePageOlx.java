package core.olx.page_objects.home_page;

import core.common.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class HomePageOlx extends AbstractPage{

    public HomePageOlx(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//*[@id='searchmain-container']/div/div/div[1]/div[3]")
    private WebElement vehicle;

    public List<String> getResults() {

        Actions actions = new Actions(driver);

        actions.moveToElement(vehicle).perform();
        vehicle.click();

        List<WebElement> viewResults = driver.findElements(By.xpath("//a[@class='link-relatedcategory cat-1532 inlblk tdnone icon-link']"));
        return viewResults.stream()
                .filter(item-> item.getText().contains("транспорт"))
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }
}
