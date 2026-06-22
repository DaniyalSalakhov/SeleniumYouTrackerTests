package ru.home.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.home.pages.*;
import ru.home.tests.base.BaseTest;
import ru.home.utils.ScreenshotUtils;

public class RemoveTaskTest extends BaseTest {
    private DashBoardPage dashBoardPage;

    @BeforeEach
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        dashBoardPage = loginPage.login("admin", "qwerty007");
    }

    @ParameterizedTest
    @CsvSource({"taskToRemove"})
    public void removeTask(String taskName){
        CreateTaskPage createTaskPage = dashBoardPage.createTask();
        TaskPage taskPage = createTaskPage.createTask(taskName);
        TasksPage tasksPage = taskPage.goToTasks();
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
