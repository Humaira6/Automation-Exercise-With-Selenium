package Pages;

import org.openqa.selenium.By;

public class LogInPage extends BasicPage {
    public String Email="xagopot780@deligy.com";
    public String Password="123456aa";

    public By EmailInputBox=By.xpath("//input[@data-qa=\"login-email\"]");
    public By PasswordInputBox=By.xpath("//input[@data-qa=\"login-password\"]");

    public By LoginButton=By.xpath("//button[@data-qa=\"login-button\"]");

    public By errorMessage=By.xpath("//p[normalize-space()='Your email or password is incorrect!']");


}
