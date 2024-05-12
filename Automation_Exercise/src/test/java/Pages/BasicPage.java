package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static Utilities.webdriverSetup.getBrowser;

public class BasicPage {


    public WebElement getElement(By locator) {
        return getBrowser().findElement(locator);

    }

    public void writeOnElement(By locator, String text) {
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }

    public void clickOnElement(By locator) {
        getElement(locator).click();

    }

    public void ShowAlert() {
        Alert alert =getBrowser().switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }


    public Boolean displayStatus(By locator) {
        try {
            return getElement(locator).isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }

    }


}