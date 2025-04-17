package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.google.common.collect.ImmutableMap;

public class UnlockAndroidDevice {

    private AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid("192.168.7.3:5555");
                // .setAppPackage("com.android.settings") //Example app to launch after unlocking
                // .setAppActivity(".Settings");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
    }

    @Test
    public void unlockDevice() {
        try {
            executeAdbCommand(driver, Arrays.asList("input", "keyevent", "KEYCODE_WAKEUP"));
            Thread.sleep(20000);
    
            String pin = "742695";
            for (char digit : pin.toCharArray()) {
                int keyCode = getKeyCodeForDigit(digit);
                if (keyCode != -1) {
                    executeAdbCommand(driver, Arrays.asList("input", "keyevent", String.valueOf(keyCode)));
                    Thread.sleep(2500); // Delay after each key press
                } else {
                    System.err.println("Invalid PIN digit: " + digit);
                }
            }
            executeAdbCommand(driver, Arrays.asList("input", "keyevent", "66")); // KEYCODE_ENTER
            Thread.sleep(2500);
    
            System.out.println("Device unlocked.");
        } catch (Exception e) {
            System.err.println("Error unlocking device: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private int getKeyCodeForDigit(char digit) {
        switch (digit) {
            case '0': return 7;
            case '1': return 8;
            case '2': return 9;
            case '3': return 10;
            case '4': return 11;
            case '5': return 12;
            case '6': return 13;
            case '7': return 14;
            case '8': return 15;
            case '9': return 16;
            default: return -1; // Invalid digit
        }
    }

    private void executeAdbCommand(AndroidDriver driver, List<String> args) {
        Map<String, Object> command = ImmutableMap.of(
                "command", args.get(0),
                "args", args.subList(1, args.size())
        );
        driver.executeScript("mobile: shell", command);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
  

//     @AfterMethod
//     public void tearDown() {
//         if (driver != null) {
//             driver.quit();
//         }
//     }
