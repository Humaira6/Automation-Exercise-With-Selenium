package TestCases;

import Pages.*;
import Utilities.DataSet;
import Utilities.webdriverSetup;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSignUp extends webdriverSetup {

    HomePage homePage = new HomePage();
    LogInPage logInPage = new LogInPage();
    MyCart myCart = new MyCart();
    BasicPage basicPage = new BasicPage();
    SignUpPage signUpPage=new SignUpPage();

    @Test(dataProvider = "InvalidCredentialsforSignUp",dataProviderClass = DataSet.class)
    public void TestsignupwithInValidCredentials(String username, String email, String errorMessage) throws InterruptedException {
        getBrowser().get(homePage.URL);
        Thread.sleep(3000);
        homePage.clickOnElement(homePage.LoginBtn);

        signUpPage.writeOnElement(signUpPage.NameInputBox, username);
        signUpPage.writeOnElement(signUpPage.EmailInputBox, email);
        Thread.sleep(3000);
        signUpPage.clickOnElement(signUpPage.SignUpBtn);
        getBrowser().navigate().to("https://automationexercise.com/signup");
        Thread.sleep(3000);


    }

}
