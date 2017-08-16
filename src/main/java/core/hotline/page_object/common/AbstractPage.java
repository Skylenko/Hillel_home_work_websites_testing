package core.hotline.page_object.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by User on 14.08.2017.
 */
public class AbstractPage {

    protected WebDriver driver;

    public AbstractPage(WebDriver webDriver){
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);

    }

}
