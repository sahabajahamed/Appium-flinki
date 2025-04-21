package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HamburgerMenuPage;
import pages.LoginPage;

public class LoginTest extends Base {
    private LoginPage loginpage;
    private HamburgerMenuPage hamburgerMenu;


    @BeforeMethod
    public void setup1()
    {
        loginpage = new LoginPage(driver);
        hamburgerMenu = new HamburgerMenuPage(driver);
         
    }

    @Test
    public void testLogin() throws InterruptedException {

        loginpage.login("sahabaj@yopmail.com");
        System.out.println("Login Test Executed!");

    }
    @Test
    public void USerVerifyHamburgerMenu() throws InterruptedException

    {

        loginpage.login("sahabaj@yopmail.com");
        Thread.sleep(2000);
        hamburgerMenu.tapHamburgerMenu();
        hamburgerMenu.tapMyConnections();



    }
}
