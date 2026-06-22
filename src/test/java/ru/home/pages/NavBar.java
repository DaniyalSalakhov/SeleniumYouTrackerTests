package ru.home.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.home.pages.base.BasePage;

public class NavBar extends BasePage {

    @FindBy(xpath = "//a[contains(@href,'issues')]")
    private WebElement tasksButton;
    @FindBy(xpath = "//div[contains(@data-test,'ring-dropdown create')]")
    private WebElement createButton;
    @FindBy(xpath = "//a[contains(@href,'newIssue')]")
    private WebElement createTaskButton;
    @FindBy(xpath = "//div[contains(@data-test,'ring-dropdown ring-profile')]")
    private WebElement profileEditorButton;
    @FindBy(xpath = "//a[contains(@href,'/users/me')]")
    private WebElement profileButton;
    @FindBy(xpath = "//*[contains(@data-test,'avatar')]")
    private WebElement loginAvatar;

    public NavBar(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void createTask(){
        wait.until(ExpectedConditions.elementToBeClickable(createButton));
        createButton.click();
        wait.until(ExpectedConditions.visibilityOf(createTaskButton));
        createTaskButton.click();
    }

    public TasksPage openTasks(){
        wait.until(ExpectedConditions.elementToBeClickable(tasksButton));
        tasksButton.click();
        return new TasksPage(driver);
    }

    public boolean isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='avatar']")));
        return loginAvatar.isDisplayed();
    }

    public ProfilePage getProfilePage() {
        wait.until(ExpectedConditions.elementToBeClickable(profileEditorButton));
        profileEditorButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(profileButton));
        profileButton.click();
        return new ProfilePage(driver);
    }
}
