package core.hotline.page_object.appliances_page;




import core.hotline.page_object.common.AbstractPage;
import core.hotline.page_object.common.annotations.DefaultPath;
import org.openqa.selenium.WebDriver;

@DefaultPath(defaultPath = "/bt/")

public class AppliancePageAnn extends AbstractPage {

    public AppliancePageAnn(WebDriver webDriver) {
        super(webDriver);
    }
}
