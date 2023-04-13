package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import mobile.baseTest;
import org.openqa.selenium.WebElement;


public class productsPage extends baseTest {

    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup" +
            "/android.widget.TextView")
    private WebElement productTitle ;

    public String getTitle() {
    return getAttribute(productTitle,"text");
    }

}
