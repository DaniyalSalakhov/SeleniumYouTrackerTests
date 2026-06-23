package ru.home.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.home.pages.*;

public class AddTaskTest extends BaseTest {

    private DashBoardPage dashBoardPage;

    @BeforeEach
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        dashBoardPage = loginPage.login(login, password);
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
