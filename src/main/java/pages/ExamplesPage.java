package pages;

import Drivers.Drivers;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ExamplesPage {

    @Test
    public static WebDriver autoFillform(WebDriver driver) throws InterruptedException {

        Drivers mainDriver = new Drivers();
        driver = mainDriver.initWebdriver();

        driver.get("https://formy-project.herokuapp.com/autocomplete");
        WebElement address = driver.findElement(By.id("autocomplete"));
        address.clear();
        address.click();
        address.sendKeys("110615,Sobha Dream Acres");
        WebDriverWait wait1 = new WebDriverWait(driver,30);
        wait1.until(ExpectedConditions.elementToBeClickable(By.className("pac-item")));
        wait1.ignoring(NoSuchElementException.class);
        wait1.pollingEvery(1000, TimeUnit.SECONDS);
        WebElement autofilllist = driver.findElement(By.className("pac-item"));
        autofilllist.click();

        mainDriver.deleteWebdriver(driver);

        return driver;
    }

    @Test
    public static WebDriver scrollingElements(WebDriver driver) throws InterruptedException {

        Drivers mainDriver = new Drivers();
        driver = mainDriver.initWebdriver();

        driver.get("https://formy-project.herokuapp.com/scroll");
        driver.manage().window().fullscreen();
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("name")));
        WebElement name = driver.findElement(By.id("name"));
        name.clear();
        name.sendKeys("Abhilash");
        WebElement date = driver.findElement(By.id("date"));
        date.sendKeys("01/01/2020");
        Thread.sleep(5000);
        mainDriver.deleteWebdriver(driver);
        return driver;
    }

    @Test
    public static WebDriver switchWindow(WebDriver driver) throws InterruptedException {

        Drivers mainDriver = new Drivers();
        driver = mainDriver.initWebdriver();

        driver.get("https://formy-project.herokuapp.com/switch-window");
        driver.manage().window().fullscreen();

        WebElement switchBtn = driver.findElement(By.id("new-tab-button"));
        String maintab = driver.getWindowHandle();
        switchBtn.click();
        Thread.sleep(1000);
        for (String window:driver.getWindowHandles()) {
            driver.switchTo().window(window);
            Thread.sleep(1000);
        }

        driver.switchTo().window(maintab);
        Thread.sleep(2000);
        mainDriver.deleteWebdriver(driver);
        return driver;
    }

    @Test
    public static WebDriver switchWindowAlert(WebDriver driver) throws InterruptedException {

        Drivers mainDriver = new Drivers();
        driver = mainDriver.initWebdriver();

        driver.get("https://formy-project.herokuapp.com/switch-window");
        driver.manage().window().fullscreen();

        WebElement alertBtn = driver.findElement(By.id("alert-button"));
        alertBtn.click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);
        mainDriver.deleteWebdriver(driver);
        return driver;
    }

    @Test
    public static WebDriver javaScript(WebDriver driver) throws InterruptedException {

        Drivers mainDriver = new Drivers();
        driver = mainDriver.initWebdriver();

        driver.get("https://formy-project.herokuapp.com/modal");
        driver.manage().window().fullscreen();
        WebElement modelBtn = driver.findElement(By.id("modal-button"));
        modelBtn.click();
        Thread.sleep(1000);
        WebElement closebtn = driver.findElement(By.id("close-button"));
        WebElement okbtn = driver.findElement(By.id("ok-button"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].Click",closebtn);
        Thread.sleep(2000);
        mainDriver.deleteWebdriver(driver);
        return driver;
    }


    @Test
    public static WebDriver dragAndDrop(WebDriver driver) throws InterruptedException {

        Drivers mainDriver = new Drivers();
        driver = mainDriver.initWebdriver();

        driver.get("https://formy-project.herokuapp.com/dragdrop");
        driver.manage().window().fullscreen();
        WebElement img = driver.findElement(By.id("image"));
        WebElement box = driver.findElement(By.id("box"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(img,box).build().perform();
        Thread.sleep(2000);
        mainDriver.deleteWebdriver(driver);
        return driver;
    }

    @Test
    public static WebDriver radiobtn(WebDriver driver) throws InterruptedException {

        Drivers mainDriver = new Drivers();
        driver = mainDriver.initWebdriver();

        driver.get("https://formy-project.herokuapp.com/radiobutton");
        driver.manage().window().fullscreen();
        WebElement radio1 = driver.findElement(By.id("radio-button-1"));
        WebElement radio2  = driver.findElement(By.cssSelector("input[value=option2"));
        WebElement radio3  = driver.findElement(By.cssSelector("input[value=option3"));
        radio1.click();
        Thread.sleep(1000);
        radio2.click();
        Thread.sleep(1000);
        radio3.click();
        Thread.sleep(1000);
        radio1.click();
        Thread.sleep(1000);
        mainDriver.deleteWebdriver(driver);
        return driver;
    }

    @Test
    public static WebDriver datapicker(WebDriver driver) throws InterruptedException {
        Drivers mainDriver = new Drivers();
        driver = mainDriver.initWebdriver();

        driver.get("https://formy-project.herokuapp.com/datepicker");
        driver.manage().window().fullscreen();
        WebElement datapicker = driver.findElement(By.id("datepicker"));
        datapicker.sendKeys("01/01/2020");
        datapicker.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        mainDriver.deleteWebdriver(driver);
        return driver;
    }

    @Test
    public static WebDriver dropdownMenu(WebDriver driver) throws InterruptedException {
        Drivers mainDriver = new Drivers();
        driver = mainDriver.initWebdriver();

        driver.get("https://formy-project.herokuapp.com/dropdown");
        driver.manage().window().fullscreen();
        Thread.sleep(2000);
        WebElement dropdown = driver.findElement(By.id("dropdownMenuButton"));
        Thread.sleep(2000);
        WebElement autocomplete = driver.findElement(By.id("autocomplete"));
        dropdown.click();
        Thread.sleep(2000);
        autocomplete.click();
        Thread.sleep(1000);
        mainDriver.deleteWebdriver(driver);
        return driver;
    }

    @Test
    public static WebDriver fileupload(WebDriver driver) throws InterruptedException {
        Drivers mainDriver = new Drivers();
        driver = mainDriver.initWebdriver();

        driver.get("https://formy-project.herokuapp.com/fileupload");
        driver.manage().window().fullscreen();
        Thread.sleep(2000);
        WebElement fileUpload = driver.findElement(By.id("file-upload-field"));
        WebElement fileUploadCancel = driver.findElement(By.id("btn btn-warning btn-reset"));
        WebElement fileUploadContinue = driver.findElement(By.id("btn btn-secondary btn-choose"));
        Thread.sleep(2000);
        mainDriver.deleteWebdriver(driver);
        return driver;
    }

    @Test
    public static WebDriver forms(WebDriver driver) throws InterruptedException {
        Drivers mainDriver = new Drivers();
        driver = mainDriver.initWebdriver();

        driver.get("https://formy-project.herokuapp.com/fileupload");
        driver.manage().window().fullscreen();
        Thread.sleep(2000);
        WebElement fileUpload = driver.findElement(By.id("file-upload-field"));
        WebElement fileUploadCancel = driver.findElement(By.id("btn btn-warning btn-reset"));
        WebElement fileUploadContinue = driver.findElement(By.id("btn btn-secondary btn-choose"));
        Thread.sleep(2000);
        mainDriver.deleteWebdriver(driver);
        return driver;
    }
}
