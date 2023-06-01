package commons;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class MyDriver {
   public static  WebDriver myDriver;
   public  static Map<String,String> globalVariables=new HashMap<>();

    public static WebDriver getMyDriver() {
        return myDriver;
    }

    public static void setMyDriver(WebDriver driver) {
       myDriver = driver;
    }
}
