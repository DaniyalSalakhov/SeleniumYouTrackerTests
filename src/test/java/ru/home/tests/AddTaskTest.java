package ru.home.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.home.pages.*;
import ru.home.tests.base.BaseTest;
import ru.home.utils.ScreenshotUtils;

import java.time.Duration;

public class AddTaskTest extends BaseTest {

    private DashBoardPage dashBoardPage;

    @BeforeEach
    public void login() {
        driver.get("http://localhost:8080");
        LoginPage loginPage = new LoginPage(driver);
        dashBoardPage = loginPage.login("admin", "qwerty007");
    }


    @ParameterizedTest
    @CsvSource({"taskToAdd"})
    public void createTask(String taskName) {
        CreateTaskPage createTaskPage = dashBoardPage.createTask();
        TaskPage taskPage = createTaskPage.createTask(taskName);
        Assertions.assertEquals(taskName, taskPage.getTaskName());
        taskPage.deleteTask();
    }
}
