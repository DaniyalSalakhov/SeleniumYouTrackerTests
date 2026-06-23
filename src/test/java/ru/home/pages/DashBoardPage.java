package ru.home.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashBoardPage extends BasePage {
    private NavBar navBar;

    public DashBoardPage(WebDriver driver){
        super(driver);
        navBar = new NavBar(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isOpened() {
        return navBar.isOpened();
    }

    public ProfilePage getProfilePage(){
        return navBar.getProfilePage();
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
