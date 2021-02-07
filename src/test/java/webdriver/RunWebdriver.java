package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class RunWebdriver {

    private static WebDriver driver;

    public static WebDriver getInstance() throws MalformedURLException {


        if(driver == null) {

            ChromeOptions options = new ChromeOptions();

            options.addArguments("--start-maximized");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--incognito");

            System.setProperty("webdriver.chrome.driver", "C:/Users/{user}/Downloads/chromedriver.exe"); //добавить своего пользователя

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        return driver;
    }

    public static void CloseDriver(){

        if(driver !=null){
            driver.quit();
        }
    }

    public static WebDriver getDriver(){return driver;}

}
