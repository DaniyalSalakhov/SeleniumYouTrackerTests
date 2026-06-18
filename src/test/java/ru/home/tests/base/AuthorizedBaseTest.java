package ru.home.tests.base;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.home.driver.DriverManager;
import ru.home.pages.DashBoardPage;
import ru.home.pages.LoginPage;

import java.time.Duration;

public abstract class AuthorizedBaseTest extends BaseTest{
    protected DashBoardPage dashBoardPage;

    @BeforeEach
    public void login() {
        driver.get("http://localhost:8080");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "qwerty007");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("/dashboard"));
        driver.get("http://localhost:8080/dashboard");
        dashBoardPage = new DashBoardPage(driver);
    }

}
