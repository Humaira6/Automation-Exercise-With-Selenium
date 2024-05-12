package TestCases;

import Pages.BasicPage;
import Pages.HomePage;
import Pages.LogInPage;
import Pages.MyCart;
import Utilities.DataSet;
import Utilities.webdriverSetup;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends webdriverSetup {

    HomePage homePage = new HomePage();
    LogInPage logInPage = new LogInPage();
    MyCart myCart = new MyCart();
    BasicPage basicPage = new BasicPage();


    @Test
    public void TestloginwithoutEmailAndPassword() throws InterruptedException {
        getBrowser().get(homePage.URL);
        // Thread.sleep(3000);
        homePage.clickOnElement(homePage.LoginBtn);
        logInPage.writeOnElement(logInPage.EmailInputBox, "");
        logInPage.writeOnElement(logInPage.PasswordInputBox, "");
        Thread.sleep(3000);
        logInPage.clickOnElement(logInPage.LoginButton);
        Assert.assertFalse(homePage.displayStatus(homePage.LogoutBtn));


    }

    @Test
    public void TestloginwithoutPassword() throws InterruptedException {
        getBrowser().get(homePage.URL);
        // Thread.sleep(3000);
        homePage.clickOnElement(homePage.LoginBtn);
        logInPage.writeOnElement(logInPage.EmailInputBox, logInPage.Email);
        logInPage.writeOnElement(logInPage.PasswordInputBox, "");
        Thread.sleep(3000);
        logInPage.clickOnElement(logInPage.LoginButton);
        Thread.sleep(3000);
        //getBrowser().findElement(By.xpath())
        String Message=logInPage.getElement(logInPage.PasswordInputBox).getAttribute("validationMessage");
        System.out.println(Message);
        Assert.assertFalse(homePage.displayStatus(homePage.LogoutBtn));



    }

    @Test
    public void TestloginwithoutEmail() throws InterruptedException {
        getBrowser().get(homePage.URL);
//        Thread.sleep(3000);
        homePage.clickOnElement(homePage.LoginBtn);
        logInPage.writeOnElement(logInPage.EmailInputBox, "");
        logInPage.writeOnElement(logInPage.PasswordInputBox, logInPage.Password);
        Thread.sleep(3000);
        logInPage.clickOnElement(logInPage.LoginButton);
        Assert.assertFalse(homePage.displayStatus(homePage.LogoutBtn));


    }

    @Test

    public void TestloginwithInValidPassword() throws InterruptedException {
        getBrowser().get(homePage.URL);
        // Thread.sleep(3000);
        homePage.clickOnElement(homePage.LoginBtn);
        logInPage.writeOnElement(logInPage.EmailInputBox, logInPage.Email);
        logInPage.writeOnElement(logInPage.PasswordInputBox, "123456");
        //Thread.sleep(3000);
        logInPage.clickOnElement(logInPage.LoginButton);
        Assert.assertFalse(homePage.displayStatus(homePage.LogoutBtn));


    }

    @Test
    public void TestloginwithInValidEmail() throws InterruptedException {
        getBrowser().get(homePage.URL);
        Thread.sleep(3000);
        homePage.clickOnElement(homePage.LoginBtn);
        logInPage.writeOnElement(logInPage.EmailInputBox, "abvfghe");
        logInPage.writeOnElement(logInPage.PasswordInputBox, logInPage.Password);
        Thread.sleep(3000);
        logInPage.clickOnElement(logInPage.LoginButton);
        Assert.assertFalse(homePage.displayStatus(homePage.LogoutBtn));


    }

    @Test
    public void TestloginwithInValidEmailAndPassword() throws InterruptedException {
        getBrowser().get(homePage.URL);
        Thread.sleep(3000);
        homePage.clickOnElement(homePage.LoginBtn);
        logInPage.writeOnElement(logInPage.EmailInputBox, "abvfghe@gh");
        logInPage.writeOnElement(logInPage.PasswordInputBox, "123456");
        Thread.sleep(3000);
        logInPage.clickOnElement(logInPage.LoginButton);
        //Assert.assertEquals(logInPage.getElement(logInPage.errorMessage).getText(), "Your email or password is incorrect!");
        Assert.assertFalse(homePage.displayStatus(homePage.LogoutBtn));


    }

    @Test
    public void TestloginwithValidCredentials() throws InterruptedException {
        getBrowser().get(homePage.URL);
        Thread.sleep(3000);
        homePage.clickOnElement(homePage.LoginBtn);
        logInPage.writeOnElement(logInPage.EmailInputBox, logInPage.Email);
        logInPage.writeOnElement(logInPage.PasswordInputBox, logInPage.Password);
        Thread.sleep(3000);
        logInPage.clickOnElement(logInPage.LoginButton);
        Assert.assertTrue(homePage.displayStatus(homePage.LogoutBtn));


    }
@Test(dataProvider = "InvalidCredentials",dataProviderClass = DataSet.class)
    public void TestloginwithInValidCredentials(String username, String password, String errorMessage) throws InterruptedException {
        getBrowser().get(homePage.URL);
        Thread.sleep(3000);
        homePage.clickOnElement(homePage.LoginBtn);
        logInPage.writeOnElement(logInPage.EmailInputBox, username);
        logInPage.writeOnElement(logInPage.PasswordInputBox, password);
        Thread.sleep(3000);
        logInPage.clickOnElement(logInPage.LoginButton);
       // Assert.assertEquals(logInPage.getElement(logInPage.errorMessage).getText(), "Your email or password is incorrect!");
        Assert.assertFalse(homePage.displayStatus(homePage.LogoutBtn));

    }
}
