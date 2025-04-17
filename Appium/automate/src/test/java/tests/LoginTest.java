package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.LoginPage;

public class LoginTest extends Base {
    private LoginPage loginpage;


    @BeforeMethod
    public void setup1()
    {
         loginpage = new LoginPage(driver);
    }

    @Test
    public void testLogin() throws InterruptedException {
        
        loginpage.login("sahabaj@yopmail.com");
        System.out.println("Login Test Executed!");
        
    }
}
