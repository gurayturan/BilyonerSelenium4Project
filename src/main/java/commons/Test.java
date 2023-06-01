package commons;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Test {

    public static void main(String[]args) throws IOException, AWTException {
        String text="Welcome ${username}";
        if(text.contains("$"))
        {
            String [] arr =text.split("\\$");
            int i1=text.indexOf('$');
            int i2=text.indexOf("}");

            System.out.println(text.substring(text.indexOf('$'),text.indexOf("}")+1));

            //BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            //.write(image, "png", new File("path\\to\\screenshot.png"));
        }
    }
}
