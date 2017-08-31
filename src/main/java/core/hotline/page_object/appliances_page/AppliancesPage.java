package core.hotline.page_object.appliances_page;

import core.hotline.page_object.home_page.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.Properties;

//Пока убрала эту аннотацию, потому что мы ее на занятии не дописали



public class AppliancesPage extends HomePage {

    private String text = "";

    @FindBy(xpath = "//div[text()='Выберите категорию']")
    private WebElement chooseCategory;

    @FindBy(xpath = "//li[text()='Электрочайники']")
    private WebElement kettle;

    @FindBy(xpath = "//div[text()='Выберите производителя']")
    private WebElement chooseManufacturer;

    @FindBy(xpath = "//li[text()='Zanussi']")
    private WebElement zanussi;

    @FindBy(xpath = "//div[text()='Выберите модель']")
    private WebElement chooseModel;

    @FindBy(xpath = "//li[text()='ZWA1260']")
    private WebElement model;

    @FindBy(xpath = "//a[@class='but-box cell but-blue fl js-view-result g_statistic']")
    private WebElement buttonShow;

    @FindBy(xpath = "//span[@data-statistic-key='stat42']")
    private WebElement showmore;

    @FindBy(xpath = "//h1[@class='title-24 p_b-5']")
    private WebElement titleOfPage;

    @FindBy(xpath = "//*[@id='mm-0']/div[7]/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/a/strong")
    private WebElement price;

    @FindBy(xpath = "//p[@class='full-desc text-14']")
    private WebElement description;

    @FindBy(xpath = "//div[@class='th-tabl']")
    private WebElement characteristics;

    public AppliancesPage(WebDriver webDriver) {
        super(webDriver);
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

    public String titleOfFoundPage() {

        String titleOfFoundPage = titleOfPage.getText().replaceAll(" ", "");
        return titleOfFoundPage;
    }

    public void writeToFile() {

        File file = new File("text_from_found_page.properties");

        if (file.exists()) {
            file.delete();
        }

        String text1 = price.getText();
        String text2 = description.getText();
        String text3 = characteristics.getText();

        Properties prop = new Properties();
        OutputStream output = null;

        try {
            output = new FileOutputStream("text_from_found_page.properties");

            prop.setProperty("Цены", text1);
            prop.setProperty("Описание", text2);
            prop.setProperty("Характеристики", text3);

            prop.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
