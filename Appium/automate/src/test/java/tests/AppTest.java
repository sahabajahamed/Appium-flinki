package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.net.MalformedURLException;
import java.net.URL;

public class AppTest {
    public static AndroidDriver driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        // Set Appium Options
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("RealMe 9i"); // Any name
        options.setUdid("192.168.7.3:5555"); // Wireless ADB IP
        options.setAppPackage("com.bashdit.app");
        options.setAppActivity("com.bashdit.app.MainActivity");
        options.setAutomationName("UiAutomator2");   
       // options.setNoReset(true);  // Prevents closing the app after execution

        // Start Appium session
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        System.out.println("App Launched!");

        // Wait for elements to load
        Thread.sleep(5000);

        // Locate & Click a Button (Example)
        driver.findElement(By.xpath("//android.widget.EditText[@text='Email']")).sendKeys("Arif.raza@weavers-web.com");
        driver.findElement(By.xpath("//android.widget.EditText[@text='Password']")).sendKeys("Test@123");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Login']")).click();
        System.out.println("Executed!");

        // Close App
        driver.quit();
    }
}
