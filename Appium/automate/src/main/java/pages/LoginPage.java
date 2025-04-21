package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.clipboard.HasClipboard;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends BasePage{

    
    private AndroidDriver driver;

    public LoginPage(AndroidDriver driver) {
        super(driver); // Assigns driver in BasePage
        this.driver = driver; // Fixes your NULL problem
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Skip")
    private WebElement skipButton;

    @AndroidFindBy(accessibility = "Log In")
    private WebElement loginButton;

    @AndroidFindBy(accessibility = "Sign Up")
    private WebElement signUpButton;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement enterEmail;

    @AndroidFindBy(accessibility = "Sign in")
    private WebElement signInButton;

    @AndroidFindBys({
        @AndroidBy(className = "android.widget.EditText")
    })
    public List<WebElement> otpFields;

    @AndroidFindBy(accessibility = "Continue")
    private WebElement continueButtonl;

    public void login(String email) throws InterruptedException {
        click(skipButton);
        click(loginButton);
        enterText(enterEmail, email);
        click(signInButton);
        enterOtp();
        Thread.sleep(4000); // Now calls correct instance method
        click(continueButtonl);
    }

    public void enterOtp() {
        //  Ensure driver is initialized
        if (driver == null) {
            throw new IllegalArgumentException("Driver is null in enterOtp()");
        }

        //  Generate a 6-digit OTP
        String otp = String.format("%06d", new Random().nextInt(999999));
        System.out.println("Generated OTP: " + otp);

        //  Set OTP to clipboard
        ((HasClipboard) driver).setClipboardText(otp);

        //  Paste clipboard OTP into the first field
        WebElement firstField = otpFields.get(0);
        firstField.click();

        // Many Android keyboards paste automatically — but this ensures it
        firstField.sendKeys(((HasClipboard) driver).getClipboardText());

        // //  Wait for and click Continue
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // wait.until(ExpectedConditions.elementToBeClickable(continueButtonl));
        // click(continueButtonl);
    }
}
