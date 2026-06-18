package ru.home.utils;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {
    public static void takeScreenshots(WebDriver driver, String testName){
        try{
            Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
            File directory = new File("src/test/resources/screenshots");
            directory.mkdirs();
            File file = new File("src/test/resources/screenshots/"+testName
                    +"_"+System.currentTimeMillis()+".png");
            ImageIO.write(screenshot.getImage(),"PNG", file);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
