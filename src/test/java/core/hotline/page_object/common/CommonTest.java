package core.hotline.page_object.common;


import core.hotline.page_object.appliances_page.AppliancePageAnn;
import core.hotline.page_object.common.utils.PropertyUtils;
import core.hotline.page_object.common.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CommonTest {
    protected WebDriver driver;
    private PropertyUtils propertyUtils = null;

    public  CommonTest() throws IOException {
        this.propertyUtils = new PropertyUtils();
        driver = new ChromeDriver();
        driverSetUp();
    }

    protected void driverSetUp() {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    protected WebDriver getDriver(){
        return  driver;
    }
    protected void tearDown() {
        driver.close();

    }

    protected <T extends AbstractPage>String openPage(AppliancePageAnn page) throws IOException {
        return WebDriverUtils.getDefaultPathByPage(page);

    }


}
