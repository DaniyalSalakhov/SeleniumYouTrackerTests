package ru.home.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.home.pages.CreateTaskPage;
import ru.home.pages.DashBoardPage;
import ru.home.pages.LoginPage;
import ru.home.pages.TasksPage;
import ru.home.tests.base.BaseTest;
import ru.home.utils.ScreenshotUtils;

import java.time.Duration;

public class RemoveTaskTest extends BaseTest {
    private DashBoardPage dashBoardPage;

    @BeforeEach
    public void login() {
        driver.get("http://localhost:8080");
        LoginPage loginPage = new LoginPage(driver);
        dashBoardPage = loginPage.login("admin", "qwerty007");
    }

    @ParameterizedTest
    @CsvSource({"taskToRemove"})
    public void removeTask(String taskName){
        CreateTaskPage createTaskPage = dashBoardPage.createTask();
        createTaskPage.createTask(taskName);
        driver.get("http://localhost:8080/issues");
        TasksPage tasksPage = new TasksPage(driver);
        tasksPage.removeTaskByName(taskName);
        boolean isTaskPresent = tasksPage.isTaskPresent(taskName);
        if(isTaskPresent){
            ScreenshotUtils.takeScreenshots(driver,"removeTask");
        }
        //Сама задача удаляется, но все еще видна после переадресации.
        //Необходимо собственноручно перезагрузить страницу
        Assertions.assertFalse(isTaskPresent);
    }
}
