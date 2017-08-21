package core.hotline.page_object.check_prices_resuls_page;

import core.hotline.page_object.home_page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class CheckPricesResultPage extends HomePage {

    @FindAll({@FindBy(xpath = "//a[@id='gotoshop-price']")})
    private List<WebElement> results;

    @FindBy(xpath = "//a[@title='Сравнить цены Samsung Galaxy S8 64GB Black (SM-G950FZKD)']")
    private WebElement checkPrices;

    @FindBy(xpath = "//*[@id='mm-0']/div[7]/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/a/strong")
    private WebElement priceRange;

    public CheckPricesResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CheckPricesResultPage checkPrices() {
        checkPrices.click();

        return new CheckPricesResultPage(driver);
    }

    public List<Integer> getSearchPrices() {
        List<Integer> resultsPrices = new ArrayList<Integer>();

        for (WebElement element : results) {
            String priceString = element.getText();
            String priceString2 = priceString.replaceAll(",", ".")
                    .replaceAll(" ", "");
            double priceDouble = Double.parseDouble(priceString2);
            int price = (int) priceDouble;
            resultsPrices.add(price);
        }
        return resultsPrices;
    }

    public String getPriceRange() {
        return priceRange.getText();
    }

}
