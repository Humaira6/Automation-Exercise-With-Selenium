package Pages;

import org.openqa.selenium.By;

public class HomePage extends BasicPage{

    public String URL="https://automationexercise.com/";

    //public By LoginBtn=By.cssSelector("a[href=\"login.php\"]");
    public By LoginBtn= By.xpath("//a[normalize-space()='Signup / Login']");
    public By LogoutBtn= By.xpath("//a[normalize-space()='Logout']");







}
