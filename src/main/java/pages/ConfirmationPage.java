package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationPage {


    public void isconfirm(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[role='alert'")));
        String successorfail = driver.findElement(By.cssSelector("div[role='alert'")).getText();

        Assert.assertEquals ("The form was successfully submitted!",successorfail.trim());
    }
}
