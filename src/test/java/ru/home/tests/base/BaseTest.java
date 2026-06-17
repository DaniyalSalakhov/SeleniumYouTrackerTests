package ru.home.tests.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import ru.home.driver.DriverFactory;
import ru.home.driver.DriverManager;

import java.time.Duration;

public abstract class BaseTest {
    @BeforeEach
    public void setUp(){
        WebDriver driver = DriverFactory.createDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DriverManager.setDrivers(driver);
    }

    @AfterEach
    public void shutDown(){
        DriverManager.quitDriver();
    }
}
