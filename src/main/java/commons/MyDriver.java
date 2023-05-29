package commons;

import org.openqa.selenium.WebDriver;

public class MyDriver {
   public static  WebDriver myDriver;

    public static WebDriver getMyDriver() {
        return myDriver;
    }

    public static void setMyDriver(WebDriver driver) {
       myDriver = driver;
    }
}
