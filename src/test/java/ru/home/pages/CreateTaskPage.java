package ru.home.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateTaskPage {
    private WebDriver driver;
    private NavBar navBar;
    private WebDriverWait wait;
    @FindBy(css = "[data-test='summary']")
    private WebElement taskName;
    @FindBy(css = "[data-test='submit-button']")
    private WebElement createButton;

    public CreateTaskPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        navBar = new NavBar(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public TaskPage createTask(String name){
        wait.until(ExpectedConditions.visibilityOfAllElements(taskName));
        taskName.sendKeys(name);
        createButton.click();
        return new TaskPage(driver);
    }
}
