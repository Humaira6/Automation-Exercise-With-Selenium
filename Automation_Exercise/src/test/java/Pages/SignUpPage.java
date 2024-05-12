package Pages;

import org.openqa.selenium.By;

public class SignUpPage extends BasicPage{
public String Name="ABC";
public String Email="abc@gmail.com";

public By NameInputBox=By.xpath("//input[@placeholder='Name']");
public By EmailInputBox=By.xpath("//input[@data-qa='signup-email']");

public By SignUpBtn=By.xpath("//button[normalize-space()='Signup']");


}
