package core.hotline.page_object.appliances_page;

import core.hotline.page_object.home_page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.*;
import java.util.Properties;

//Пока убрала эту аннотацию, потому что мы ее на занятии не дописали
//@DefaultPath(defaultPath = "/bt/")


public class AppliancesPage extends HomePage {
    @FindBy(xpath = "//h1[@class='title-24 p_b-5']")
    private WebElement titleOfPage;

    @FindBy(xpath = "//*[@id='mm-0']/div[7]/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/a/strong")
    private WebElement price;

    @FindBy(xpath = "//*[@id='mm-0']/div[7]/div[4]/div[2]/div[2]/div[1]/p[2]")
    private WebElement description;

    @FindBy(xpath = "//*[@id='mm-0']/div[7]/div[6]/div/div[3]/div[2]/div[2]")
    private WebElement characteristics;

    public AppliancesPage(WebDriver webDriver) {
        super(webDriver);
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
