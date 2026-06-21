package ru.home.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.home.pages.base.BasePage;


public class TasksPage extends BasePage {

    private NavBar navBar;

    public TasksPage(WebDriver driver){
        super(driver);
        navBar = new NavBar(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isTaskPresent(String taskName){
        By taskLocator = By.xpath(
                "//a[@data-test='ring-link ticket-id' and contains(@href,'/"+taskName+"')]");
        return !driver.findElements(taskLocator).isEmpty();
    }

    public void removeTaskByName(String taskName){
        By taskLocator = By.xpath(
                "//a[@data-test='ring-link ticket-id' and contains(@href,'/"+taskName+"')]");
        wait.until(ExpectedConditions.elementToBeClickable(taskLocator));
        driver.findElement(taskLocator).click();
        TaskPage taskPage = new TaskPage(driver);
        taskPage.deleteTask();
    }
}
