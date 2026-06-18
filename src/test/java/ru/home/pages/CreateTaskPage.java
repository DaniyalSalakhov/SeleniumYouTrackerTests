package ru.home.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.home.pages.base.AuthorizedBasePage;


public class CreateTaskPage extends AuthorizedBasePage {
    @FindBy(css = "[data-test='summary']")
    private WebElement taskName;
    @FindBy(css = "[data-test='submit-button']")
    private WebElement createButton;

    public CreateTaskPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public TaskPage createTask(String name){
        wait.until(ExpectedConditions.visibilityOfAllElements(taskName));
        taskName.sendKeys(name);
        createButton.click();
        return new TaskPage(driver);
    }
}
