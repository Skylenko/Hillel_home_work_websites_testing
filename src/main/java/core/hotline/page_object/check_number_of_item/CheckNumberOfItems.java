package core.hotline.page_object.check_number_of_item;

import core.hotline.page_object.home_page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CheckNumberOfItems extends HomePage {

    @FindAll({@FindBy(xpath = "//a[@class='g_statistic']")}) //сдесь не могу подобрать корректный запрос
    private List<WebElement> items;

    public CheckNumberOfItems(WebDriver webDriver) {
        super(webDriver);
    }

    public List<String> getViewResults() {
        List<String> viewResults = new ArrayList<String>();
        for (WebElement element : items) {
            String text = element.getText();
            viewResults.add(text);

        }
        return viewResults;
    }
}
