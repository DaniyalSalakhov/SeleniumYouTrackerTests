package ru.home.tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.home.driver.DriverManager;
import ru.home.pages.DashBoardPage;
import ru.home.pages.LoginPage;


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
    public void unsuccessfulLoginTest(String incorrectLogin, String incorrectPassword){
        loginPage.login(incorrectLogin, incorrectPassword);
        Assertions.assertTrue(loginPage.isOpened());
    }

    @Test
    public void successfulLoginTest(){
        dashBoardPage = loginPage.login(login, password);
        Assertions.assertTrue(dashBoardPage.isOpened());
    }
}
