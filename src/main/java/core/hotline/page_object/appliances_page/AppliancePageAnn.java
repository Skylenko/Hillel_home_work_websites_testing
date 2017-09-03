package core.hotline.page_object.appliances_page;




import core.common.AbstractPage;
import core.common.annotations.DefaultPath;
import org.openqa.selenium.WebDriver;

@DefaultPath(defaultPath = "/bt/")

public class AppliancePageAnn extends AbstractPage {

    public AppliancePageAnn(WebDriver webDriver) {
        super(webDriver);
    }
}
