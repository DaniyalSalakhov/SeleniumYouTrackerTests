package ru.home.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TaskPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private NavBar navBar;
    private By taskNameLocator = By.cssSelector("[data-test='ticket-summary']");

    public TaskPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        navBar = new NavBar(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getTaskName(){
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(taskNameLocator, "")));
        return driver.findElement(taskNameLocator).getText();
    }
}
