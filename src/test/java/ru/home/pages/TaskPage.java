package ru.home.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TaskPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private NavBar navBar;
    @FindBy(css = "[data-test='ticket-summary']")
    private WebElement issueName;

    public TaskPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        navBar = new NavBar(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getIssueName(){
        wait.until(driver -> !issueName.getText().isBlank());
        return issueName.getText();
    }
}
