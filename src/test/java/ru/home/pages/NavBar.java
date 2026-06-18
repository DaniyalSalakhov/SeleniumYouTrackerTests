package ru.home.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavBar {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(css = "[data-test='ring-link issues-button']")
    private WebElement tasksButton;
    @FindBy(css = "[data-test='ring-dropdown create']")
    private WebElement createButton;
    @FindBy(css = "[href='newIssue']")
    private WebElement createTaskButton;

    public NavBar(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void createTask(){
        wait.until(ExpectedConditions.visibilityOf(createButton));
        createButton.click();
        wait.until(ExpectedConditions.visibilityOf(createTaskButton));
        createTaskButton.click();
    }
}
