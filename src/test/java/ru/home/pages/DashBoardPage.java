package ru.home.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.home.pages.base.BasePage;

public class DashBoardPage extends BasePage {
    private NavBar navBar;
    @FindBy(css = "[data-test='avatar']")
    private WebElement loginAvatar;

    public DashBoardPage(WebDriver driver){
        super(driver);
        navBar = new NavBar(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='avatar']")));
        return loginAvatar.isDisplayed();
    }

    public CreateTaskPage createTask() {
        String currentWindow = driver.getWindowHandle();
        navBar.createTask();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for(String window : driver.getWindowHandles()){
            if(!window.equals(currentWindow)){
                driver.switchTo().window(window);
                break;
            }
        }
        return new CreateTaskPage(driver);
    }

}
