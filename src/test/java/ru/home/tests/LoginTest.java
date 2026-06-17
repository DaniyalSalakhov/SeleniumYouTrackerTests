package ru.home.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import ru.home.pages.DashBoardPage;
import ru.home.pages.LoginPage;

import java.time.Duration;

class LoginTest {
    private LoginPage loginPage;
    private DashBoardPage dashBoardPage;
    private WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new SafariDriver();
        driver.get("http://localhost:8080");
        loginPage = new LoginPage(driver);
        dashBoardPage = new DashBoardPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    void successfulLoginTest(){
        loginPage.login("admin", "qwerty007");
        Assertions.assertTrue(dashBoardPage.isOpened());
        loginPage.logout();
    }

    @Test
    void unsuccessfulLoginTest(){
        loginPage.login("notAdmin", "badpassword");
        Assertions.assertTrue(loginPage.isOpened());
    }

    @AfterEach
    public void shutDown(){
        driver.quit();
    }
}
