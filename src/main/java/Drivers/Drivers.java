package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Drivers {


    public WebDriver initWebdriver(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\abhilasha\\Desktop\\Personal\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public void deleteWebdriver(WebDriver driver){
        driver.quit();
    }
}
