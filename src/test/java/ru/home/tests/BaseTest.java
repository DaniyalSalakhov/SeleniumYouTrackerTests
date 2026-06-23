package ru.home.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import ru.home.driver.DriverFactory;
import ru.home.driver.DriverManager;
import ru.home.utils.ConfigReader;

import java.time.Duration;

public abstract class BaseTest {

    protected String login = ConfigReader.get("login");
    protected String password = ConfigReader.get("password");
    protected String baseUrl = ConfigReader.get("base.url");
    protected WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = DriverFactory.createDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DriverManager.setDrivers(driver);
        driver.get(baseUrl);
    }

    @AfterEach
    public void shutDown(){
        DriverManager.quitDriver();
    }
}
