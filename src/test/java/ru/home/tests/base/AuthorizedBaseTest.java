package ru.home.tests.base;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import ru.home.driver.DriverManager;
import ru.home.pages.LoginPage;

public abstract class AuthorizedBaseTest extends BaseTest{

    @BeforeEach
    public void login(){
        WebDriver driver = DriverManager.getDriver();
        driver.get("http://localhost:8080");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "qwerty007");
    }

}
