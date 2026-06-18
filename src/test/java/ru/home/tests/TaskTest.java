package ru.home.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import ru.home.pages.CreateTaskPage;
import ru.home.pages.TaskPage;
import ru.home.pages.TasksPage;
import ru.home.tests.base.AuthorizedBaseTest;

public class TaskTest extends AuthorizedBaseTest {

    @ParameterizedTest
    @CsvSource({"taskToAdd"})
    public void createTask(String taskName) {
        CreateTaskPage createTaskPage = dashBoardPage.createTask();
        TaskPage taskPage = createTaskPage.createTask(taskName);
        Assertions.assertEquals(taskName, taskPage.getTaskName());
        taskPage.deleteTask();
    }

    @ParameterizedTest
    @CsvSource({"taskToRemove"})
    public void removeTask(String taskName){
        CreateTaskPage createTaskPage = dashBoardPage.createTask();
        createTaskPage.createTask(taskName);
        driver.get("http://localhost:8080/issues");
        TasksPage tasksPage = new TasksPage(driver);
        tasksPage.removeTaskByName(taskName);
        Assertions.assertFalse(tasksPage.isTaskPresent(taskName));
    }
}
