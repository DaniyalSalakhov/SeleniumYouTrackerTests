package ru.home.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TasksPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private NavBar navBar;

    public TasksPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        navBar = new NavBar(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
