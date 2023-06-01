package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {


    @BeforeMethod
    @Parameters({"browserName"})
    public void beforeMethod(String browserName) {
        System.out.println("Starting the browser session");
        System.out.println("Browser Name:"+browserName);

        if(browserName.equalsIgnoreCase("chrome"))
        {   WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            chromeOptions.addArguments("--remote-allow-origins=*");
            MyDriver.setMyDriver(new ChromeDriver(chromeOptions));
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
          //  firefoxOptions.addArguments("start-maximized");
           // firefoxOptions.addArguments()
          //  firefoxOptions.addArguments("--remote-allow-origins=*");
            MyDriver.setMyDriver(new FirefoxDriver(firefoxOptions));
            MyDriver.getMyDriver().manage().window().maximize();

        }else {
            Assert.fail("BrowserName is not valid");
        }
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Closing the browser session");
        MyDriver.getMyDriver().quit();

    }
}
