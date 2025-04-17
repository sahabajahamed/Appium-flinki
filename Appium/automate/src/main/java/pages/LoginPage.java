package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends BasePage{

    private AndroidDriver driver;
    
    
    public LoginPage(AndroidDriver driver) {
      super(driver); // Initializes driver & wait
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
      
    }

    @AndroidFindBy(accessibility = "Skip")
    private WebElement skipButton;
    @AndroidFindBy(accessibility="Log In")
    private WebElement loginButton;
    @AndroidFindBy(accessibility = "Sign Up")
    private WebElement signUpButton;
    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement enterEmail;
    @AndroidFindBy(accessibility= "Sign in")
    private WebElement signInButton;
    @AndroidFindBys({
    @AndroidBy(className = "android.widget.EditText")})
    public List<WebElement> otpFields;
    

    public void enterOtp()
    {
        String otp = String.format("%06d", new Random().nextInt(999999));
        System.out.println("Generated OTP: " + otp);
        otpFields.get(0).click();
        otpFields.get(0).sendKeys(otp);

        for (int i = 0; i < 6; i++) {
            WebElement field = otpFields.get(i);
            field.click(); // tap the field
            field.sendKeys(String.valueOf(otp.charAt(i))); // send one digit
        }
    }

    public void login(String text) throws InterruptedException {
        
        click(skipButton);
        click(loginButton);
        click(enterEmail);
        enterText(enterEmail, text);
        signInButton.click();
        enterOtp();
        Thread.sleep(2000);
       


       
        
    }
}
