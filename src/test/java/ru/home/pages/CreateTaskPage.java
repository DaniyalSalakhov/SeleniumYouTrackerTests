package ru.home.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CreateTaskPage extends BasePage {
    private NavBar navBar;
    @FindBy(xpath = "//textarea[contains(@data-test,'summary')]")
    private WebElement taskName;
    @FindBy(xpath = "//button[contains(@data-test,'submit-button')]")
    private WebElement createButton;

    public CreateTaskPage(WebDriver driver){
        super(driver);
        navBar = new NavBar(driver);
        PageFactory.initElements(driver, this);
    }

    public TaskPage createTask(String name){
        wait.until(ExpectedConditions.visibilityOfAllElements(taskName));
        taskName.sendKeys(name);
        createButton.click();
        return new TaskPage(driver);
    }
}
