package ru.home.tests;

import org.junit.AfterClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.home.pages.CreateTaskPage;
import ru.home.pages.TaskPage;
import ru.home.tests.base.AuthorizedBaseTest;

public class AddTaskTest extends AuthorizedBaseTest {

    @ParameterizedTest
    @CsvSource({"test"})
    public void createTask(String taskName) {
        CreateTaskPage createTaskPage = dashBoardPage.createTask();
        TaskPage taskPage = createTaskPage.createTask(taskName);
        Assertions.assertEquals(taskName, taskPage.getTaskName());
    }

    @AfterClass
    public static void shutdown(){

    }
}
