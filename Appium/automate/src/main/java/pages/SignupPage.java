package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import resources.Data;

public class SignupPage {
  
    private AndroidDriver driver;
    WebElement element;

    public SignupPage(AndroidDriver driver)
    {
        this.driver =driver;
    }
    
    By homesignbutton = By.xpath("//android.widget.Button[@content-desc=\"Sign up\"]");
    By SignUsername = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]");
    By SignEmail = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]");
    By SignPassword = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[3]");
    By SignUpButton = By.xpath("//android.widget.Button[@content-desc=\"Sign up\"]");


    public void signup(String username, String email, String password) throws InterruptedException {
        driver.findElement(homesignbutton).click();
        driver.findElement(SignUsername).click();
        driver.findElement(SignUsername).sendKeys(username);
        driver.findElement(SignEmail).click();
        driver.findElement(SignEmail).sendKeys(email + "@maildrop.cc");
        driver.findElement(SignPassword).click();
        driver.findElement(SignPassword).sendKeys(password);
        driver.findElement(SignUpButton).click();


    }

    public void otp(){
        String otpText = "Your OTP to verify email is: 395987"; // The text from the element

        driver.get("http://www.yopmail.com/en/");               //Open Yopmail
        driver.findElement(By.xpath("//input[@id='login']")).sendKeys(Data.RndString);
        driver.findElement(By.xpath("//div[@id='refreshbut']")).click();

        // Regex to capture exactly 6 digits
        Pattern pattern = Pattern.compile("(\\d{6})"); // Matches exactly 6 digits
        Matcher matcher = pattern.matcher(otpText);

        String otp = null;
        if (matcher.find()) 
        {
        otp = matcher.group(1);
        System.out.println("OTP: " + otp); // Output: OTP: 395987
        } 

        
    }


}
