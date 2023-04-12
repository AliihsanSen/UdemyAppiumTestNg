package qa.mobile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class test1 {

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

        AppiumDriver driver = new AndroidDriver(url, caps);
        System.out.println("Session Id : " + driver.getSessionId());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void f()   {

    }

    @AfterClass
    public void afterClass(){

        driver.quit();
    }
}
