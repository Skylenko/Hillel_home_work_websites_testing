package core.bmw.page_object.home_page;

import core.bmw.searchPageBmw.SearchPageBmw;
import core.common.CommonTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class HomePageBmwTesting extends CommonTest {

    public HomePageBmwTesting() throws IOException {
    }

    @Before()
    public void webDriverSetUp() {
        driverSetUp();
        driver.get(propertyUtils.getProperty("main.site.url.bmw"));

    }

    @After
    public void webDriverTearDown() {
        tearDown();
    }

    @Test
    public void bmwTitleTesting() {

        HomePageBMW homePageBMW = new HomePageBMW(driver);
        homePageBMW.searchPageBmw();

        String title1 = driver.getTitle();
        String title2 = driver.findElement(By.xpath("//*[@id='ds2-globalnav']/ul[2]/li[2]/a")).getText();
        Assert.assertEquals(title1, title2);

        String buttonTextColor = driver.findElement(By.xpath("//*[@id='ds2-globalnav']/ul[2]/li[2]/a"))
                .getCssValue("color");
        Assert.assertEquals("rgba(6, 83, 182, 1)", buttonTextColor);

    }

    @Test
    public void bmwSearchTitleTesting() {
        HomePageBMW homePageBMW = new HomePageBMW(driver);
        homePageBMW.searchPageBmw();

        SearchPageBmw searchPageBmw = new SearchPageBmw(driver);
        searchPageBmw.pageRez();

        String title1 = driver.findElement(By.xpath("//*[@id='ds2-models-js--series-wrap']/div/section[2]/article[3]/div/div[2]")).getText()
                .replaceAll("\n|\r\n", " ")
                .replace(" Узнайте", ": Узнать");

        driver.findElement(By.xpath("//*[@id='ds2-models-js--series-wrap']/div/section[2]/article[3]/div/div[2]/ul/li/a")).click();

        String title2 = driver.getTitle();
        Assert.assertEquals(title1, title2);
    }

    @Test
    public void bmwGetInfoTesting() throws IOException {
        HomePageBMW homePageBMW = new HomePageBMW(driver);
        homePageBMW.searchPageBmw();

        SearchPageBmw searchPageBmw = new SearchPageBmw(driver);
        searchPageBmw.pageRez();

        searchPageBmw.pageKabr();
        searchPageBmw.getInfo();

        FileReader fr = new FileReader("info.csv");
        Scanner scan = new Scanner(fr);
        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }
        fr.close();

        System.out.println(searchPageBmw.getInfo());

    }
}
