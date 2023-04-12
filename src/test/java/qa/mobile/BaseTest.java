package qa.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.TestUtils;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected AppiumDriver driver;
    protected Properties properties;
    InputStream inputStream;

    @Parameters({"platformName", "deviceName"})

    @BeforeClass
    public void beforeClass(String platformName, String deviceName) {

        try {
            properties = new Properties();
            String propertiesFileName = "config.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);
            properties.load(inputStream);

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, properties.getProperty("androidAutomationName"));
            // caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
            caps.setCapability("avdLaunchTimeout", 180000);
            caps.setCapability("appPackage", properties.getProperty("androidAppPackage"));
            caps.setCapability("appActivity", properties.getProperty("androidAppActivity"));
            String appUrl = getClass().getResource(properties.getProperty("andoridAppLocation")).getFile();
            caps.setCapability(MobileCapabilityType.APP,appUrl);

            //  ==> Yüklenmemiş uygulamayı mobil cihaza yüklemek için kullanılır.

            URL url = new URL(properties.getProperty("appiumUrl"));

            driver = new AndroidDriver(url, caps);
            System.out.println("Session Id = " + driver.getSessionId());
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForVisibility(WebElement e){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(e));
    }

    public void click (WebElement e){
        waitForVisibility(e);
        e.click();
    }

    public void sendKeys(WebElement e, String txt){
        waitForVisibility(e);
        e.sendKeys(txt);
    }

    @AfterClass
    public void afterClass()  {

        driver.quit();
    }

}
