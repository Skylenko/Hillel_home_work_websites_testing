package core.hotline.page_object.applianc_page;

import core.hotline.page_object.appliances_page.AppliancePageAnn;
import core.hotline.page_object.common.CommonTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class AppliancePageTest extends CommonTest {

    public AppliancePageTest() throws IOException {
    }

    @Before()
    public void webDriverSetUp() {
        driverSetUp();

    }

    @Test
    public void doTest() throws IOException {
        AppliancePageAnn appliancePageAnn = new AppliancePageAnn(getDriver());
        String pagePage = openPage(appliancePageAnn);
        getDriver().get(pagePage);
        Assert.assertTrue("There is incorrect default page title!",
                getDriver().getCurrentUrl().contains("bt"));

    }

    @After
    public void webDriverTearDown() {
        tearDown();
    }
}

