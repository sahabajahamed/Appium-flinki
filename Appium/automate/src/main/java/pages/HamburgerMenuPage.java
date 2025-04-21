package pages;

import org.openqa.selenium.WebElement;

import base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HamburgerMenuPage extends BasePage{
    

    public HamburgerMenuPage(AndroidDriver driver)
    {
        super(driver);
    }

   
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.ImageView[2]")
    private WebElement hamburgerMenu;

    @AndroidFindBy(accessibility = "My Connections")
    private WebElement myConnections;

    @AndroidFindBy(accessibility = "My Groups & Clubs")
    private WebElement myGroupsClubs;

    @AndroidFindBy(accessibility = "My Race/Event Calendar")
    private WebElement myRaceEvent;

    @AndroidFindBy(accessibility = "My Listings")
    private WebElement myListing;

    @AndroidFindBy(accessibility = "Sign Out")
    private WebElement signOut;

    @AndroidFindBy(accessibility = "John Doe")
    private WebElement tapprofileName;
    
    











    public void tapHamburgerMenu()
    {
        click(hamburgerMenu);

    }

    public MyConnectionsPage tapMyConnections()
    {
        click(myConnections);
        
        return new MyConnectionsPage(driver);
    }
    
}
