package pages;

import Drivers.Drivers;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage {

    @Test
    public static WebDriver form(WebDriver driver){
        Drivers mainDriver = new Drivers();
        driver = mainDriver.initWebdriver();

        driver.get("https://formy-project.herokuapp.com/form");
        driver.manage().window().fullscreen();
        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("first-name")));

        driver.findElement(By.id("first-name")).sendKeys("Abhi");
        driver.findElement(By.id("last-name")).sendKeys("Gowda");
        driver.findElement(By.id("job-title")).sendKeys("QA");
        driver.findElement(By.id("radio-button-2")).click();
        driver.findElement(By.id("checkbox-1")).click();
        driver.findElement(By.id("select-menu")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("option[value='4']")));
        driver.findElement(By.cssSelector("option[value='4']")).click();


        WebElement datepicker = driver.findElement(By.id("datepicker"));
        datepicker.sendKeys("01/01/2020");
        datepicker.click();

        driver.findElement(By.cssSelector("a[class='btn btn-lg btn-primary'")).click();


        ConfirmationPage confirmationPage = new ConfirmationPage();
        confirmationPage.isconfirm(driver);

        mainDriver.deleteWebdriver(driver);
        return driver;


    }



}
