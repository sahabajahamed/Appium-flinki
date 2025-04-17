package tests;
import base.Base;
import org.testng.annotations.Test;
import java.util.Scanner;
import pages.SignupPage; 
import resources.Data;

public class SignUpTest extends Base {

    @Test
    public void signuptest() throws InterruptedException{
        SignupPage signuptest = new SignupPage(driver);
        //signuptest.signup("Chkj", "Chk@yopmail.com", "Test@123456");       ///Static value
        signuptest.signup(Data.RndString,Data.RndString,"Test@123456");  //// Random Value
        // signuptest.otp();

        
        System.out.println("Signup Test Executed! with data as- Username- " + Data.RndString + " Email- " + Data.RndString + "@maildrop.cc");
     }



//    @Test
//    public void signupCustom() throws InterruptedException
//    {
//     SignupPage signuptest = new SignupPage(driver);
//     System.out.println("Enter Username");
//     Scanner usr = new Scanner(System.in);
//     String CustomUsername = usr.nextLine();
//     System.out.println("Enter Email");
//     String CustomEmail = usr.nextLine();
//     String Password = "Test@123456";
//     signuptest.signup(CustomUsername, CustomEmail, Password);
//     System.out.println("Signup Test Executed! with data as- Username " + CustomUsername + " Email " + CustomEmail + "@yopmail.com");
//    }  
   

    
   
}
