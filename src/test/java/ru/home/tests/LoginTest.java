package ru.home.tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
        driver = DriverManager.getDriver();
        driver.get("http://localhost:8080");
        loginPage = new LoginPage(driver);
        dashBoardPage = new DashBoardPage(driver);
    }

    @ParameterizedTest
    @CsvSource({
            "admin, qwerty007, true",
            "incorrectUsername, incorrectPassword, false"
    })
    void successfulLoginTest(String username, String password, String isValid){
        if(Boolean.parseBoolean(isValid)) {
            loginPage.login(username, password);
            Assertions.assertTrue(dashBoardPage.isOpened());
        }
        else{
            loginPage.login(username, password);
            Assertions.assertTrue(loginPage.isOpened());
        }
    }
}
