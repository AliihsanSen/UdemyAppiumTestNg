package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import qa.mobile.BaseTest;

public class productsPage extends BaseTest {

    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup" +
            "/android.widget.TextView")
    private WebElement productTitle ;

    public String getTitle() {
    return getAttribute(productTitle,"text");
    }

}
