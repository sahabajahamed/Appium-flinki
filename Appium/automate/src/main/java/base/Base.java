package base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Base {
    public AndroidDriver driver;

    @SuppressWarnings("deprecation")
    @BeforeClass
    public void setup() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("RealMe 8"); 
        options.setUdid("EETOL7P7AMVOZ9NB");    //Change as per device
        options.setAppPackage("com.flinki.app");   //Change as per app
        options.setAppActivity("com.flinki.app.MainActivity");  //Change as per app
        options.setAutomationName("UiAutomator2");
        options.setCapability("newCommandTimeout", 60 * 5); // Keep th appium server alive for 5 minutes
        //  options.setNoReset(true);
        
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS) ;
        // Thread.sleep(10000);
    }

    // @AfterClass
    // public void tearDown() {
    //     if (driver != null) {
    //         driver.quit();
    //     }
    // }
}
