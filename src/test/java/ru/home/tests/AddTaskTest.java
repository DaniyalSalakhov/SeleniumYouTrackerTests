package ru.home.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import ru.home.driver.DriverManager;
import ru.home.pages.CreateTaskPage;
import ru.home.pages.DashBoardPage;
import ru.home.pages.TaskPage;
import ru.home.tests.base.AuthorizedBaseTest;

public class AddTaskTest extends AuthorizedBaseTest {
    private DashBoardPage dashBoardPage;

    @BeforeEach
    public void setup(){
        WebDriver driver = DriverManager.getDriver();
        driver.get("http://localhost:8080/dashboard");
        dashBoardPage = new DashBoardPage(driver);
    }

    @ParameterizedTest
    @CsvSource({"test"})
    public void createTask(String taskName){
        CreateTaskPage createTaskPage = dashBoardPage.createTask();
        TaskPage taskPage = createTaskPage.createTask(taskName);
        Assertions.assertEquals(taskName, taskPage.getIssueName());
    }
}
