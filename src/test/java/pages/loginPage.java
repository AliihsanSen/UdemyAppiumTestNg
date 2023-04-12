package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class loginPage {

    @AndroidFindBy (accessibility = "test-Username")
    private WebElement usernameTxtFld ;
    @AndroidFindBy (accessibility = "test-Password")
    private WebElement passwordTxtFld ;
    @AndroidFindBy (accessibility = "test-LOGIN")
    private WebElement loginBtn ;
    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
    private WebElement errTxt ;

    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup" +
            "/android.widget.TextView")
    private WebElement productTitle ;



}
