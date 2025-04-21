package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EditProfilePage extends BasePage {

    public EditProfilePage(AndroidDriver driver)
    {
        super(driver);
    }
//Personal Information------------------------------Xpath----------------------------------------------
@AndroidFindBy(xpath="//android.widget.ScrollView/android.widget.ImageView[1]")
private WebElement firstName;
@AndroidFindBy(xpath ="//android.widget.ScrollView/android.widget.ImageView[2]")
private WebElement lastname;
@FindBy(xpath="//android.widget.ScrollView/android.view.View[2]")
private WebElement countryDrpdown;


    
}
