package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import qa.mobile.BaseTest;

public class productsPage extends BaseTest {

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



    public productsPage enterUserName(String userName) {
        sendKeys(usernameTxtFld,userName);
        return this;
    }

    public productsPage enterPassword(String password) {
        sendKeys(passwordTxtFld,password);
        return this;
    }

    public  productsPage pressLoginBtn() {
        click(loginBtn);
        return new productsPage();
    }

}
