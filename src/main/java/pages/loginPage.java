package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import mobile.baseTest;
import org.openqa.selenium.WebElement;


public class loginPage extends baseTest {

    @AndroidFindBy (accessibility = "test-Username")
    private WebElement usernameTxtFld ;
    @AndroidFindBy (accessibility = "test-Password")
    private WebElement passwordTxtFld ;
    @AndroidFindBy (accessibility = "test-LOGIN")
    private WebElement loginBtn ;
    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
    private WebElement errTxt ;

    public  loginPage enterUserName(String userName) {
        sendKeys(usernameTxtFld,userName);
        return this;
    }

    public  loginPage enterPassword(String password) {
        sendKeys(passwordTxtFld,password);
        return this;
    }

    public productsPage pressLoginBtn() {
        click(loginBtn);
        return new productsPage();
    }

    public String getErrText(){
        return getAttribute(errTxt,"text");
    }

}
