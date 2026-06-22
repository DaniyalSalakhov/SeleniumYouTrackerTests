package ru.home.tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.home.driver.DriverManager;
import ru.home.pages.DashBoardPage;
import ru.home.pages.LoginPage;
import ru.home.tests.base.BaseTest;


class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private DashBoardPage dashBoardPage;

    @BeforeEach
    public void setup() {
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
    }

    @ParameterizedTest
    @CsvSource({"incorrectLogin, incorrectPassword"})
    public void unsuccessfulLoginTest(String username, String password){
        loginPage.login(username, password);
        Assertions.assertTrue(loginPage.isOpened());
    }

    @ParameterizedTest
    @CsvSource({"admin, qwerty007"})
    public void successfulLoginTest(String username, String password){
        dashBoardPage = loginPage.login(username, password);
        Assertions.assertTrue(dashBoardPage.isOpened());
    }
}
