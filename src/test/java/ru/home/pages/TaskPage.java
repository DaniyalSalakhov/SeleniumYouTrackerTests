package ru.home.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.home.pages.base.BasePage;

public class TaskPage extends BasePage {

    private NavBar navBar;
    private By taskNameLocator = By.cssSelector("[data-test='ticket-summary']");
    private By tooltip = By.cssSelector("[aria-label='Показать больше']");
    private By deleteButton = By.xpath("//*[contains(@id,'delete')]");
    private By confirmationDialog = By.cssSelector("[role='dialog']");
    private By confirmDeleteButton = By.cssSelector("[data-test='confirm-ok-button']");

    public TaskPage(WebDriver driver){
        super(driver);
        navBar = new NavBar(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTaskName(){
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(taskNameLocator, "")));
        return driver.findElement(taskNameLocator).getText();
    }

    public void deleteTask() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tooltip));
        driver.findElement(tooltip).click();
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        driver.findElement(deleteButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationDialog));
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton));
        driver.findElement(confirmDeleteButton).click();
    }
}
