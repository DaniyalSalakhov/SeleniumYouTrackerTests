package ru.home.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import ru.home.driver.DriverManager;
import ru.home.pages.DashBoardPage;
import ru.home.pages.LoginPage;
import ru.home.tests.base.BaseTest;


class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private DashBoardPage dashBoardPage;

    @BeforeEach
    public void setup() {
        WebDriver driver = DriverManager.getDriver();
        driver.get("http://localhost:8080");
        loginPage = new LoginPage(driver);
        dashBoardPage = new DashBoardPage(driver);
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
}
