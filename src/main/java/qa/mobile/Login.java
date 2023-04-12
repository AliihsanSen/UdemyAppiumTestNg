package qa.mobile;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Login {

    AppiumDriver driver;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //  caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability("avdLaunchTimeout", 180000);
        caps.setCapability("appPackage", "com.swaglabsmobileapp");
        caps.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");

        /*
        caps.setCapability(MobileCapabilityType.APP,
                "/Users/tribe/Desktop/Projects/AppiumProjects/MyFirstAppiumProjectTestNG/src/main/resources/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

        //  ==> Yüklenmemiş uygulamayı mobil cihaza yüklemek için kullanılır.
        */

        URL url = new URL("http://0.0.0.0:4723/");

        driver = new AndroidDriver(url, caps);
        System.out.println("Session Id : " + driver.getSessionId());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void invalidUserName()   {

        WebElement usernameTxtFld = driver.findElement(AppiumBy.accessibilityId("test-Username"));
        WebElement passwordTxtFld = driver.findElement(AppiumBy.accessibilityId("test-Password"));
        WebElement loginBtn = driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));

        usernameTxtFld.sendKeys("invalidusername");
        passwordTxtFld.sendKeys("secret_sauce");
        loginBtn.click();

        WebElement errTxt = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test" +
                "-Error message\"]/android.widget.TextView"));

        String actualErrTxt = errTxt.getAttribute("text");
        System.out.println("actual Error Text = " + actualErrTxt);
        String expectedErrTxt = "Username and password do not match any user in this service.";
        Assert.assertEquals(actualErrTxt, expectedErrTxt);

    }

    @Test
    public void invalidPassword(){

        WebElement usernameTxtFld = driver.findElement(AppiumBy.accessibilityId("test-Username"));
        WebElement passwordTxtFld = driver.findElement(AppiumBy.accessibilityId("test-Password"));
        WebElement loginBtn = driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));

        usernameTxtFld.sendKeys("standard_user");
        passwordTxtFld.sendKeys("invalidPassword");
        loginBtn.click();

        WebElement errTxt = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test" +
                "-Error message\"]/android.widget.TextView"));

        String actualErrTxt = errTxt.getAttribute("text");
        System.out.println("actual Error Text = " + actualErrTxt);
        String expectedErrTxt = "Username and password do not match any user in this service.";
        Assert.assertEquals(actualErrTxt, expectedErrTxt);

    }

    @Test
    public void successfulLogin(){

        WebElement usernameTxtFld = driver.findElement(AppiumBy.accessibilityId("test-Username"));
        WebElement passwordTxtFld = driver.findElement(AppiumBy.accessibilityId("test-Password"));
        WebElement loginBtn = driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));

        usernameTxtFld.sendKeys("standard_user");
        passwordTxtFld.sendKeys("secret_sauce");
        loginBtn.click();

        WebElement productTitle = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-" +
                "desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView"));

        String actualProductTitle = productTitle.getAttribute("text");
        System.out.println("actualProductTitle = " + actualProductTitle);
        String expectedProductTitle = "PRODUCTS";
        Assert.assertEquals(actualProductTitle, expectedProductTitle);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
